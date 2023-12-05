package castleBooker.ui;

import java.awt.EventQueue;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JPanel;

import castleBooker.game.Casilla;
import castleBooker.game.Game;
import castleBooker.sevice.App;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GameUi extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Locale location = new Locale("es");
	private JPanel pnBoard;
	private JPanel pnDice;
	private App app= new App();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
				setButtonsImage();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameUi.class.getResource("/img/icon.png")));
		setBounds(100, 100, 662, 454);
		getContentPane().setLayout(null);
		getContentPane().add(getPnBoard());
		getContentPane().add(getPnDice());

		setTextLocation();
	}
	
	public Locale getLocale() {
		return this.location;
	}

	protected void setLocation(Locale location) {
		this.location = location;
	}

	private void setTextLocation() {
		ResourceBundle textos = ResourceBundle.getBundle("rcs/text",getLocale());
		setTitle(textos.getString("titulo"));
	}
	private JPanel getPnBoard() {
		if (pnBoard == null) {
			pnBoard = new JPanel();
			pnBoard.setBounds(0, 0, 648, 407);
			fillBoard();
		}
		return pnBoard;
	}
	private JPanel getPnDice() {
		if (pnDice == null) {
			pnDice = new JPanel();
			pnDice.setBounds(0, 407, 648, 10);
			pnDice.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		}
		return pnDice;
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
		return Button();
	}
	

	private void setLayout(int row,int columns) {
		getPnBoard().setLayout(new GridLayout(row,0, 0, 0));
	}
	
	private JButton Button() {
		JButton button = new JButton();
		button.setBackground(new Color(240, 240, 240));
		return button;
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
		validate();
	}
	
	private void setImagenAdaptada(JButton boton, String rutaImagen){
		 Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage(); 
		 Image imgEscalada = imgOriginal.getScaledInstance(boton.getWidth(),boton.getHeight(), Image.SCALE_FAST);
		 ImageIcon icon = new ImageIcon(imgEscalada);
		 if(rutaImagen.equals("/img/wall.png")) {
			 disableButton(boton);
			 boton.setDisabledIcon(icon);
		 }
		 boton.setIcon(icon);
		 boton.setBorderPainted(false);
	}

	private void disableButton(JButton boton) {
		boton.setEnabled(false);
	}

	private void setImageButton(JButton button, Casilla casilla) {
		String path = "/img/"+casilla.getImg();
		setImagenAdaptada(button, path);
	}
}
