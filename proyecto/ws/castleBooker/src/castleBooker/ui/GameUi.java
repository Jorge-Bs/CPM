package castleBooker.ui;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JDialog;
import java.awt.Toolkit;


import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JButton;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


import javax.swing.border.TitledBorder;
import castleBooker.model.game.Game;
import castleBooker.sevice.App;

import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;


public class GameUi extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnBoard;
	private JPanel pnDiceValue;
	private App app;
	private JPanel PnResult;
	private JPanel pnDic;
	private JLabel lbResult;
	private VentanaGuardadoDescuento vGuardadoDescuento;
	
	private ResourceBundle textos;
	private JButton btDice;
	private ProcesaMovimiento pM = new ProcesaMovimiento();
	private ProcesaOpcionesMenu menuOpciones = new ProcesaOpcionesMenu();
	private VentanaPrincipal vp;
	private JMenuBar menuBar;
	private JMenu mmJuego;
	private JMenu mmHelp;
	private JMenuItem mmItemNuevaPartida;
	private JMenuItem mmItemSalir;
	private JSeparator separator;
	private JMenuItem mmItenHelp;
	private JPanel pnVolver;
	private JButton btnVolver;
	private JLabel lbMovimientosRestantes;

	/**
	 * Create the dialog.
	 */
	public GameUi(App app,VentanaPrincipal vp) {
		setModal(true);
		this.vp=vp;
		this.app=app;
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				setImages();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameUi.class.getResource("/img/icon.png")));
		setBounds(100, 100, 661, 779);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().add(getPnBoard());
		getContentPane().add(getPnDiceValue());
		getContentPane().add(getPnVolver());
		getContentPane().add(getLbMovimientosRestantes());
		setJMenuBar(getMenuBar());

		setTextLocation();
		crearAyuda();
		
	}
	
	public Locale getLocale() {
		return app.getLocation();
	}


	private void setTextLocation() {
		textos = ResourceBundle.getBundle("rcs/text",getLocale());
		setTitle(textos.getString("tituloJuego"));
		((TitledBorder)pnDiceValue.getBorder()).setTitle(textos.getString("pnDice"));
		getBtDice().setToolTipText(textos.getString("toolTipDado"));
		
		getMmJuego().setText(textos.getString("juegoMenu"));
		getMmJuego().setMnemonic(textos.getString("mnemonicJuegoMenu").charAt(0));
		
		getMmItemNuevaPartida().setText(textos.getString("nuevo"));
		getMmItemNuevaPartida().setMnemonic(textos.getString("mnemonicNuevo").charAt(0));
		
		getMmItemSalir().setText(textos.getString("salir"));
		getMmItemSalir().setMnemonic(textos.getString("mnemonicSalir").charAt(0));
		
		getMmHelp().setText(textos.getString("ayuda"));
		getMmHelp().setMnemonic(textos.getString("mnemonicAyuda").charAt(0));
		
		getMmItenHelp().setText(textos.getString("ayudaJuego"));
		getMmItenHelp().setMnemonic(textos.getString("mnemonicAyudaJuego").charAt(0));
		
		getBtnVolver().setText(textos.getString("volver"));
		getBtnVolver().setMnemonic(textos.getString("mnemonicVolver").charAt(0));
		
		setMovimientosTexto();
		
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
			pnDiceValue.setBounds(5, 520, 632, 182);
			pnDiceValue.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
				setImageButton(button,app.getCasillaImage(i, j));
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


	private void setImageButton(JButton button, String img) {
		String path = "/img/"+img;
		int width=button.getWidth();
		int height = button.getHeight();
		
		ImageIcon image = setImagenAdaptada(width,height, path,img);
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
			inicializar();
		}
	}
	
	private VentanaGuardadoDescuento getVEdad() {
		if(vGuardadoDescuento==null) {
			vGuardadoDescuento= new VentanaGuardadoDescuento(app,this);
		}
		return vGuardadoDescuento;
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
					getBtDice().setToolTipText(null);
					setMovimientosTexto();
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
				if(status) {
					ele.setToolTipText(textos.getString("toolTipCaza"));
				}
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
			setImageButton(button,app.getCasillaImage(i, value));
			counter+=Game.COLUMNAS;
		}
	}
	
	private void checkEnd() {
		if(!app.isFinishedGame()) {
			getBtDice().setEnabled(true);
			getBtDice().setToolTipText(textos.getString("toolTipDado"));
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
		if(vGuardadoDescuento!=null) {
			vGuardadoDescuento.inicializar();
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
	
	void cambiarIdioma() {
		setTextLocation();
		if(vGuardadoDescuento!=null) vGuardadoDescuento.cambiarIdioma();
	}
	
	private JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMmJuego());
			menuBar.add(getMmHelp());
		}
		return menuBar;
	}
	private JMenu getMmJuego() {
		if (mmJuego == null) {
			mmJuego = new JMenu("New menu");
			mmJuego.add(getMmItemNuevaPartida());
			mmJuego.add(getSeparator());
			mmJuego.add(getMmItemSalir());
		}
		return mmJuego;
	}
	private JMenu getMmHelp() {
		if (mmHelp == null) {
			mmHelp = new JMenu("New menu");
			mmHelp.add(getMmItenHelp());
		}
		return mmHelp;
	}
	private JMenuItem getMmItemNuevaPartida() {
		if (mmItemNuevaPartida == null) {
			mmItemNuevaPartida = new JMenuItem("New menu item");
			mmItemNuevaPartida.addActionListener(menuOpciones);
			mmItemNuevaPartida.setActionCommand("nuevo");
		}
		return mmItemNuevaPartida;
	}
	private JMenuItem getMmItemSalir() {
		if (mmItemSalir == null) {
			mmItemSalir = new JMenuItem("New menu item");
			mmItemSalir.addActionListener(menuOpciones);
			mmItemSalir.setActionCommand("salir");
		}
		return mmItemSalir;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMmItenHelp() {
		if (mmItenHelp == null) {
			mmItenHelp = new JMenuItem("New menu item");
		}
		return mmItenHelp;
	}
	
	private class ProcesaOpcionesMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			procesaOpcion(e.getActionCommand());
		}
		
	}
	
	private void procesaOpcion(String id) {
		switch(id) {
		case"nuevo":
			inicializar();
			break;
		case"salir":
			dispose();
			break;
		}
	}
	private JPanel getPnVolver() {
		if (pnVolver == null) {
			pnVolver = new JPanel();
			pnVolver.setBounds(15, 700, 622, 36);
			pnVolver.add(getBtnVolver());
		}
		return pnVolver;
	}
	private JButton getBtnVolver() {
		if (btnVolver == null) {
			btnVolver = new JButton("New button");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salir();
				}
			});
		}
		return btnVolver;
	}
	private JLabel getLbMovimientosRestantes() {
		if (lbMovimientosRestantes == null) {
			lbMovimientosRestantes = new JLabel("New label");
			lbMovimientosRestantes.setHorizontalAlignment(SwingConstants.CENTER);
			lbMovimientosRestantes.setBounds(0, 483, 637, 36);
		}
		return lbMovimientosRestantes;
	}
	
	private void setMovimientosTexto() {
		int movimientos = app.getMovimientosRestantes();
		String info = textos.getString("move")+movimientos;
		getLbMovimientosRestantes().setText(info);
	}
	
	private void crearAyuda() {
		URL hsURL;
		   HelpSet hs;

		    try {
			    	File fichero = new File("help/ayuda.hs");
			    	hsURL = fichero.toURI().toURL();
			        hs = new HelpSet(null, hsURL);
			      }

		    catch (Exception e){
		      System.out.println("Ayuda no encontrada");
		      return;
		   }

		   HelpBroker hb = hs.createHelpBroker();
		   hb.initPresentation();

		   hb.enableHelpKey(getRootPane(),"juego", hs);//habilita la tecla f1
		   //getRootPane incluye todos los paneles de la app
		   
		   //asociar ayuda a un elemento a un elemento de menu
		   hb.enableHelpOnButton(getMmItenHelp(), "juego", hs);
	}
}
