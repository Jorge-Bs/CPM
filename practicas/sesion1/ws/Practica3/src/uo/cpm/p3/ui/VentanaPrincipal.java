package uo.cpm.p3.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class VentanaPrincipal extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbLogo;
	private JLabel lbArticulos;
	private JComboBox cBArticulos;
	private JLabel lbUnidades;
	private JSpinner sUnidades;
	private JButton btAñadir;
	private JLabel lbPrecio;
	private JTextField textField;
	private JButton btSiguiente;
	private JButton btCancelar;
	
	
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
	public VentanaPrincipal() {
		setTitle("McDonald's España");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 519);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbLogo());
		contentPane.add(getLbArticulos());
		contentPane.add(getCBArticulos());
		contentPane.add(getLbUnidades());
		contentPane.add(getSUnidades());
		contentPane.add(getBtAñadir());
		contentPane.add(getLbPrecio());
		contentPane.add(getTextField());
		contentPane.add(getBtSiguiente());
		contentPane.add(getBtCancelar());
	}
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("  McDonald's");
			lbLogo.setFont(new Font("Arial Black", Font.PLAIN, 44));
			lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
			lbLogo.setBounds(58, 25, 617, 150);
		}
		return lbLogo;
	}
	private JLabel getLbArticulos() {
		if (lbArticulos == null) {
			lbArticulos = new JLabel("Articulos:");
			lbArticulos.setBounds(58, 202, 192, 29);
		}
		return lbArticulos;
	}
	private JComboBox getCBArticulos() {
		if (cBArticulos == null) {
			cBArticulos = new JComboBox();
			cBArticulos.setBounds(58, 242, 311, 22);
		}
		return cBArticulos;
	}
	private JLabel getLbUnidades() {
		if (lbUnidades == null) {
			lbUnidades = new JLabel("Unidades:");
			lbUnidades.setBounds(448, 209, 167, 14);
		}
		return lbUnidades;
	}
	private JSpinner getSUnidades() {
		if (sUnidades == null) {
			sUnidades = new JSpinner();
			sUnidades.setModel(new SpinnerNumberModel(1, 1, 100, 1));
			sUnidades.setBounds(448, 239, 74, 29);
		}
		return sUnidades;
	}
	private JButton getBtAñadir() {
		if (btAñadir == null) {
			btAñadir = new JButton("Añadir");
			btAñadir.setBackground(new Color(0, 255, 0));
			btAñadir.setBounds(566, 239, 121, 29);
		}
		return btAñadir;
	}
	private JLabel getLbPrecio() {
		if (lbPrecio == null) {
			lbPrecio = new JLabel("Precio del pedido:");
			lbPrecio.setBounds(448, 287, 152, 29);
		}
		return lbPrecio;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(448, 328, 96, 37);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setBackground(new Color(0, 255, 0));
			btSiguiente.setBounds(448, 417, 130, 42);
		}
		return btSiguiente;
	}
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setBackground(new Color(255, 0, 0));
			btCancelar.setBounds(588, 417, 130, 42);
		}
		return btCancelar;
	}
}
