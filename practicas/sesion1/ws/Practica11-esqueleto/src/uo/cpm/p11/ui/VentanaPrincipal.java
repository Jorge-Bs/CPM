package uo.cpm.p11.ui;


import javax.swing.*;
import java.awt.Color;
import java.awt.Font;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.border.LineBorder;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;
import uo.cpm.p11.service.*;
import uo.cpm.p11.model.Articulo;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private AccionBoton aB;
	private JPanel contentPane;
	private JLabel lblLogo;
	private JLabel lblLblnombre;
	private JPanel pnInfo1;
	private JPanel pnlLogo;
	private JPanel pnArticulos;
	private JPanel pnBts1;
	private JPanel pnBts2;
	private JPanel pnBts3;
	private JPanel pnContenidos;
	private JPanel pn2;
	private JPanel pn3;
	private JPanel pnDatosCliente;
	private JLabel lbNombre;
	private JTextField txtNombre;
	private JLabel lbAño;
	private JComboBox<String> cbAños;
	private JLabel lbPasw1;
	private JPasswordField psw1;
	private JLabel lbPasw2;
	private JPasswordField psw2;
	private JPanel pn1;
	private JPanel pnFormulario;
	private JPanel pnDatosPedido;
	private JRadioButton rbLocal;
	private JRadioButton rbLlevar;
	private JPanel pnInfo2;
	private JPanel pnConfirmacion;
	private JPanel pnInfo3;
	private JLabel lbAviso;
	private JLabel lbOk;
	private JLabel lbCodigo;
	private JTextField txCodigo;
	private final ButtonGroup grPedido = new ButtonGroup();
	private McDonalds mcdonalds;
	private JTextField txPrecio;
	private JButton btAnular;
	private JButton btSiguiente;
	private JTabbedPane tabbedPane;
	private JScrollPane scrComida;
	private JScrollPane scrBebida;
	private JList<Articulo> listComida;
	private JList<Articulo> listBebida;
	
	private DefaultListModel<Articulo> modeloListComida;
	private DefaultListModel<Articulo> modeloListBebida;


	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(McDonalds mc) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				asociaImagenBotones();
			}
		});
		this.mcdonalds = mc;
		aB = new AccionBoton();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.PNG")));
		setTitle("McDonald's España");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 820);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnlLogo(), BorderLayout.NORTH);
		contentPane.add(getPnContenidos(), BorderLayout.CENTER);
	}
	
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.PNG")));
		}
		return lblLogo;
	}
	private JLabel getLblLblnombre() {
		if (lblLblnombre == null) {
			lblLblnombre = new JLabel("McDonald's");
			lblLblnombre.setFont(new Font("Arial Black", Font.PLAIN, 44));
			lblLblnombre.setForeground(Color.BLACK);
		}
		return lblLblnombre;
	}

	
	protected void inicializar() {
		mcdonalds.inicializarPedido();
		//COMPLETAR
	}
	
	private JPanel getPnInfo1() {
		if (pnInfo1 == null) {
			pnInfo1 = new JPanel();
			pnInfo1.setBackground(Color.WHITE);
			pnInfo1.setLayout(new BorderLayout(0, 0));
			pnInfo1.add(getPnBts1(),BorderLayout.SOUTH);
			pnInfo1.add(getTabbedPane(), BorderLayout.NORTH);
		
		}
		return pnInfo1;
	}
	private JPanel getPnlLogo() {
		if (pnlLogo == null) {
			pnlLogo = new JPanel();
			pnlLogo.setBackground(Color.WHITE);
			pnlLogo.setLayout(new GridLayout(1, 0, 0, 0));
			pnlLogo.add(getLblLogo());
			pnlLogo.add(getLblLblnombre());
		}
		return pnlLogo;
	}
	private JPanel getPnArticulos() {
		if (pnArticulos == null) {
			pnArticulos = new JPanel();
			pnArticulos.setBorder(new LineBorder(Color.ORANGE, 4));
			pnArticulos.setBackground(Color.WHITE);
			pnArticulos.setLayout(new GridLayout(0, 5, 3, 3));
			// COMPLETAR 1
			crearBotones();
		}
		return pnArticulos;
	}
	
	private void setImagenAdaptada(JButton boton, String rutaImagen){
		 Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage(); 
		 Image imgEscalada = imgOriginal.getScaledInstance(boton.getWidth(),boton.getHeight(), Image.SCALE_FAST);
		 ImageIcon icon = new ImageIcon(imgEscalada);
		 boton.setIcon(icon);
	}
	

	private void asociaImagenBotones() {
		for (int i = 0; i < pnArticulos.getComponents().length; i++)
		{
			JButton boton = (JButton) (pnArticulos.getComponents()[i]);
			setImagenAdaptada(boton,"/img/"+mcdonalds.getArticulo(i).getCodigo()+".png"); 
			
		}
	}

	private JButton nuevoBoton(Integer posicion) {
		JButton boton = new JButton("");
		boton.setEnabled(true);
		boton.setBackground(Color.white);
		boton.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		boton.setToolTipText(mcdonalds.getArticulo(posicion).toString());
		boton.setActionCommand(posicion.toString());
		boton.addActionListener(aB);
		return boton;
	}

	class AccionBoton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton bt = (JButton) e.getSource();
			añadirAPedido(Integer.parseInt(bt.getActionCommand()));
		}
	}
	
	//COMPLETAR 2
	private void añadirAPedido(int posArticuloEnCarta) {
		mcdonalds.añadirAPedido(mcdonalds.getArticulo(posArticuloEnCarta), 1);
		mostrarEnLista();
		showPrice();
	}
	//COMPLETAR 3
	private void mostrarEnLista() {//(Articulo a)
		mostrarComida();
		mostrarBebida();
	}
	
	private void showPrice() {
		float precio = mcdonalds.getTotalPedido();
		getTxPrecio().setText("Precio del pedido: "+precio+"€");
	}
	
	private void mostrarBebida() {
		modeloListBebida.removeAllElements();
		modeloListBebida.addAll(mcdonalds.getPedido().getBebida());
	}

	private void mostrarComida() {
		modeloListComida.removeAllElements();
		modeloListComida.addAll(mcdonalds.getPedido().getComida());
	}

	//COMPLETAR 4
	private void mostrarPn1() {
	}
	
	private void mostrarPn2() {
	}
	
	private void mostrarPn3() {
		if (comprobarCampos())
		{   
			// COMPLETAR
		}
	}
	
	private JPanel getPnBts1() {
		if (pnBts1 == null) {
			pnBts1 = new JPanel();
			pnBts1.setBackground(Color.WHITE);
			pnBts1.setLayout(new GridLayout(1, 3, 0, 0));
			pnBts1.add(getTxPrecio());
			pnBts1.add(getButton_1());
			pnBts1.add(getButton_2());
		}
		return pnBts1;
	}
	
	private JPanel getPnBts2() {
		if (pnBts2 == null) {
			pnBts2 = new JPanel();
			pnBts2.setBackground(Color.WHITE);
			pnBts2.setLayout(new GridLayout(1, 3, 0, 0));
		}
		return pnBts2;
	}
	
	private JPanel getPnBts3() {
		if (pnBts3 == null) {
			pnBts3 = new JPanel();
			pnBts3.setBackground(Color.WHITE);
			pnBts3.setLayout(new GridLayout(1, 3, 0, 0));
		}
		return pnBts3;
	}

	private JPanel getPnContenidos() {
		if (pnContenidos == null) {
			pnContenidos = new JPanel();
			pnContenidos.setLayout(new CardLayout(0, 0));
			pnContenidos.add(getPn1(), "pn1");
			pnContenidos.add(getPn2(), "pn2");
			pnContenidos.add(getPn3(), "pn3");
		}
		return pnContenidos;
	}
	
	private JPanel getPn2() {
		if (pn2 == null) {
			pn2 = new JPanel();
			pn2.setBackground(Color.WHITE);
			pn2.setLayout(new BorderLayout(0, 0));
			pn2.add(getPnFormulario(), BorderLayout.CENTER);
			pn2.add(getPnInfo2(), BorderLayout.SOUTH);
		}
		return pn2;
	}
	
	private JPanel getPn3() {
		if (pn3 == null) {
			pn3 = new JPanel();
			pn3.setBackground(Color.WHITE);
			pn3.setLayout(new BorderLayout(0, 0));
			pn3.add(getPnConfirmacion());
			pn3.add(getPnInfo3(), BorderLayout.SOUTH);
		}
		return pn3;
	}
	
	private JComboBox<String> getCbAños() {
		if (cbAños == null) {
			String[]años = new String[90];
			for (int i=0;i<90;i++){
				String año = ""+((90-i)+1920);
				años[i]= año;
			}
			cbAños = new JComboBox<String>();
			cbAños.setFont(new Font("Arial", Font.PLAIN, 14));
			cbAños.setModel(new DefaultComboBoxModel<String>(años));
			cbAños.setBounds(new Rectangle(264, 84, 157, 25));
		}
		return cbAños;
	}
	
	private boolean isVacio() {
		return (txtNombre.getText().equals("")||(String.valueOf(psw1.getPassword()).equals(""))||(String.valueOf(psw2.getPassword()).equals(""))); 
	
	}
	
	private boolean isIncorrecta() {
		return (!String.valueOf(psw1.getPassword()).equals(String.valueOf(psw2.getPassword())));
	}
	
	private JPanel getPnDatosCliente() {
		if (pnDatosCliente == null) {
			pnDatosCliente = new JPanel();
			pnDatosCliente.setBounds(104, 58, 656, 224);
			pnDatosCliente.setBorder(new TitledBorder(null, "Datos del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnDatosCliente.setBackground(Color.WHITE);
			pnDatosCliente.setLayout(null);
			pnDatosCliente.add(getLbNombre());
			pnDatosCliente.add(getTxtNombre());
			pnDatosCliente.add(getLbAño());
			pnDatosCliente.add(getCbAños());
			pnDatosCliente.add(getLbPasw1());
			pnDatosCliente.add(getPsw1());
			pnDatosCliente.add(getLbPasw2());
			pnDatosCliente.add(getPsw2());
		}
		return pnDatosCliente;
	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel();
			lbNombre.setText("Nombre y Apellidos:");
			lbNombre.setFont(new Font("Arial", Font.PLAIN, 14));
			lbNombre.setDisplayedMnemonic('N');
			lbNombre.setBounds(30, 31, 132, 20);
		}
		return lbNombre;
	}
	private JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Arial", Font.PLAIN, 14));
			txtNombre.setBounds(264, 31, 330, 25);
		}
		return txtNombre;
	}
	private JLabel getLbAño() {
		if (lbAño == null) {
			lbAño = new JLabel("A\u00F1o de nacimiento:");
			lbAño.setFont(new Font("Arial", Font.PLAIN, 14));
			lbAño.setDisplayedMnemonic('A');
			lbAño.setBounds(30, 81, 151, 16);
		}
		return lbAño;
	}

	private JLabel getLbPasw1() {
		if (lbPasw1 == null) {
			lbPasw1 = new JLabel();
			lbPasw1.setText("Password:");
			lbPasw1.setFont(new Font("Arial", Font.PLAIN, 14));
			lbPasw1.setDisplayedMnemonic('P');
			lbPasw1.setBounds(new Rectangle(13, 123, 105, 16));
			lbPasw1.setBounds(30, 129, 105, 16);
		}
		return lbPasw1;
	}
	private JPasswordField getPsw1() {
		if (psw1 == null) {
			psw1 = new JPasswordField();
			psw1.setFont(new Font("Arial", Font.PLAIN, 14));
			psw1.setBounds(new Rectangle(176, 121, 218, 25));
			psw1.setBounds(264, 129, 218, 25);
		}
		return psw1;
	}
	private JLabel getLbPasw2() {
		if (lbPasw2 == null) {
			lbPasw2 = new JLabel();
			lbPasw2.setText("Reintroduzca password:");
			lbPasw2.setFont(new Font("Arial", Font.PLAIN, 14));
			lbPasw2.setDisplayedMnemonic('R');
			lbPasw2.setBounds(new Rectangle(13, 167, 151, 16));
			lbPasw2.setBounds(30, 181, 182, 16);
		}
		return lbPasw2;
	}
	private JPasswordField getPsw2() {
		if (psw2 == null) {
			psw2 = new JPasswordField();
			psw2.setFont(new Font("Arial", Font.PLAIN, 14));
			psw2.setBounds(new Rectangle(176, 163, 218, 25));
			psw2.setBounds(264, 179, 218, 25);
		}
		return psw2;
	}
	
	public boolean comprobarCampos() {
		if (isVacio()) {
			JOptionPane.showMessageDialog(null, "Error: Hay alg�n campo en blanco");
			return false;
		}
		else
			if (isIncorrecta()) {
				JOptionPane.showMessageDialog(null, "Error: Las passwords no coinciden");
				return false;
			}
		return true;
	 }

	
	
	private JPanel getPn1() {
		if (pn1 == null) {
			pn1 = new JPanel();
			pn1.setLayout(new BorderLayout(0, 0));
			pn1.add(getPnArticulos(), BorderLayout.CENTER);
			pn1.add(getPnInfo1(), BorderLayout.SOUTH);
		}
		return pn1;
	}
	
	private JPanel getPnFormulario() {
		if (pnFormulario == null) {
			pnFormulario = new JPanel();
			pnFormulario.setBorder(new LineBorder(Color.ORANGE, 4));
			pnFormulario.setBackground(Color.WHITE);
			pnFormulario.setLayout(null);
			pnFormulario.add(getPnDatosCliente());
			pnFormulario.add(getPnDatosPedido());
		}
		return pnFormulario;
	}
	private JPanel getPnDatosPedido() {
		if (pnDatosPedido == null) {
			pnDatosPedido = new JPanel();
			pnDatosPedido.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del pedido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnDatosPedido.setBackground(Color.WHITE);
			pnDatosPedido.setBounds(104, 304, 248, 60);
			pnDatosPedido.add(getRbLocal());
			pnDatosPedido.add(getRbLlevar());
		}
		return pnDatosPedido;
	}
	private JRadioButton getRbLocal() {
		if (rbLocal == null) {
			rbLocal = new JRadioButton();
			rbLocal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (rbLocal.isSelected()) {
						mcdonalds.getPedido().setLocal(true);
					}
				}
			});
			grPedido.add(rbLocal);
			rbLocal.setText("Local");
			rbLocal.setSelected(true);
			rbLocal.setMnemonic('L');
			rbLocal.setFont(new Font("Arial", Font.PLAIN, 14));
			rbLocal.setBounds(new Rectangle(17, 27, 94, 24));
			rbLocal.setBackground(Color.WHITE);
		}
		return rbLocal;
	}
	
	private JRadioButton getRbLlevar() {
		if (rbLlevar == null) {
			rbLlevar = new JRadioButton();
			rbLlevar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (rbLlevar.isSelected()) {
						mcdonalds.getPedido().setLocal(false);
					}
				}
			});
			grPedido.add(rbLlevar);
			rbLlevar.setText("Llevar");
			rbLlevar.setMnemonic('r');
			rbLlevar.setFont(new Font("Arial", Font.PLAIN, 14));
			rbLlevar.setBounds(new Rectangle(115, 27, 86, 24));
			rbLlevar.setBackground(Color.WHITE);
		}
		return rbLlevar;
	}
	
	private JPanel getPnInfo2() {
		if (pnInfo2 == null) {
			pnInfo2 = new JPanel();
			pnInfo2.setBackground(Color.WHITE);
			pnInfo2.setLayout(new BorderLayout(0, 0));
			pnInfo2.add(getPnBts2(),BorderLayout.SOUTH);
		}
		return pnInfo2;
	}
	private JPanel getPnConfirmacion() {
		if (pnConfirmacion == null) {
			pnConfirmacion = new JPanel();
			pnConfirmacion.setBorder(new LineBorder(Color.ORANGE, 4));
			pnConfirmacion.setBackground(Color.WHITE);
			pnConfirmacion.setLayout(null);
			pnConfirmacion.add(getLbAviso());
			pnConfirmacion.add(getLbOk());
			pnConfirmacion.add(getLbCodigo());
			pnConfirmacion.add(getTxCodigo());
		}
		return pnConfirmacion;
	}
	private JPanel getPnInfo3() {
		if (pnInfo3 == null) {
			pnInfo3 = new JPanel();
			pnInfo3.setBackground(Color.WHITE);
			pnInfo3.setLayout(new BorderLayout(0, 0));
			pnInfo3.add(getPnBts3(),BorderLayout.SOUTH);
		}
		return pnInfo3;
	}
	
	private void finalizar() {
		mcdonalds.getPedido().grabarPedido();
		inicializar();
		//COMPLETAR
	}
	
	private JLabel getLbAviso() {
		if (lbAviso == null) {
			lbAviso = new JLabel("Pulse Finalizar para confirmar su pedido");
			lbAviso.setFont(new Font("Tahoma", Font.BOLD, 28));
			lbAviso.setBounds(135, 104, 622, 35);
		}
		return lbAviso;
	}
	private JLabel getLbOk() {
		if (lbOk == null) {
			lbOk = new JLabel("");
			lbOk.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/ok.png")));
			lbOk.setBounds(50, 91, 73, 52);
		}
		return lbOk;
	}
	private JLabel getLbCodigo() {
		if (lbCodigo == null) {
			lbCodigo = new JLabel("El c\u00F3digo de recogida es:");
			lbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lbCodigo.setBounds(138, 172, 191, 26);
		}
		return lbCodigo;
	}
	private JTextField getTxCodigo() {
		if (txCodigo == null) {
			txCodigo = new JTextField();
			txCodigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txCodigo.setEditable(false);
			txCodigo.setText(mcdonalds.getPedido().getCodigo());
			txCodigo.setBounds(341, 161, 191, 45);
			txCodigo.setColumns(10);
		}
		return txCodigo;
	}
	private JTextField getTxPrecio() {
		if (txPrecio == null) {
			txPrecio = new JTextField();
			txPrecio.setText("Precio del pedido: 0.0€");
			txPrecio.setBackground(new Color(255, 255, 0));
			txPrecio.setEditable(false);
			txPrecio.setColumns(10);
		}
		return txPrecio;
	}
	private JButton getButton_1() {
		if (btAnular == null) {
			btAnular = new JButton("Anular");
			btAnular.setToolTipText("a");
			btAnular.setBackground(new Color(255, 0, 0));
			btAnular.setForeground(new Color(255, 255, 255));
		}
		return btAnular;
	}
	private JButton getButton_2() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setToolTipText("s");
			btSiguiente.setForeground(new Color(255, 255, 255));
			btSiguiente.setBackground(new Color(0, 255, 0));
		}
		return btSiguiente;
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("Comida", null, getScrComida(), null);
			tabbedPane.setDisplayedMnemonicIndexAt(0, 2);
			tabbedPane.addTab("Bebida", null, getScrBebida(), null);
			tabbedPane.setDisplayedMnemonicIndexAt(1, 0);
		}
		return tabbedPane;
	}
	private JScrollPane getScrComida() {
		if (scrComida == null) {
			scrComida = new JScrollPane();
			scrComida.setViewportView(getListComida());
		}
		return scrComida;
	}
	private JScrollPane getScrBebida() {
		if (scrBebida == null) {
			scrBebida = new JScrollPane();
			scrBebida.setViewportView(getListBebida());
		}
		return scrBebida;
	}
	private JList<Articulo> getListComida() {
		if (listComida == null) {
			modeloListComida = new DefaultListModel<Articulo>();
			listComida = new JList<Articulo>(modeloListComida);
		}
		return listComida;
	}
	private JList<Articulo> getListBebida() {
		if (listBebida == null) {
			modeloListBebida = new DefaultListModel<Articulo>();
			listBebida = new JList<Articulo>(modeloListBebida);
		}
		return listBebida;
	}
	
	private void crearBotones() {
		for(int i=0;i<mcdonalds.getArticulosCarta().length;i++) {
			getPnArticulos().add(nuevoBoton(i));
		}
		validate();
	}
}
