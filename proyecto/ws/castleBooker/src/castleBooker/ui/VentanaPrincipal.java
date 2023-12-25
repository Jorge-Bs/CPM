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
	private Locale location;
	private ResourceBundle textos;
	private App app;
	private JPanel pnInicio;
	private JPanel pnBotonesInicio;
	private JButton btnReserva;
	private JButton btnJuego;
	private JButton btnDescuento;
	private JPanel pnBien;
	private JLabel lbBienvenida;
	private GameUi game;
	private VentanaDescuento vd;
	private CambiaVentanasAlPulsar vP = new CambiaVentanasAlPulsar();
	

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(App app) {
		setResizable(false);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Dimension d = getSize();
				System.out.println(d);
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/icon.png")));
		this.app=app;
		this.location=app.getLocation();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setMinimumSize(new Dimension(380, 504));
		setBounds(100, 100, 378, 566);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPnInicio(), "pnInicio");
		//253,336 dimensions min
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
			pnInicio.add(getPnBotonesInicio(), BorderLayout.CENTER);
			pnInicio.add(getPnBien(), BorderLayout.NORTH);
		}
		return pnInicio;
	}
	private JPanel getPnBotonesInicio() {
		if (pnBotonesInicio == null) {
			pnBotonesInicio = new JPanel();
			pnBotonesInicio.setLayout(new GridLayout(0, 1, 0, 4));
			pnBotonesInicio.add(getBtnReserva());
			pnBotonesInicio.add(getBtnJuego());
			pnBotonesInicio.add(getBtnDescuento());
		}
		return pnBotonesInicio;
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
			btnReserva.addActionListener(vP);
			btnReserva.setActionCommand("reserva");
		}
		return btnReserva;
	}
	private JButton getBtnJuego() {
		if (btnJuego == null) {
			btnJuego = new JButton("New button");
			btnJuego.addActionListener(vP);
			btnJuego.setActionCommand("juego");
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
			btnDescuento.addActionListener(vP);
			btnDescuento.setActionCommand("descuento");
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
	
	private class CambiaVentanasAlPulsar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String option = e.getActionCommand();
			switch(option) {
			case "reserva":
				break;
			case "juego":
				inicializarJuego();
				break;
			case "descuento":
				changeDiscount();
				break;
			}
		}
		
	}
	
	private void changeDiscount() {
		if(vd!=null) {
			vd.setVisible(true);
			vd.inicializar();
		}else {
			vd = new VentanaDescuento(app, location);
			vd.setVisible(true);
		}
	}
}
