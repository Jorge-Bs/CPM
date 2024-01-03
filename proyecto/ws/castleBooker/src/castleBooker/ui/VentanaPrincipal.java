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
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	
	private static final int AMOUNT_OF_VISIBLE_PANELS=2;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
	private MenuProcesaBotones pbM = new MenuProcesaBotones();
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
	private JPanel pnCastilloInfo;
	private JPanel pnInfo;
	private JPanel pnImagenCastillo;
	private JPanel pnCaracteristicasCastillo;
	private JPanel pnDescripcionCastillo;
	private JPanel pnBotonesCastilloInfo;
	private JButton btnFechaCastilloInfo;
	private JButton btnVolverCastilloInfo;
	private JLabel lbImagenCastillo;
	private JTextArea txDescripcion;
	private JTextArea txInfo;
	private JPanel pnTextosCastillos;
	private VentanaReserva reserva;
	private JSlider slDinero;
	private JLabel lbPrecioMax;
	private JPanel pnBotonIdioma;
	private JButton btnIdioma;
	private JMenuBar menuBar;
	private JMenu mmBtnBooker;
	private JMenu mmBtnOptions;
	private JMenu mmBtnHelp;
	private JMenuItem mmItemReserva;
	private JMenuItem mmItemJuego;
	private JMenuItem mmItemSalir;
	private JSeparator separator;
	private JMenuItem mmItemDescuento;
	private JMenuItem mmItemThemeDark;
	private JMenuItem mmItemIdiomaEn;
	private JMenuItem mmItemThemeLight;
	private JMenuItem mmItemContenidos;
	private JMenuItem mmItemSobre;
	private JSeparator separator_1;

	

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(App app) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		setResizable(false);
//		addComponentListener(new ComponentAdapter() {
//			@Override
//			public void componentResized(ComponentEvent e) {
//				Dimension d = getSize();
//				System.out.println(d);
//			}
//		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/icon.png")));
		this.app=app;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//setMinimumSize(new Dimension(380, 504));
		//setBounds(100, 100, 378, 566);
		//setBounds(100, 100, 950, 660);
		setBounds(100, 100, 530, 722);
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPnInicio(), "pnInicio");
		contentPane.add(getPnMuestraCastillos(), "pnCastillos");
		contentPane.add(getPnCastilloInfo(), "pnCastilloInfo");
		//253,336 dimensions min
		//622 895 dimension max
		setTextLocation();
		crearAyuda();
	}
	
	private void exit() {
		String mesage = textos.getString("salida");
		String titulo = textos.getString("salidaTitulo");
		if(JOptionPane.showConfirmDialog(null,mesage,titulo,JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public Locale getLocale() {
		return app.getLocation();
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
		
		getBtnFechaCastilloInfo().setText(textos.getString("reservarFecha"));
		getBtnFechaCastilloInfo().setMnemonic(textos.getString("mnemonicReservarFecha").charAt(0));
		
		getBtnVolverCastilloInfo().setText(textos.getString("volver"));
		getBtnVolverCastilloInfo().setMnemonic(textos.getString("mnemonicVolver").charAt(0));
		
		getLbPrecioMax().setText(textos.getString("max")+getSlDinero().getValue());
		
		getMmBtnBooker().setText(textos.getString("reservaMenu"));
		getMmBtnBooker().setMnemonic(textos.getString("mnemonicReservaMenu").charAt(0));
		
		getMmBtnOptions().setText(textos.getString("options"));
		getMmBtnOptions().setMnemonic(textos.getString("mnemonicOptions").charAt(0));
		
		getMmBtnHelp().setText(textos.getString("ayuda"));
		getMmBtnHelp().setMnemonic(textos.getString("mnemonicAyuda").charAt(0));
		
		getMmItemReserva().setText(textos.getString("reserva"));
		getMmItemReserva().setMnemonic(textos.getString("mnemonicReserva").charAt(0));
		
		getMmItemJuego().setText(textos.getString("juego"));
		getMmItemJuego().setMnemonic(textos.getString("mnemonicJuego").charAt(0));
		
		getMmItemDescuento().setText(textos.getString("descuento"));
		getMmItemDescuento().setMnemonic(textos.getString("mnemonicDescuento").charAt(0));
		
		getMmItemSalir().setText(textos.getString("salir"));
		getMmItemSalir().setMnemonic(textos.getString("mnemonicSalir").charAt(0));
		
		getMmItemThemeDark().setText(textos.getString("oscuro"));
		getMmItemThemeDark().setMnemonic(textos.getString("mnemonicOscuro").charAt(0));
		
		getMmItemIdiomaEn().setText(textos.getString("idioma"));
		getMmItemIdiomaEn().setMnemonic(textos.getString("mnemonicIdioma").charAt(0));
		
		getMmItemThemeLight().setText(textos.getString("claro"));
		getMmItemThemeLight().setMnemonic(textos.getString("mnemonicClaro").charAt(0));
		
		getMmItemContenidos().setText(textos.getString("contenidos"));
		getMmItemContenidos().setMnemonic(textos.getString("mnemonicContenidos").charAt(0));
		
		getMmItemSobre().setText(textos.getString("sobre"));
		getMmItemSobre().setMnemonic(textos.getString("mnemonicSobre").charAt(0));
		
		getBtnIdioma().setToolTipText(textos.getString("toolTipIdioma"));
		
		UIManager.put("OptionPane.okButtonText", textos.getString("ok"));
		UIManager.put("OptionPane.cancelButtonText", textos.getString("cancelar"));
		UIManager.put("OptionPane.yesButtonText", textos.getString("si"));
		UIManager.put("OptionPane.noButtonText", textos.getString("no"));
		
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
			game= new GameUi(app,this);
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
			pnBien.add(getPnBotonIdioma(), BorderLayout.NORTH);
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
		getVentanaDescuento().inicializar();
		getVentanaDescuento().setVisible(true);
		if(getPnInicio().isVisible()) {
			inicializarDatos();
		}
	}
	
	void cambiarPanelInicio() {
		CardLayout cd = (CardLayout)getContentPane().getLayout();
		inicializarDatos();
		cd.show(contentPane, "pnInicio");
		setExtendedState(JFrame.NORMAL);
		getPnConFiltros().setVisible(false);
		setVisible(false);
		setResizable(false);
		setBounds(100, 100, 530, 722);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	void inicializarDatos() {
		app.inicializar();
		getVentanaReserva().inicializar();
		disableFilter();
	}
	
	private VentanaReserva getVentanaReserva() {
		if(reserva== null) {
			reserva = new VentanaReserva(this,app);
		}
		return reserva;
	}
	
	private VentanaDescuento  getVentanaDescuento() {
		if(vd == null) {
			vd = new VentanaDescuento(app,this);
		}
		return vd;
	}
	
	private void changeDarkTheme() {
		getMmItemThemeDark().setVisible(false);
		getMmItemThemeLight().setVisible(true);
		try {
		    UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
		    updateTheme();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		disableFilter();

	}
	
	private void changeLightTheme() {
		getMmItemThemeDark().setVisible(true);
		getMmItemThemeLight().setVisible(false);
		try {
		    UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
		    updateTheme();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		disableFilter();
	}
	
	private void updateTheme() {
		SwingUtilities.updateComponentTreeUI(this);
		if(game!=null) {
			SwingUtilities.updateComponentTreeUI(game);
		}
		if(vd!=null) {
			SwingUtilities.updateComponentTreeUI(vd);
		}if(reserva!=null) {
			SwingUtilities.updateComponentTreeUI(reserva);
		}if(pnCastle!=null){
			SwingUtilities.updateComponentTreeUI(pnCastle);
		}

	}
	
	
//-------------------------------------------------------------------------------------------------------------------------	
	 void changeReserva() {
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
			if(app.getAmountOfData()!=0) {
				loadImagesAndDescription();
				pnCastle.addComponentListener(new ComponentAdapter() {
					@Override
					public void componentResized(ComponentEvent e) {
						JPanel panel =(JPanel) getPnCastle().getPanel(getPnCastle().getScrollPosition());
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
			}else {
				addNoFound();
			}
		}
		return pnCastle;
	}
	
	private void addNoFound() {
		JOptionPane.showMessageDialog(null, textos.getString("sinDatos"));
	}
	
	private void procesarCastillo(JPanel panel) {
		String id =((Icon)(((JLabel) panel.getComponent(0)).getIcon())).toString();
		cambiarPanelCastillo(id);
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
			pnConFiltros.add(getLbPrecioMax());
			pnConFiltros.add(getSlDinero());
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
		cambiar(filtros,getSlDinero().getValue());
	}
	
	
	private void cambiar(List<String> filtros,int dinero) {
		app.setCastles(filtros,dinero);
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
		cambiar(null,app.getMaxPrice());
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
	
	private void cambiarPanelCastillos() {
		CardLayout cd = (CardLayout)getContentPane().getLayout();
		cd.show(contentPane, "pnCastillos");
		setVisible(false);
		setResizable(true);
		setBounds(100, 100, 950, 660);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
//-----------------------------------------------------------------------------------------------------------------------------	
	
	private void cambiarPanelCastillo(String id) {
		CardLayout cd = (CardLayout)getContentPane().getLayout();
		setExtendedState(JFrame.NORMAL);
		setVisible(false);
		setResizable(false);
		setBounds(100, 100, 530, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		cd.show(contentPane, "pnCastilloInfo");
		loadCastleImg(id);
		loadCastleInfo(id);
		loadCastleDescription(id);
		getBtnFechaCastilloInfo().setActionCommand(id);
	}
	
	
	
	
	private void loadCastleDescription(String id) {
		JTextArea area = getTxDescripcion();
		area.setText(app.getCastleDecription(id));
	}

	private void loadCastleInfo(String id) {
		String info = app.getCastleInfo(id);
		getTxInfo().setText(info);
		
	}

	private void loadCastleImg(String id) {
		String path = "/img/"+id+".png";
		JLabel label = (JLabel) getPnImagenCastillo().getComponent(0);
		ImageIcon icon =setImagenAdaptada(300, 200, path);
		icon.setDescription(id);
		label.setIcon(icon);
	}

	private JPanel getPnCastilloInfo() {
		if (pnCastilloInfo == null) {
			pnCastilloInfo = new JPanel();
			pnCastilloInfo.setLayout(new BorderLayout(0, 0));
			pnCastilloInfo.add(getPnInfo());
			pnCastilloInfo.add(getPnBotonesCastilloInfo(), BorderLayout.SOUTH);
		}
		return pnCastilloInfo;
	}
	private JPanel getPnInfo() {
		if (pnInfo == null) {
			pnInfo = new JPanel();
			pnInfo.setLayout(new BorderLayout(0, 0));
			pnInfo.add(getPnImagenCastillo(), BorderLayout.NORTH);
			pnInfo.add(getPnTextosCastillos());
		}
		return pnInfo;
	}
	private JPanel getPnImagenCastillo() {
		if (pnImagenCastillo == null) {
			pnImagenCastillo = new JPanel();
			pnImagenCastillo.add(getLbImagenCastillo());
		}
		return pnImagenCastillo;
	}
	private JPanel getPnCaracteristicasCastillo() {
		if (pnCaracteristicasCastillo == null) {
			pnCaracteristicasCastillo = new JPanel();
			pnCaracteristicasCastillo.setLayout(new BorderLayout(0, 0));
			pnCaracteristicasCastillo.add(getTxInfo());
		}
		return pnCaracteristicasCastillo;
	}
	private JPanel getPnDescripcionCastillo() {
		if (pnDescripcionCastillo == null) {
			pnDescripcionCastillo = new JPanel();
			pnDescripcionCastillo.setLayout(new BorderLayout(0, 0));
			pnDescripcionCastillo.add(getTxDescripcion());
		}
		return pnDescripcionCastillo;
	}
	private JPanel getPnBotonesCastilloInfo() {
		if (pnBotonesCastilloInfo == null) {
			pnBotonesCastilloInfo = new JPanel();
			pnBotonesCastilloInfo.add(getBtnFechaCastilloInfo());
			pnBotonesCastilloInfo.add(getBtnVolverCastilloInfo());
		}
		return pnBotonesCastilloInfo;
	}
	private JButton getBtnFechaCastilloInfo() {
		if (btnFechaCastilloInfo == null) {
			btnFechaCastilloInfo = new JButton("");
			btnFechaCastilloInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearReserva(e.getActionCommand());
				}
			});
		}
		return btnFechaCastilloInfo;
	}

	private void crearReserva(String id) {
		app.iniciarReserva(id);
		getVentanaReserva().updateDate();
		getVentanaReserva().setVisible(true);
	}
	
	
	private JButton getBtnVolverCastilloInfo() {
		if (btnVolverCastilloInfo == null) {
			btnVolverCastilloInfo = new JButton("");
			btnVolverCastilloInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarPanelCastillos();
				}
			});
		}
		return btnVolverCastilloInfo;
	}
	private JLabel getLbImagenCastillo() {
		if (lbImagenCastillo == null) {
			lbImagenCastillo = new JLabel("");
		}
		return lbImagenCastillo;
	}
	private JTextArea getTxDescripcion() {
		if (txDescripcion == null) {
			txDescripcion = new JTextArea();
			txDescripcion.setOpaque(false);
			txDescripcion.setEditable(false);
			txDescripcion.setBackground(new Color(240, 240, 240));
			txDescripcion.setFont(new Font("Calibri", Font.PLAIN, 18));
			txDescripcion.setWrapStyleWord(true);
			txDescripcion.setLineWrap(true);
		}
		return txDescripcion;
	}
	private JTextArea getTxInfo() {
		if (txInfo == null) {
			txInfo = new JTextArea();
			txInfo.setOpaque(false);
			txInfo.setEditable(false);
			txInfo.setBackground(new Color(240, 240, 240));
			txInfo.setFont(new Font("Calibri", Font.PLAIN, 18));
			txInfo.setLineWrap(true);
			txInfo.setWrapStyleWord(true);
		}
		return txInfo;
	}
	private JPanel getPnTextosCastillos() {
		if (pnTextosCastillos == null) {
			pnTextosCastillos = new JPanel();
			pnTextosCastillos.setLayout(new BorderLayout(0, 10));
			pnTextosCastillos.add(getPnCaracteristicasCastillo(), BorderLayout.NORTH);
			pnTextosCastillos.add(getPnDescripcionCastillo());
		}
		return pnTextosCastillos;
	}
	private JSlider getSlDinero() {
		if (slDinero == null) {
			slDinero = new JSlider();
			slDinero.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					if(textos!=null) {
						cambiarTextos();
					}
				}
			});
			int value = app.getMaxPrice();
			slDinero.setMaximum(value);
			slDinero.setMinimum(app.getMinPrice());
			slDinero.setValue(value);
		}
		return slDinero;
	}
	
	private void cambiarTextos() {
		getLbPrecioMax().setText(textos.getString("max")+getSlDinero().getValue());
	}
	
	private JLabel getLbPrecioMax() {
		if (lbPrecioMax == null) {
			lbPrecioMax = new JLabel("New label");
		}
		return lbPrecioMax;
	}
	private JPanel getPnBotonIdioma() {
		if (pnBotonIdioma == null) {
			pnBotonIdioma = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBotonIdioma.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBotonIdioma.add(getBtnIdioma());
		}
		return pnBotonIdioma;
	}
	private JButton getBtnIdioma() {
		if (btnIdioma == null) {
			btnIdioma = new JButton("");
			ImageIcon icon =setImagenAdaptada(20, 20, "/img/en.png");
			icon.setDescription("en");
			btnIdioma.setIcon(icon);
			btnIdioma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modificarIdioma();
				}
			});
		}
		return btnIdioma;
	}
	
	void modificarIdioma() {
		app.setLocation(new Locale(btnIdioma.getIcon().toString()));
		setTextLocation();
		changeFlag();
		cambiarIdioma();
		if(getContentPane().getComponent(2).isVisible()) {
			cambiarPanelCastillo(getLbImagenCastillo().getIcon().toString());
		}
	}
	
	private void changeFlag() {
		if(getBtnIdioma().getIcon().toString().equals("en")){
			ImageIcon icon =setImagenAdaptada(20, 20, "/img/es.png");
			icon.setDescription("es");
			getBtnIdioma().setIcon(icon);
		}else {
			ImageIcon icon =setImagenAdaptada(20, 20, "/img/en.png");
			icon.setDescription("en");
			getBtnIdioma().setIcon(icon);
		}
	}
	
	void cambiarIdioma() {
		setTextLocation();
		disableFilter();
		if(reserva!=null) reserva.cambiarIdioma();
		if(game!=null) game.cambiarIdioma();
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMmBtnBooker());
			menuBar.add(getMmBtnOptions());
			menuBar.add(getMmBtnHelp());
		}
		return menuBar;
	}
	private JMenu getMmBtnBooker() {
		if (mmBtnBooker == null) {
			mmBtnBooker = new JMenu("New menu");
			mmBtnBooker.add(getMmItemReserva());
			mmBtnBooker.add(getMmItemJuego());
			mmBtnBooker.add(getMmItemDescuento());
			mmBtnBooker.add(getSeparator());
			mmBtnBooker.add(getMmItemSalir());
		}
		return mmBtnBooker;
	}
	private JMenu getMmBtnOptions() {
		if (mmBtnOptions == null) {
			mmBtnOptions = new JMenu("New menu");
			mmBtnOptions.add(getMmItemThemeDark());
			mmBtnOptions.add(getMmItemThemeLight());
			mmBtnOptions.add(getMmItemIdiomaEn());
		}
		return mmBtnOptions;
	}
	private JMenu getMmBtnHelp() {
		if (mmBtnHelp == null) {
			mmBtnHelp = new JMenu("New menu");
			mmBtnHelp.add(getMmItemContenidos());
			mmBtnHelp.add(getSeparator_1());
			mmBtnHelp.add(getMmItemSobre());
		}
		return mmBtnHelp;
	}
	private JMenuItem getMmItemReserva() {
		if (mmItemReserva == null) {
			mmItemReserva = new JMenuItem("New menu item");
			mmItemReserva.setActionCommand("reservaMenu");
			mmItemReserva.addActionListener(pbM);
		}
		return mmItemReserva;
	}
	private JMenuItem getMmItemJuego() {
		if (mmItemJuego == null) {
			mmItemJuego = new JMenuItem("New menu item");
			mmItemJuego.setActionCommand("juegoMenu");
			mmItemJuego.addActionListener(pbM);
		}
		return mmItemJuego;
	}
	private JMenuItem getMmItemSalir() {
		if (mmItemSalir == null) {
			mmItemSalir = new JMenuItem("New menu item");
			mmItemSalir.addActionListener(pbM);
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
	private JMenuItem getMmItemDescuento() {
		if (mmItemDescuento == null) {
			mmItemDescuento = new JMenuItem("New menu item");
			mmItemDescuento.setActionCommand("descuentoMenu");
			mmItemDescuento.addActionListener(pbM);
		}
		return mmItemDescuento;
	}
	
	private class MenuProcesaBotones implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String id = e.getActionCommand();
			procesaCambios(id);
		}
		
	}
	
	private void procesaCambios(String id) {
		switch(id) {
		case "reservaMenu":
			cambiarPanelCastillos();
			break;
		case "juegoMenu":
			inicializarJuego();
			break;
		case "descuentoMenu":
			changeDiscount();
			break;
		case "temaOscuro":
			changeDarkTheme();
			break;
		case "idioma":
			modificarIdioma();
			break;
		case "temaClaro":
			changeLightTheme();
			break;
		case "about":
			JOptionPane.showMessageDialog(null, textos.getString("about"));
			break;
		case "salir":
			exit();
			break;
		}
	}
	private JMenuItem getMmItemThemeDark() {
		if (mmItemThemeDark == null) {
			mmItemThemeDark = new JMenuItem("New menu item");
			mmItemThemeDark.addActionListener(pbM);
			mmItemThemeDark.setActionCommand("temaOscuro");
		}
		return mmItemThemeDark;
	}
	private JMenuItem getMmItemIdiomaEn() {
		if (mmItemIdiomaEn == null) {
			mmItemIdiomaEn = new JMenuItem("New menu item");
			mmItemIdiomaEn.addActionListener(pbM);
			mmItemIdiomaEn.setActionCommand("idioma");
		}
		return mmItemIdiomaEn;
	}
	private JMenuItem getMmItemThemeLight() {
		if (mmItemThemeLight == null) {
			mmItemThemeLight = new JMenuItem("New menu item");
			mmItemThemeLight.addActionListener(pbM);
			mmItemThemeLight.setActionCommand("temaClaro");
			mmItemThemeLight.setVisible(false);
		}
		return mmItemThemeLight;
	}
	private JMenuItem getMmItemContenidos() {
		if (mmItemContenidos == null) {
			mmItemContenidos = new JMenuItem("New menu item");
			mmItemContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mmItemContenidos;
	}
	private JMenuItem getMmItemSobre() {
		if (mmItemSobre == null) {
			mmItemSobre = new JMenuItem("New menu item");
			mmItemSobre.addActionListener(pbM);
			mmItemSobre.setActionCommand("about");
		}
		return mmItemSobre;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
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

		   hb.enableHelpKey(getRootPane(),"inicio", hs);//habilita la tecla f1
		   //getRootPane incluye todos los paneles de la app
		   
		   //asociar ayuda a un elemento a un elemento de menu
		   hb.enableHelpOnButton(getMmItemContenidos(), "inicio", hs);
		   hb.enableHelpOnButton(getBtnAyuda(), "reserva", hs);
//		   
//		   //ayuda sensible a un componente el componete tiene que estar activo y seleccionado
		   hb.enableHelp(getPnCastle(), "reserva", hs);
		   hb.enableHelp(getPnConFiltros(), "filtro", hs);
		   hb.enableHelp(getPnCastilloInfo(), "reserva", hs);
	}
}
