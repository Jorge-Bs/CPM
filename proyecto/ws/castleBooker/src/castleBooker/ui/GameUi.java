package castleBooker.ui;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JDialog;
import java.awt.Toolkit;


import javax.swing.JPanel;
import javax.swing.UIManager;

import castleBooker.model.game.Casilla;
import castleBooker.model.game.Game;
import castleBooker.sevice.App;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


import javax.swing.JLabel;
import javax.swing.JOptionPane;


import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GameUi extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Locale location;
	private JPanel pnBoard;
	private JPanel pnDiceValue;
	private App app;
	private JPanel PnResult;
	private JPanel pnDic;
	private JLabel lbResult;
	private VentanaConfirmacionEdad vEdad;
	
	private ResourceBundle textos;
	private JButton btDice;
	private ProcesaMovimiento pM = new ProcesaMovimiento();
	private VentanaPrincipal vp;

	/**
	 * Create the dialog.
	 */
	public GameUi(App app,VentanaPrincipal vp) {
		setModal(true);
		this.vp=vp;
		this.app=app;
		this.location=app.getLocation();
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				setImages();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameUi.class.getResource("/img/icon.png")));
		setBounds(100, 100, 661, 712);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().add(getPnBoard());
		getContentPane().add(getPnDiceValue());

		setTextLocation();
		
	}
	
	public Locale getLocale() {
		return this.location;
	}

	protected void setLocation(Locale location) {
		this.location = location;
	}

	private void setTextLocation() {
		textos = ResourceBundle.getBundle("rcs/text",getLocale());
		setTitle(textos.getString("tituloJuego"));
		((TitledBorder)pnDiceValue.getBorder()).setTitle(textos.getString("pnDice"));
		getBtDice().setToolTipText(textos.getString("toolTipDado"));
		
//		UIManager.put("OptionPane.okButtonText", textos.getString("guardar"));
//		UIManager.put("OptionPane.cancelButtonText", textos.getString("salir"));
//		UIManager.put("OptionPane.noButtonText", "pp");
	}
	private JPanel getPnBoard() {
		if (pnBoard == null) {
			pnBoard = new JPanel();
			pnBoard.setBounds(0, 0, 647, 483);
			fillBoard();
		}
		return pnBoard;
	}
	private JPanel getPnDiceValue() {
		if (pnDiceValue == null) {
			pnDiceValue = new JPanel();
			pnDiceValue.setBounds(5, 492, 632, 182);
			pnDiceValue.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnDiceValue.setLayout(null);
			pnDiceValue.add(getPnDic());
			pnDiceValue.add(getPnResult());
		}
		return pnDiceValue;
	}
	
	private void fillBoard() {;
		setLayout(Game.FILAS,Game.COLUMNAS);
		for(int i=0;i<Game.FILAS;i++) {
			for(int j=0;j<Game.COLUMNAS;j++) {
				JButton button = createBoton();
				button.setEnabled(false);
				button.setActionCommand(""+j);
				button.addActionListener(pM);
				pnBoard.add(button);
			}
		}
		validate();
	}

	private JButton createBoton() {
		JButton button = new JButton();
		button.setBackground(new Color(255, 255, 255));
		return button;
	}
	

	private void setLayout(int row,int columns) {
		getPnBoard().setLayout(new GridLayout(row,0, 0, 0));
	}
	
	
	private void setImages() {
		setButtonsImage();
		setDiceImage();
		validate();
	}
	
	private void setButtonsImage(){
		int counter=0;
		for(int i=0;i<Game.FILAS;i++) {
			for(int j=0;j<Game.COLUMNAS;j++) {
				JButton button =(JButton)getPnBoard().getComponent(counter);
				setImageButton(button,app.getCasilla(i, j));
				counter++;
			}
		}
	}
	
	private void setDiceImage() {
		String path= "/img/dice.png";
		String name="dice.png";
		int width=getBtDice().getWidth();
		int height = getBtDice().getHeight();
		ImageIcon img= setImagenAdaptada(width,height, path,name);
		getBtDice().setIcon(img);
		getBtDice().setDisabledIcon(img);
	}
	
	private ImageIcon setImagenAdaptada(int width, int height, String rutaImagen,String name){
		 Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage(); 
		 Image imgEscalada = imgOriginal.getScaledInstance(width,height, Image.SCALE_FAST);
		 ImageIcon icon = new ImageIcon(imgEscalada);
		 icon.setDescription(name);
		 return icon;
	}


	private void setImageButton(JButton button, Casilla casilla) {
		String name=casilla.getImg();
		String path = "/img/"+name;
		int width=button.getWidth();
		int height = button.getHeight();
		
		ImageIcon image = setImagenAdaptada(width,height, path,name);
		button.setDisabledIcon(image);
		button.setBorderPainted(true);
		if(path.equals("/img/wall.png")) {
			 button.setDisabledIcon(image);
			 button.setBorderPainted(false);
		 }
		 
		 button.setIcon(image);
	}
	private JPanel getPnResult() {
		if (PnResult == null) {
			PnResult = new JPanel();
			PnResult.setBounds(320, 20, 305, 144);
			PnResult.setLayout(null);
			PnResult.add(getLbResult());
		}
		return PnResult;
	}
	private JPanel getPnDic() {
		if (pnDic == null) {
			pnDic = new JPanel();
			pnDic.setBounds(5, 20, 321, 144);
			pnDic.setLayout(null);
			pnDic.add(getBtDice());
		}
		return pnDic;
	}
	private JLabel getLbResult() {
		if (lbResult == null) {
			lbResult = new JLabel("");
			lbResult.setBounds(10, 11, 285, 122);
		}
		return lbResult;
	}
	
	
	
	private void lanzar() {
		app.lanzar();
		enableGhostBusterButtons(true);
		pintarResultado();
	}
	
	private void showFinalDialog() {
		if(app.canGetDiscount()) {
			getVEdad().muestraMaxLabel();
			getVEdad().setVisible(true);
		}else {
			String messageNoDiscount = textos.getString("NoDescuento");
			String titleNoDiscount = textos.getString("TituloSinDescuentoFinal");
			JOptionPane.showMessageDialog(null, messageNoDiscount, titleNoDiscount , JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private VentanaConfirmacionEdad getVEdad() {
		if(vEdad==null) {
			vEdad= new VentanaConfirmacionEdad(app,this);
		}
		return vEdad;
	}

	private void pintarResultado() {
		String path = "/img/"+app.getDiceValue()+".png";
		getLbResult().setIcon(setImagenAdaptada(150, 150, path,"2"));
	}
	private JButton getBtDice() {
		if (btDice == null) {
			btDice = new JButton("");
			btDice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lanzar();
					getBtDice().setEnabled(false);
				}
			});
			btDice.setBounds(62, 11, 130, 130);
		}
		return btDice;
	}
	
	private void enableGhostBusterButtons(boolean status) {
		Component[] lista = getPnBoard().getComponents();
		for(Component elemento:lista) {
			JButton ele = (JButton)elemento;
			if(ele.getIcon().toString().equals("ghostBuster.png")) {
				ele.setEnabled(status);
			}

		}
	}
	
	private class ProcesaMovimiento implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			mover(value);
		}

		
	}
	private void mover(String value) {
		int move=Integer.parseInt(value);
		if(app.move(move)) {
			enableGhostBusterButtons(false);
			pintarImagenes(move);
			clearResult();
			checkEnd();
		}
	}
	
	private void pintarImagenes(int value) {
		int counter = value;
		for(int i=0;i<Game.FILAS;i++) {
			JButton button =(JButton)getPnBoard().getComponent(counter);
			setImageButton(button,app.getCasilla(i, value));
			counter+=Game.COLUMNAS;
		}
	}
	
	private void checkEnd() {
		if(!app.isFinishedGame()) {
			getBtDice().setEnabled(true);
		}else {
			showFinalDialog();
		}
	}
	
	private void clearResult() {
		getLbResult().setIcon(null);
	}
	
	public void inicializar() {
		app.inicializarJuego();
		setImages();
		getBtDice().setEnabled(true);
		disableButtons();
		getLbResult().setIcon(null);
		setTextLocation();
		if(vEdad!=null) {
			vEdad.inicializar();
		}
	}
	
	private void disableButtons() {
		Component[] botones = getPnBoard().getComponents();
		for(Component bo:botones) {
			JButton boton = (JButton)bo;
			boton.setEnabled(false);
		}
	}
	
	void salir() {
		dispose();
		vp.cambiarPanelInicio();
	}
	
	void salirReserva() {
		inicializar();
		dispose();
		vp.changeReserva();
	}
	
}
