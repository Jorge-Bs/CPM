package uo.cpm.s4.ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private FocoGanado fg= new FocoGanado();
	private BordersColor bc= new BordersColor();
	private ProcesaCara pc= new ProcesaCara();
	private JPanel contentPane;
	private JMenuBar barraMenu;
	private JToolBar barraHerramientas;
	private JButton btNuevo;
	private JButton btGuardar;
	private JButton btAbrir;
	private JButton btImprimir;
	private JPanel barraEstado;
	private JPanel pnTextos;
	private JScrollPane scOriginal;
	private JScrollPane scTraducido;
	private JTextArea arOriginal;
	private JTextArea arTraducido;
	private JButton btEspanol;
	private JButton btFrances;
	private JButton btIngles;
	private JLabel etDocOriginal;
	private JLabel etIdOriginal;
	private JLabel etDocTraducido;
	private JLabel etIdTraducido;
	private JMenu menuArchivo;
	private JMenu menuEditar;
	private JMenu menuTraducir;
	private JMenu menuHerramientas;
	private JMenu menuAyuda;
	private JMenuItem itGuardarComo;
	private JMenuItem itNuevo;
	private JMenuItem itSalir;
	private JCheckBox jchCarac;

	
	private JMenuBar getBarraMenu() {
		if (barraMenu == null) {
			barraMenu = new JMenuBar();
			barraMenu.add(getMenuArchivo());
			barraMenu.add(getMenuEditar());
			barraMenu.add(getMenuTraducir());
			barraMenu.add(getMenuHerramientas());
			barraMenu.add(getMenuAyuda());
		}
		return barraMenu;
	}

	private JToolBar getBarraHerramientas() {
		if (barraHerramientas == null) {
			barraHerramientas = new JToolBar();
			barraHerramientas.setBackground(new java.awt.Color(208,204,204));
			barraHerramientas.add(getBtNuevo());
			barraHerramientas.add(getBtAbrir());
			barraHerramientas.add(getBtGuardar());
			barraHerramientas.add(getBtImprimir());
			barraHerramientas.add(getBtIngles());
			barraHerramientas.add(getBtEspanol());
			barraHerramientas.add(getBtFrances());
			barraHerramientas.add(getJchCarac());
		}
		return barraHerramientas;
	}

	private JButton getBtNuevo() {
		if (btNuevo == null) {
			btNuevo = new JButton();
			btNuevo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Nuevo.png")));
			btNuevo.setBorderPainted(false);
			btNuevo.setContentAreaFilled(false);
			btNuevo.setFocusPainted(false);
			btNuevo.addMouseListener(bc);
			btNuevo.setPreferredSize(new java.awt.Dimension(24,24));
			btNuevo.setMaximumSize(new java.awt.Dimension(24,24));
			btNuevo.setMinimumSize(new java.awt.Dimension(24,24));
			btNuevo.setMargin(new java.awt.Insets(0,0,0,0));
		}
		return btNuevo;
	}

	private JButton getBtGuardar() {
		if (btGuardar == null) {
			btGuardar = new JButton();
			btGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String panel = JOptionPane.showInputDialog("Inserta el nombre del archivo:");
					getEtDocOriginal().setText(panel);
				}
			});
			btGuardar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Guardar.png")));
			btGuardar.setBorderPainted(false);
			btGuardar.addMouseListener(bc);
			btGuardar.setContentAreaFilled(false);
			btGuardar.setPreferredSize(new java.awt.Dimension(24,24));
			btGuardar.setMaximumSize(new java.awt.Dimension(24,24));
			btGuardar.setMinimumSize(new java.awt.Dimension(24,24));
			btGuardar.setMargin(new java.awt.Insets(0,0,0,0));
		}
		return btGuardar;
	}

	private JButton getBtAbrir() {
		if (btAbrir == null) {
			btAbrir = new JButton();
			btAbrir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Abrir.png")));
			btAbrir.setBorderPainted(false);
			btAbrir.addMouseListener(bc);
			btAbrir.setContentAreaFilled(false);
			btAbrir.setMaximumSize(new java.awt.Dimension(24,24));
			btAbrir.setMinimumSize(new java.awt.Dimension(24,24));
			btAbrir.setPreferredSize(new java.awt.Dimension(24,24));
			btAbrir.setMargin(new java.awt.Insets(0,0,0,0));
		}
		return btAbrir;
	}

	private JButton getBtImprimir() {
		if (btImprimir == null) {
			btImprimir = new JButton();
			btImprimir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Imprimir.png")));
			btImprimir.setBorderPainted(false);
			btImprimir.addMouseListener(bc);
			btImprimir.setContentAreaFilled(false);
			btImprimir.setMaximumSize(new java.awt.Dimension(24,24));
			btImprimir.setMinimumSize(new java.awt.Dimension(24,24));
			btImprimir.setMargin(new java.awt.Insets(0,0,0,0));
		}
		return btImprimir;
	}

	private JPanel getBarraEstado() {
		if (barraEstado == null) {
			barraEstado = new JPanel();
			barraEstado.setLayout(new GridLayout(1, 4, 0, 0));
			barraEstado.add(getEtDocOriginal());
			barraEstado.add(getEtIdOriginal());
			barraEstado.add(getEtDocTraducido());
			barraEstado.add(getEtIdTraducido());
		}
		return barraEstado;
	}

	private JLabel getEtDocOriginal() {
		if (etDocOriginal == null){
			etDocOriginal = new JLabel();
			etDocOriginal.setText("Documento Original");
			etDocOriginal.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			etDocOriginal.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etDocOriginal;
	}

	private JLabel getEtIdOriginal() {
		if (etIdOriginal == null){
			etIdOriginal = new JLabel();
			etIdOriginal.setText("Espa�ol");
			etIdOriginal.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			etIdOriginal.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etIdOriginal;
	}

	private JLabel getEtDocTraducido() {
		if (etDocTraducido == null){
			etDocTraducido = new JLabel();
			etDocTraducido.setText("Documento traducido");
			etDocTraducido.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			etDocTraducido.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etDocTraducido;
	}

	private JLabel getEtIdTraducido() {
		if (etIdTraducido == null){
			etIdTraducido = new JLabel();
			etIdTraducido.setText("Ingl�s");
			etIdTraducido.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			etIdTraducido.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
		}
		return etIdTraducido;
	}

	private JPanel getPnTextos() {
		if (pnTextos == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(2);
			gridLayout.setColumns(1);
			pnTextos = new JPanel();
			pnTextos.setLayout(gridLayout);
			pnTextos.add(getScOriginal(), null);
			pnTextos.add(getScTraducido(), null);
		}
		return pnTextos;
	}

	private JScrollPane getScOriginal() {
		if (scOriginal == null) {
			scOriginal = new JScrollPane();
			scOriginal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documento Original", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12), new java.awt.Color(51,51,51)));
			scOriginal.setViewportView(getArOriginal());
		}
		return scOriginal;
	}

	private JScrollPane getScTraducido() {
		if (scTraducido == null) {
			scTraducido = new JScrollPane();
			scTraducido.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documento Traducido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12), new java.awt.Color(51,51,51)));
			scTraducido.setViewportView(getArTraducido());
		}
		return scTraducido;
	}

	private JTextArea getArOriginal() {
		if (arOriginal == null) {
			arOriginal = new JTextArea();
			arOriginal.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			arOriginal.setWrapStyleWord(true);
			arOriginal.addFocusListener(fg);
			arOriginal.addKeyListener(pc);
			arOriginal.setBackground(java.awt.Color.lightGray);
			arOriginal.setLineWrap(true);
		}
		return arOriginal;
	}

	private JTextArea getArTraducido() {
		if (arTraducido == null) {
			arTraducido = new JTextArea();
			arTraducido.setWrapStyleWord(true);
			arTraducido.addFocusListener(fg);
			arTraducido.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			arTraducido.setBackground(java.awt.Color.lightGray);
			arTraducido.setLineWrap(true);
		}
		return arTraducido;
	}

	private JButton getBtEspanol() {
		if (btEspanol == null) {
			btEspanol = new JButton();
			btEspanol.setText("ES");
			btEspanol.setFont(new Font("Dialog", Font.PLAIN, 12));
			btEspanol.setBorderPainted(false);
			btEspanol.addMouseListener(bc);
			btEspanol.setPreferredSize(new java.awt.Dimension(24,24));
			btEspanol.setMargin(new java.awt.Insets(0,0,0,0));
			btEspanol.setMaximumSize(new java.awt.Dimension(24,24));
			btEspanol.setMinimumSize(new java.awt.Dimension(24,24));
			btEspanol.setContentAreaFilled(false);
			
		}
		return btEspanol;
	}

	private JButton getBtFrances() {
		if (btFrances == null) {
			btFrances = new JButton();
			btFrances.setBorderPainted(false);
			btFrances.setText("FR");
			btFrances.addMouseListener(bc);
			btFrances.setFont(new Font("Dialog", Font.PLAIN, 12));
			btFrances.setPreferredSize(new java.awt.Dimension(25,24));
			btFrances.setMargin(new java.awt.Insets(0,0,0,0));
			btFrances.setMaximumSize(new java.awt.Dimension(25,24));
			btFrances.setMinimumSize(new java.awt.Dimension(25,24));
			btFrances.setContentAreaFilled(false);
		}
		return btFrances;
	}

	private JButton getBtIngles() {
		if (btIngles == null) {
			btIngles = new JButton();
			btIngles.setBorderPainted(false);
			btIngles.setText("EN");
			btIngles.addMouseListener(bc);
			btIngles.setFont(new Font("Dialog", Font.PLAIN, 12));
			btIngles.setPreferredSize(new java.awt.Dimension(24,24));
			btIngles.setMargin(new java.awt.Insets(0,0,0,0));
			btIngles.setMaximumSize(new java.awt.Dimension(24,24));
			btIngles.setMinimumSize(new java.awt.Dimension(24,24));
			btIngles.setContentAreaFilled(false);
		}
		return btIngles;
	}

	private JMenu getMenuArchivo() {
		if (menuArchivo == null) {
			menuArchivo = new JMenu();
			menuArchivo.setMnemonic('A');
			menuArchivo.setText("Archivo");
			menuArchivo.add(getItNuevo());
			menuArchivo.addSeparator();
			menuArchivo.add(getItGuardarComo());
			menuArchivo.addSeparator();
			menuArchivo.add(getItSalir());
		}
		return menuArchivo;
	}

	private JMenu getMenuEditar() {
		if (menuEditar == null) {
			menuEditar = new JMenu();
			menuEditar.setMnemonic('E');
			menuEditar.setText("Editar");
		}
		return menuEditar;
	}

	private JMenu getMenuTraducir() {
		if (menuTraducir == null) {
			menuTraducir = new JMenu();
			menuTraducir.setMnemonic('T');
			menuTraducir.setText("Traducir");
		}
		return menuTraducir;
	}

	private JMenu getMenuHerramientas() {
		if (menuHerramientas == null) {
			menuHerramientas = new JMenu();
			menuHerramientas.setMnemonic('H');
			menuHerramientas.setText("Herramientas");
		}
		return menuHerramientas;
	}

	private JMenu getMenuAyuda() {
		if (menuAyuda == null) {
			menuAyuda = new JMenu();
			menuAyuda.setMnemonic('d');
			menuAyuda.setText("Ayuda");
		}
		return menuAyuda;
	}

	private JMenuItem getItGuardarComo() {
		if (itGuardarComo == null) {
			itGuardarComo = new JMenuItem();
			itGuardarComo.setMnemonic('G');
			itGuardarComo.setText("Guardar como...");
		}
		return itGuardarComo;
	}

	private JMenuItem getItNuevo() {
		if (itNuevo == null) {
			itNuevo = new JMenuItem();
			itNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			itNuevo.setMnemonic('N');
			itNuevo.setText("Nuevo");
		}
		return itNuevo;
	}

	private JMenuItem getItSalir() {
		if (itSalir == null) {
			itSalir = new JMenuItem();
			itSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int respuesta =JOptionPane.showConfirmDialog(null,"Desea guardar cambios");
					if(respuesta==JOptionPane.YES_OPTION) {
						System.exit(0);
					}
					
				}
			});
			itSalir.setMnemonic('S');
			itSalir.setText("Salir");
		}
		return itSalir;
	}


	public VentanaPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				arOriginal.grabFocus();
			}
			@Override
			public void windowClosing(WindowEvent e) {
				int respuesta =JOptionPane.showConfirmDialog(null,"Desea guardar cambios");
				if(respuesta==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/icono.png")));
		setSize(981, 586);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setJMenuBar(getBarraMenu());
		setTitle("Traductor de Textos");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(getBarraHerramientas(), java.awt.BorderLayout.NORTH);
		contentPane.add(getBarraEstado(), java.awt.BorderLayout.SOUTH);
		contentPane.add(getPnTextos(), java.awt.BorderLayout.CENTER);
		setContentPane(contentPane);
		
	}
	
	public class FocoGanado implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			JTextArea texto = (JTextArea)e.getComponent();
			texto.setBackground(Color.white);
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			JTextArea texto = (JTextArea)e.getComponent();
			texto.setBackground(Color.LIGHT_GRAY);
		}
		
	}

	public class BordersColor extends MouseAdapter{
		@Override
		public void mouseEntered(MouseEvent e) {
			JButton bt =(JButton)e.getComponent();
			bt.setBorderPainted(true);
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			JButton bt =(JButton)e.getComponent();
			bt.setBorderPainted(false);
		}
	}
	private JCheckBox getJchCarac() {
		if (jchCarac == null) {
			jchCarac = new JCheckBox("Solo caracteres");
		}
		return jchCarac;
	}
	
	public class ProcesaCara extends KeyAdapter{
		@Override
		public void keyTyped(KeyEvent e) {
			if(getJchCarac().isSelected()) {
				char teclaPulsada=e.getKeyChar();
				if (Character.isDigit(teclaPulsada)){
				e.consume();
				}
			}
		}
	}
} 
