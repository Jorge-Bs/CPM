package castleBooker.ui;

import java.awt.EventQueue;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JDialog;
import java.awt.Toolkit;


import javax.swing.JPanel;

import javax.swing.UIManager;

import castleBooker.game.Casilla;
import castleBooker.game.Game;
import castleBooker.sevice.App;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JButton;

import javax.swing.ImageIcon;
import java.awt.Color;
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
	private Locale location = new Locale("es");
	private JPanel pnBoard;
	private JPanel pnDiceValue;
	private App app= new App();
	private JPanel PnResult;
	private JPanel pnDic;
	private JLabel lbResult;
	
	
	private ResourceBundle textos;
	private JButton btDice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
					GameUi dialog = new GameUi();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public GameUi() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				setImages();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameUi.class.getResource("/img/icon.png")));
		setBounds(100, 100, 661, 712);
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
		setTitle(textos.getString("titulo"));
		((TitledBorder)pnDiceValue.getBorder()).setTitle(textos.getString("pnDice"));
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
		int width=getBtDice().getWidth();
		int height = getBtDice().getHeight();
		getBtDice().setIcon(setImagenAdaptada(width,height, path));
	}
	
	private ImageIcon setImagenAdaptada(int width, int height, String rutaImagen){
		 Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage(); 
		 Image imgEscalada = imgOriginal.getScaledInstance(width,height, Image.SCALE_FAST);
		 ImageIcon icon = new ImageIcon(imgEscalada);
		 icon.setDescription("dice.png");
		 return icon;
	}

	private void disableButton(JButton boton) {
		boton.setEnabled(false);
	}

	private void setImageButton(JButton button, Casilla casilla) {
		String path = "/img/"+casilla.getImg();
		int width=button.getWidth();
		int height = button.getHeight();
		
		ImageIcon image = setImagenAdaptada(width,height, path);
		
		
		if(path.equals("/img/wall.png")) {
			 disableButton(button);
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
		if(!app.isFinishedGame()) {
			app.lanzar();
			pintarResultado();
			System.out.print(app.getDiceValue());
		}else {
			JOptionPane.showMessageDialog(null, textos.getString("finJuego"));
		}
		
	}
	
	private void pintarResultado() {
		String path = "/img/"+ 2+".png";
		getLbResult().setIcon(setImagenAdaptada(150, 150, path));
	}
	private JButton getBtDice() {
		if (btDice == null) {
			btDice = new JButton("");
			btDice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lanzar();
				}
			});
			btDice.setBounds(62, 11, 130, 130);
		}
		return btDice;
	}
}
