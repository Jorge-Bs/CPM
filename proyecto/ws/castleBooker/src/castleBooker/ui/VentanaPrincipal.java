package castleBooker.ui;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import castleBooker.sevice.App;
import java.awt.Toolkit;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Locale location = new Locale("es");
	private ResourceBundle textos;
	private App app;
	private JPanel pnInicio;
	private JPanel pnBotones;
	private JButton btnReserva;
	private JButton btnJuego;
	private JButton btnDescuento;
	private JPanel pnBien;
	private JLabel lbBienvenida;
	private GameUi game;
	

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(App app) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Dimension d = getSize();
				System.out.println(d);
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/icon.png")));
		this.app=app;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 566);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPnInicio(), "pnInicio");
		//253,336 dimensions min
		setMinimumSize(new Dimension(380, 504));
		//622 895 dimension max
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
		setTitle(textos.getString("tituloInicio"));
		
		getBtnReserva().setText(textos.getString("reserva"));
		getBtnReserva().setMnemonic(textos.getString("mnemonicReserva").charAt(0));
		
		getBtnJuego().setText(textos.getString("juego"));
		getBtnJuego().setMnemonic(textos.getString("mnemonicJuego").charAt(0));
		
		getBtnDescuento().setText(textos.getString("descuento"));
		getBtnDescuento().setMnemonic(textos.getString("mnemonicDescuento").charAt(0));
	}

	private JPanel getPnInicio() {
		if (pnInicio == null) {
			pnInicio = new JPanel();
			pnInicio.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					changeImagesSize();
				}
			});
			pnInicio.setLayout(new BorderLayout(0, 0));
			pnInicio.add(getPnBotones(), BorderLayout.CENTER);
			pnInicio.add(getPnBien(), BorderLayout.NORTH);
		}
		return pnInicio;
	}
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setLayout(new GridLayout(0, 1, 0, 4));
			pnBotones.add(getBtnReserva());
			pnBotones.add(getBtnJuego());
			pnBotones.add(getBtnDescuento());
		}
		return pnBotones;
	}
	
	private void changeImagesSize() {
		int width= getLbBienvenida().getWidth();
		//width= width>=1000? 1000:width;
		int height=(int) (width/2.0);
		height= height>=400? 400:height;
		getLbBienvenida().setIcon(setImagenAdaptada(width, height, "/img/ING002.png"));
	}
	
	
	private JButton getBtnReserva() {
		if (btnReserva == null) {
			btnReserva = new JButton("New button");
		}
		return btnReserva;
	}
	private JButton getBtnJuego() {
		if (btnJuego == null) {
			btnJuego = new JButton("New button");
			btnJuego.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializarJuego();
				}
			});
		}
		return btnJuego;
	}
	
	private void inicializarJuego() {
		if(game==null) {
			game= new GameUi(app,location);
			game.setVisible(true);
		}else {
			game.inicializar();
			game.setVisible(true);
		}
	}
	private JButton getBtnDescuento() {
		if (btnDescuento == null) {
			btnDescuento = new JButton("New button");
		}
		return btnDescuento;
	}
	private JPanel getPnBien() {
		if (pnBien == null) {
			pnBien = new JPanel();
			pnBien.setLayout(new BorderLayout(0, 0));
			pnBien.add(getLbBienvenida());
		}
		return pnBien;
	}
	private JLabel getLbBienvenida() {
		if (lbBienvenida == null) {
			lbBienvenida = new JLabel("");
			lbBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbBienvenida;
	}
	
	private ImageIcon setImagenAdaptada(int width, int height, String rutaImagen){
		 Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage(); 
		 Image imgEscalada = imgOriginal.getScaledInstance(width,height, Image.SCALE_FAST);
		 ImageIcon icon = new ImageIcon(imgEscalada);
		 return icon;
	}
}
