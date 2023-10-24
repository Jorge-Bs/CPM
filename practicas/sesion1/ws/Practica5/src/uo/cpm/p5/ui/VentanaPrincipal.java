package uo.cpm.p5.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uo.cpm.p5.model.Articulo;
import uo.cpm.p5.service.McDonalds;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;

public class VentanaPrincipal extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbLogo;
	private JLabel lbArticulos;
	private JComboBox<Articulo> cBArticulos;
	private JLabel lbUnidades;
	private JSpinner sUnidades;
	private JButton btAñadir;
	private JLabel lbPrecio;
	private JTextField tFPrice;
	private JButton btSiguiente;
	private JButton btCancelar;
	McDonalds mac;
	private JLabel lbAmountProduct;
	private JLabel lbImgDiscount;
	private JTextArea txDiscount;
	private JScrollPane scrollPanePedido;
	private JTextArea textAreaPedido;
	private JLabel lbIcPedido;
	private JButton btEliminar;
	private JPanel pnFiltro;
	private JButton btHamburgesa;
	private JButton btnTodo;
	private JButton btBebida;
	private JButton btnComplementos;
	private JButton btnPsotre;
	private JLabel lbImgProduct;
	private JMenuBar menuBar;
	private JMenu menuPedido;
	private JMenu menuAyuda;
	private JMenuItem mnNuevo;
	private JMenuItem mntmContenidos;
	private JMenuItem nmtSalir;
	private JMenuItem mntmAcerca;
	private JSeparator separator;
	private JSeparator separator_1;
	
	
	/**
	 * Creacion de ventanas, de afuera a dentro
	 */

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaPrincipal frame = new VentanaPrincipal();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(McDonalds mac) {
		setMacDonalds(mac);
		setTitle("McDonald's España");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 560);
		this.setLocationRelativeTo(null);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbLogo());
		contentPane.add(getLbArticulos());
		contentPane.add(getLbImgProduct());
		contentPane.add(getCBArticulos());
		contentPane.add(getLbUnidades());
		contentPane.add(getSUnidades());
		contentPane.add(getBtAñadir());
		contentPane.add(getLbPrecio());
		contentPane.add(getTFPrice());
		contentPane.add(getBtSiguiente());
		contentPane.add(getBtCancelar());
		contentPane.add(getLbAmountProduct());
		contentPane.add(getLbImgDiscount());
		contentPane.add(getTxDiscount());
		contentPane.add(getScrollPanePedido());
		contentPane.add(getLbIcPedido());
		contentPane.add(getBtEliminar());
		contentPane.add(getPnFiltro());
		
	}
	private void setMacDonalds(McDonalds mcDonalds) {
		if(mcDonalds==null) throw new IllegalArgumentException();
		this.mac= mcDonalds;
	}
	
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("  McDonald's");
			lbLogo.setFont(new Font("Arial Black", Font.PLAIN, 44));
			lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
			lbLogo.setBounds(244, 25, 484, 150);
		}
		return lbLogo;
	}
	private JLabel getLbArticulos() {
		if (lbArticulos == null) {
			lbArticulos = new JLabel("Articulos:");
			lbArticulos.setLabelFor(getCBArticulos());
			lbArticulos.setDisplayedMnemonic('t');
			lbArticulos.setBounds(218, 239, 192, 29);
		}
		return lbArticulos;
	}
	private JComboBox<Articulo> getCBArticulos() {
		if (cBArticulos == null) {
			cBArticulos = new JComboBox<Articulo>();
			cBArticulos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showUnits();
					getSUnidades().setValue(1);//cada vez que se cambia el articulo seleccionado se pone a 1
					disableEliminar();
					changeIcon();
				}
			});
			cBArticulos.setModel(new DefaultComboBoxModel<Articulo>(mac.getArticulosCarta()));
			cBArticulos.setBounds(286, 242, 357, 22);
		}
		return cBArticulos;
	}
	private void disableEliminar() {
		Articulo art = (Articulo)getCBArticulos().getSelectedItem();
		if(mac.getAmountOfProduct(art)==0) getBtEliminar().setEnabled(false);
		else getBtEliminar().setEnabled(true);
	}
	
	
	private void changeIcon() {
		String path= "/img/"+((Articulo)cBArticulos.getSelectedItem()).getCodigo()+".png";
		getLbImgProduct().setIcon(new ImageIcon(VentanaPrincipal.class.getResource(path)));
	}
	
	private JLabel getLbUnidades() {
		if (lbUnidades == null) {
			lbUnidades = new JLabel("Unidades:");
			lbUnidades.setLabelFor(getSUnidades());
			lbUnidades.setDisplayedMnemonic('U');
			lbUnidades.setBounds(680, 209, 167, 14);
		}
		return lbUnidades;
	}
	private JSpinner getSUnidades() {
		if (sUnidades == null) {
			sUnidades = new JSpinner();
			sUnidades.setModel(new SpinnerNumberModel(1, 1, 100, 1));
			sUnidades.setBounds(678, 239, 74, 29);
		}
		return sUnidades;
	}
	private JButton getBtAñadir() {
		if (btAñadir == null) {
			btAñadir = new JButton("Añadir");
			btAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addArticulo();
					disableEliminar();
					showUnits();
					fillPanelPedido();
				}
			});
			btAñadir.setMnemonic('d');
			btAñadir.setBackground(new Color(0, 255, 0));
			btAñadir.setBounds(775, 239, 121, 29);
		}
		return btAñadir;
	}
	
	private void showUnits() {
		setLbAmountProductText(mac.getAmountOfProduct((Articulo)getCBArticulos().getSelectedItem()));
	}
	
	private void addArticulo() {
		getBtSiguiente().setEnabled(true);
		mac.añadirAPedido(readArticulo(), readUnidades());
		showPrice();
		
	}
	
	private Articulo readArticulo() {
		return (Articulo)getCBArticulos().getSelectedItem();
	}
	
	private int readUnidades() {
		return (Integer) getSUnidades().getValue();
	}
	
	private void showPrice() {
		float total = mac.getTotalPedido();
		String precio = String.format("%.2f",total);
		getTFPrice().setText(precio+"€");
		if(total==0) getBtSiguiente().setEnabled(false);
		if(mac.hasDiscount()) getTxDiscount().setVisible(true);
		else getTxDiscount().setVisible(false);
	}
	
	
	
	private JLabel getLbPrecio() {
		if (lbPrecio == null) {
			lbPrecio = new JLabel("Precio del pedido:");
			lbPrecio.setBounds(743, 287, 152, 29);
		}
		return lbPrecio;
	}
	private JTextField getTFPrice() {
		if (tFPrice == null) {
			tFPrice = new JTextField();
			tFPrice.setText("0€");
			tFPrice.setEditable(false);
			tFPrice.setBounds(743, 326, 96, 37);
			tFPrice.setColumns(10);
		}
		return tFPrice;
	}
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setEnabled(false);
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showRegisterWindow();
				}
			});
			btSiguiente.setMnemonic('S');
			btSiguiente.setBackground(new Color(0, 255, 0));
			btSiguiente.setBounds(757, 417, 130, 42);
		}
		return btSiguiente;
	}
	
	private void showRegisterWindow() {
		VentanaRegistro vR = new VentanaRegistro(this);
		
		vR.setLocationRelativeTo(null);//null pantalla de ordenar, this en relacion a la ventana anterior
		vR.setModal(true);
		vR.setVisible(true); //tiene que siempre lo ultimo
	}
	
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btCancelar.setMnemonic('C');
			btCancelar.setBackground(new Color(255, 0, 0));
			btCancelar.setBounds(897, 417, 130, 42);
		}
		return btCancelar;
	}
	private JLabel getLbAmountProduct() {
		if (lbAmountProduct == null) {
			lbAmountProduct = new JLabel("New label");
			lbAmountProduct.setBounds(260, 186, 357, 37);
			lbAmountProduct.setText("El carrito contiene: "+0+" unidades del producto seleccionado.");
		}
		return lbAmountProduct;
	}
	
	private void setLbAmountProductText(int unites) {
		if(unites==1)getLbAmountProduct().setText("El carrito contiene: "+unites+" unidad del producto seleccionado.");
		else getLbAmountProduct().setText("El carrito contiene: "+unites+" unidades del producto seleccionado.");
	}
	private JLabel getLbImgDiscount() {
		if (lbImgDiscount == null) {
			lbImgDiscount = new JLabel("");
			lbImgDiscount.setToolTipText("Si la compra es superior a 60€, se descontará un 10%");
			lbImgDiscount.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/ofertaHappy.png")));
			lbImgDiscount.setBounds(480, 344, 212, 127);
		}
		return lbImgDiscount;
	}
	private JTextArea getTxDiscount() {
		if (txDiscount == null) {
			txDiscount = new JTextArea();
			txDiscount.setEditable(false);
			txDiscount.setVisible(false);
			txDiscount.setTabSize(6);
			txDiscount.setText("Se ha superado los 60€,\nel precio del pedido posee \nun 10% de descuento");
			txDiscount.setBounds(860, 313, 167, 79);
		}
		return txDiscount;
	}
	
	void inicializar() {
		mac.inicializarPedido();
		getCBArticulos().setSelectedIndex(0);
		getSUnidades().setValue(1);
		setLbAmountProductText(0);
		getTxDiscount().setVisible(false);
		getBtSiguiente().setEnabled(false);
		getTFPrice().setText("");
		getTextAreaPedido().setText("");
		getCBArticulos().setModel(new DefaultComboBoxModel<Articulo>(mac.getArticulosCarta()));
		changeIcon();
	}
	private JScrollPane getScrollPanePedido() {
		if (scrollPanePedido == null) {
			scrollPanePedido = new JScrollPane();
			scrollPanePedido.setBounds(846, 64, 181, 134);
			scrollPanePedido.setViewportView(getTextAreaPedido());
			scrollPanePedido.setVisible(false);
		}
		return scrollPanePedido;
	}
	private JTextArea getTextAreaPedido() {
		if (textAreaPedido == null) {
			textAreaPedido = new JTextArea();
			textAreaPedido.setLineWrap(true); //elimina el  scroll vertical
			textAreaPedido.setWrapStyleWord(true); //hace que no se corten las palabras si estas ocupan mas 
			textAreaPedido.setEditable(false);
		}
		return textAreaPedido;
	}
	private JLabel getLbIcPedido() {
		if (lbIcPedido == null) {
			lbIcPedido = new JLabel("");
			lbIcPedido.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					getScrollPanePedido().setVisible(true);
					getTextAreaPedido().setVisible(true);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					getScrollPanePedido().setVisible(false);
				}
			});
			lbIcPedido.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/pedido.png")));
			lbIcPedido.setBounds(894, 25, 133, 41);
		}
		return lbIcPedido;
	}
	
	private void fillPanelPedido() {
		getTextAreaPedido().setText(mac.getPedido());
	}
	private JButton getBtEliminar() {
		if (btEliminar == null) {
			btEliminar = new JButton("Eliminar");
			btEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarProductos();
					disableEliminar();
					showUnits();
					fillPanelPedido();
					showPrice();
				}
			});
			btEliminar.setEnabled(false);
			btEliminar.setMnemonic('E');
			btEliminar.setBackground(new Color(255, 0, 0));
			btEliminar.setBounds(906, 239, 121, 29);
		}
		return btEliminar;
	}
	
	private void eliminarProductos() {
		mac.eliminarProductos((Integer)getSUnidades().getValue(),(Articulo)getCBArticulos().getSelectedItem());
	}
	private JPanel getPnFiltro() {
		if (pnFiltro == null) {
			pnFiltro = new JPanel();
			pnFiltro.setBounds(38, 11, 173, 460);
			pnFiltro.setLayout(new GridLayout(5, 1, 0, 0));
			pnFiltro.add(getBtHamburgesa());
			pnFiltro.add(getBtBebida());
			pnFiltro.add(getBtnComplementos());
			pnFiltro.add(getBtnPsotre());
			pnFiltro.add(getBtnTodo());
		}
		return pnFiltro;
	}
	private JButton getBtHamburgesa() {
		if (btHamburgesa == null) {
			btHamburgesa = new JButton("Hamburgesa");
			btHamburgesa.setBackground(new Color(255, 255, 255));
			btHamburgesa.setVerticalTextPosition(SwingConstants.BOTTOM);
			btHamburgesa.setHorizontalTextPosition(SwingConstants.CENTER);
			btHamburgesa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fillCombo("Hamburguesa");
				}
			});
			btHamburgesa.setMnemonic('H');
			btHamburgesa.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Hamburguesa.png")));
		}
		return btHamburgesa;
	}
	private JButton getBtnTodo() {
		if (btnTodo == null) {
			btnTodo = new JButton("Todo");
			btnTodo.setBackground(new Color(255, 255, 255));
			btnTodo.setVerticalAlignment(SwingConstants.BOTTOM);
			btnTodo.setHorizontalTextPosition(SwingConstants.CENTER);
			btnTodo.setMnemonic('O');
			btnTodo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fillCombo("Todo");
				}
			});
		}
		return btnTodo;
	}
	private JButton getBtBebida() {
		if (btBebida == null) {
			btBebida = new JButton("Bebidas");
			btBebida.setBackground(new Color(255, 255, 255));
			btBebida.setHorizontalTextPosition(SwingConstants.CENTER);
			btBebida.setVerticalTextPosition(SwingConstants.BOTTOM);
			btBebida.setMnemonic('B');
			btBebida.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fillCombo("Bebida");
				}
			});
			btBebida.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Bebida.png")));
		}
		return btBebida;
	}
	
	private void fillCombo(String denominacion) {
		getCBArticulos().setModel(new DefaultComboBoxModel<Articulo>(mac.getArticulosCarta(denominacion)));
		changeIcon();
	}
	
	
	
	private JButton getBtnComplementos() {
		if (btnComplementos == null) {
			btnComplementos = new JButton("Complementos");
			btnComplementos.setBackground(new Color(255, 255, 255));
			btnComplementos.setHorizontalTextPosition(SwingConstants.CENTER);
			btnComplementos.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnComplementos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fillCombo("Complemento");
				}
			});
			btnComplementos.setMnemonic('C');
			btnComplementos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Complemento.png")));
		}
		return btnComplementos;
	}
	private JButton getBtnPsotre() {
		if (btnPsotre == null) {
			btnPsotre = new JButton("Postres");
			btnPsotre.setBackground(new Color(255, 255, 255));
			btnPsotre.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPsotre.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnPsotre.setMnemonic('o');
			btnPsotre.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Postre.png")));
			btnPsotre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fillCombo("Postre");
				}
			});
		}
		return btnPsotre;
	}
	private JLabel getLbImgProduct() {
		if (lbImgProduct == null) {
			lbImgProduct = new JLabel("");
			lbImgProduct.setBounds(263, 326, 173, 89);
			changeIcon();
		}
		return lbImgProduct;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMenuPedido());
			menuBar.add(getMenuAyuda());
		}
		return menuBar;
	}
	private JMenu getMenuPedido() {
		if (menuPedido == null) {
			menuPedido = new JMenu("Pedido");
			menuPedido.setMnemonic('p');
			menuPedido.add(getMnNuevo());
			menuPedido.add(getSeparator());
			menuPedido.add(getNmtSalir());
		}
		return menuPedido;
	}
	private JMenu getMenuAyuda() {
		if (menuAyuda == null) {
			menuAyuda = new JMenu("Ayuda");
			menuAyuda.setMnemonic('A');
			menuAyuda.add(getMntmContenidos());
			menuAyuda.add(getSeparator_1());
			menuAyuda.add(getMntmAcerca());
		}
		return menuAyuda;
	}
	private JMenuItem getMnNuevo() {
		if (mnNuevo == null) {
			mnNuevo = new JMenuItem("Nuevo");
			mnNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			mnNuevo.setMnemonic('n');
		}
		return mnNuevo;
	}
	private JMenuItem getMntmContenidos() {
		if (mntmContenidos == null) {
			mntmContenidos = new JMenuItem("Contenidos");
			mntmContenidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/* Mensajes mostrados desde el menú: */
					JOptionPane.showMessageDialog(null, "Ayuda no disponible", "Contenidos de la Ayuda",
												JOptionPane.INFORMATION_MESSAGE);
				}
			});
			mntmContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
			mntmContenidos.setMnemonic('C');
		}
		return mntmContenidos;
	}
	private JMenuItem getNmtSalir() {
		if (nmtSalir == null) {
			nmtSalir = new JMenuItem("Salir");
			nmtSalir.setMnemonic('S');
		}
		return nmtSalir;
	}
	private JMenuItem getMntmAcerca() {
		if (mntmAcerca == null) {
			mntmAcerca = new JMenuItem("Acerca de");
			mntmAcerca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
												"Aplicación para TPV de comida rápida \n Realizada por Jorge Blanco Sanchez\n Prácticas CPM 22-23 \n EII Oviedo",
												"Acerca de", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			mntmAcerca.setMnemonic('E');
		}
		return mntmAcerca;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
}
