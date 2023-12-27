package castleBooker.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import castleBooker.sevice.App;
import castleBooker.ui.frame.JScrollPanelWithPanel;

import java.awt.Toolkit;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import java.awt.Font;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	
	private static final int AMOUNT_OF_VISIBLE_PANELS=2;
	
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
	private JPanel pnMuestraCastillos;
	private JScrollPanelWithPanel pnCastle;
	private JPanel pnBotonVolver;
	private JButton btnVolver;
	private JPanel pnNorteVentanaCastillos;
	private JButton btnFiltro;
	private JButton btnAyuda;
	private JPanel pnConFiltros;
	private JButton btnAplicar;
	private JPanel panelBtnAplicar;
	private JButton btnRestaurar;
	private JLabel lbEligeCastillo;
	private JPanel pnBotonesFiltroAyuda;
	private JPanel pnLabelMensa;

	

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
		//setBounds(100, 100, 950, 660);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPnInicio(), "pnInicio");
		contentPane.add(getPnMuestraCastillos(), "pnCastillos");
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
		
		getBtnVolver().setText(textos.getString("volver"));
		getBtnVolver().setMnemonic(textos.getString("mnemonicVolver").charAt(0));
		
		getBtnFiltro().setToolTipText(textos.getString("toolTipFiltro"));
		getBtnAyuda().setToolTipText(textos.getString("toolTipAyuda"));
		
		getBtnAplicar().setText(textos.getString("aplicarFiltro"));
		getBtnAplicar().setMnemonic(textos.getString("mnemonicAplicarFiltro").charAt(0));
		
		getBtnRestaurar().setText(textos.getString("restaurar"));
		getBtnRestaurar().setMnemonic(textos.getString("mnemonicRestaurar").charAt(0));
		
		getLbEligeCastillo().setText(textos.getString("eligeCastillo"));
		
		addTextFiltro(textos);
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
				changeReserva();
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
			vd = new VentanaDescuento(app);
			vd.setVisible(true);
		}
	}
	
	private void cambiarPanelInicio() {
		CardLayout cd = (CardLayout)getContentPane().getLayout();
		cd.show(contentPane, "pnInicio");
		disableFilter();
		setExtendedState(JFrame.NORMAL);
		getPnConFiltros().setVisible(false);
		setVisible(false);
		setResizable(false);
		setBounds(100, 100, 378, 566);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	
	
//-------------------------------------------------------------------------------------------------------------------------	
	private void changeReserva() {
		CardLayout cd = (CardLayout)getContentPane().getLayout();
		cd.show(contentPane, "pnCastillos");
		setVisible(false);
		setBounds(100, 100, 950, 660);
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
	}
	
	private JPanel getPnMuestraCastillos() {
		if (pnMuestraCastillos == null) {
			pnMuestraCastillos = new JPanel();
			pnMuestraCastillos.setLayout(new BorderLayout(0, 0));
			pnMuestraCastillos.add(getPnBotonVolver(), BorderLayout.SOUTH);
			pnMuestraCastillos.add(getPnCastle(),BorderLayout.CENTER);
			pnMuestraCastillos.add(getPnNorteVentanaCastillos(), BorderLayout.NORTH);
			pnMuestraCastillos.add(getPnConFiltros(), BorderLayout.EAST);
		}
		return pnMuestraCastillos;
	}
	
	private void loadImagesAndDescription() {
	for(int i=0;i<app.getAmountOfData();i++) {
		JPanel panel = pnCastle.getPanel(i);
		loadData(panel,i);
	}
	
}

	private JScrollPanelWithPanel getPnCastle() {
		if (pnCastle == null) {
			pnCastle= new JScrollPanelWithPanel(app.getAmountOfData(), AMOUNT_OF_VISIBLE_PANELS);
			loadImagesAndDescription();
			pnCastle.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					JPanel panel =(JPanel) getPnCastle().getPanel(0);
					int width=panel.getWidth()/panel.getComponentCount();
					int height = (int) (panel.getHeight());
					actualizarImagenes(width,height);
				}
			});
			pnCastle.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JPanel panel = (JPanel) e.getSource();
					procesarCastillo(panel);
				}
			});
		}
		return pnCastle;
	}
	
	private void procesarCastillo(JPanel panel) {
		String id =((Icon)(((JLabel) panel.getComponent(0)).getIcon())).toString();
		System.out.println(id);
	}
	
	private void actualizarImagenes(int width, int height) {
		for(int i=0;i<getPnCastle().amountOfPanels();i++) {
			JPanel panel = getPnCastle().getPanel(i);
			actualizarImagen(width, height, panel);
		}
		
	}
	
	private void actualizarImagen(int width,int height,JPanel panel) {
		JLabel lb = (JLabel) panel.getComponent(0);
		String id = lb.getIcon().toString();
		String path= "/img/"+id+".png"; 
		ImageIcon icon =setImagenAdaptada(width, height,path);
		icon.setDescription(id);
		lb.setIcon(icon);
	}
	
	private void loadData(JPanel panel,int index) {
		panel.setLayout(new GridLayout(0,2));
		loadImage(panel,index);
		loadDescription(panel,index);
	}
	
	private void loadDescription(JPanel panel, int index) {
		String description = app.getInfo(index);
		JTextArea texto = new JTextArea(description);
		texto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JTextArea txArea = (JTextArea)e.getSource();
				JPanel panel = (JPanel) txArea.getParent();
				procesarCastillo(panel);
			}
		});
		texto.setEditable(false);
		texto.setLineWrap(true);
		texto.setWrapStyleWord(true);
		panel.add(texto);
		
	}

	private void loadImage(JPanel panel, int index) {
		String path= "/img/"+app.getCastleImage(index)+".png";
		JLabel lb = new JLabel();
		ImageIcon icon = new ImageIcon(getClass().getResource(path));
		icon.setDescription(app.getCastleImage(index)+"");
		lb.setIcon(icon);
		panel.add(lb);
	}
	
	
	private JPanel getPnBotonVolver() {
		if (pnBotonVolver == null) {
			pnBotonVolver = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBotonVolver.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBotonVolver.add(getBtnVolver());
		}
		return pnBotonVolver;
	}
	private JButton getBtnVolver() {
		if (btnVolver == null) {
			btnVolver = new JButton("");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarPanelInicio();
				}
			});
		}
		return btnVolver;
	}
	private JPanel getPnNorteVentanaCastillos() {
		if (pnNorteVentanaCastillos == null) {
			pnNorteVentanaCastillos = new JPanel();
			pnNorteVentanaCastillos.setLayout(new GridLayout(0, 2, 0, 0));
			pnNorteVentanaCastillos.add(getPnLabelMensa());
			pnNorteVentanaCastillos.add(getPnBotonesFiltroAyuda());	
		}
		return pnNorteVentanaCastillos;
	}
	private JButton getBtnFiltro() {
		if (btnFiltro == null) {
			btnFiltro = new JButton("");
			btnFiltro.setIcon(setImagenAdaptada(25, 25, "/img/filtro.png"));
			btnFiltro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarEstadoPanelFiltro();
				}
			});
		}
		return btnFiltro;
	}
	
	private void cambiarEstadoPanelFiltro() {
		getPnConFiltros().setVisible(!getPnConFiltros().isVisible());
	}
	
	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton("");
			btnAyuda.setIcon(setImagenAdaptada(25, 25, "/img/help.png"));
		}
		return btnAyuda;
	}
	private JPanel getPnConFiltros() {
		if (pnConFiltros == null) {
			pnConFiltros = new JPanel();
			pnConFiltros.setVisible(false);
			pnConFiltros.setLayout(new GridLayout(0, 1, 0, 0));
			addCheckBox();
			pnConFiltros.add(getPanelBtnAplicar());
		}
		return pnConFiltros;
	}
	
	private void addCheckBox() {
		int number= app.getAmountOfEnchantments();
		for(int i=0;i<number;i++) {
			JCheckBox box = new JCheckBox();
			getPnConFiltros().add(box);
		}
	}
	
	
	
	private JButton getBtnAplicar() {
		if (btnAplicar == null) {
			btnAplicar = new JButton("");
			btnAplicar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarInformacion();
				}
			});
		}
		return btnAplicar;
	}
	
	private void cambiarInformacion() {
		JPanel pnInfo = getPnConFiltros();
		List<String> filtros = new ArrayList<>();
		for(int i=0;i<app.getAmountOfEnchantments();i++) {
			JCheckBox box =(JCheckBox) pnInfo.getComponent(i);
			if(box.isSelected()) {
				filtros.add(box.getActionCommand());
			}
		}
		cambiar(filtros);
	}
	
	
	private void cambiar(List<String> filtros) {
		app.setCastles(filtros);
		pnMuestraCastillos.remove(getPnCastle());
		repaint();
		pnCastle=null;
		pnMuestraCastillos.add(getPnCastle());
		validate();
	}

	private JPanel getPanelBtnAplicar() {
		if (panelBtnAplicar == null) {
			panelBtnAplicar = new JPanel();
			panelBtnAplicar.add(getBtnAplicar());
			panelBtnAplicar.add(getBtnRestaurar());
		}
		return panelBtnAplicar;
	}
	
	private void addTextFiltro(ResourceBundle textos) {
		JPanel panel = getPnConFiltros();
		for(int i=0;i<app.getAmountOfEnchantments();i++) {
			JCheckBox box = (JCheckBox) panel.getComponent(i);
			String tipo = app.getEnchantment(i);
			String texto = textos.getString(tipo);
			texto=tipo+"-"+texto;
			box.setText(texto);
			box.setActionCommand(tipo);
			box.setDisplayedMnemonicIndex(0);
		}
	}
	private JButton getBtnRestaurar() {
		if (btnRestaurar == null) {
			btnRestaurar = new JButton("");
			btnRestaurar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					disableFilter();
				}
			});
		}
		return btnRestaurar;
	}
	
	private void disableFilter() {
		cambiar(null);
		JPanel pnInfo = getPnConFiltros();
		for(int i=0;i<app.getAmountOfEnchantments();i++) {
			JCheckBox box =(JCheckBox) pnInfo.getComponent(i);
			if(box.isSelected()) {
				box.setSelected(false);
			}
		}
	}
	private JLabel getLbEligeCastillo() {
		if (lbEligeCastillo == null) {
			lbEligeCastillo = new JLabel("");
			lbEligeCastillo.setFont(new Font("Tahoma", Font.ITALIC, 19));
		}
		return lbEligeCastillo;
	}
	private JPanel getPnBotonesFiltroAyuda() {
		if (pnBotonesFiltroAyuda == null) {
			pnBotonesFiltroAyuda = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBotonesFiltroAyuda.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBotonesFiltroAyuda.add(getBtnFiltro());
			pnBotonesFiltroAyuda.add(getBtnAyuda());
		}
		return pnBotonesFiltroAyuda;
	}
	private JPanel getPnLabelMensa() {
		if (pnLabelMensa == null) {
			pnLabelMensa = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnLabelMensa.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnLabelMensa.add(getLbEligeCastillo());
		}
		return pnLabelMensa;
	}
}
