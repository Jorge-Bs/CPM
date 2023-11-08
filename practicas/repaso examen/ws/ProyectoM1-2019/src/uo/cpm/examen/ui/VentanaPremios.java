package uo.cpm.examen.ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uo.cpm.examen.model.Articulo;

import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class VentanaPremios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JButton btnTodo;
	private JButton btElectronica;
	private JButton btInfantil;
	private JButton btOcio;
	private JLabel lbPremio;
	private JComboBox<Articulo> cbPremio;
	private JSpinner spUnidades;
	private JLabel lbUnidades;
	private JLabel lbPuntos;
	private JTextField tFPuntos;
	private JButton btAñadir;
	private JTextArea txPedido;
	private JLabel lbPedido;
	private VentanaPrincipal vp;
	private Filtro ft= new Filtro();
	private JButton btnEnd;
	private JLabel lbImagen;


	/**
	 * Create the dialog.
	 */
	public VentanaPremios(VentanaPrincipal vp) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Ruleta de la Suerte: Premios");
		this.vp = vp;
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPremios.class.getResource("/img/ruleta.png")));
		setBounds(100, 100, 825, 552);
		//getContentPane().setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
		getContentPane().add(getLbPremio());
		getContentPane().add(getCbPremio());
		getContentPane().add(getSpUnidades());
		getContentPane().add(getLbUnidades());
		getContentPane().add(getLbPuntos());
		getContentPane().add(getTFPuntos());
		getContentPane().add(getBtAñadir());
		getContentPane().add(getTxPedido());
		getContentPane().add(getLbPedido());
		getContentPane().add(getBtnEnd());
		getContentPane().add(getLbImagen());
		
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(10, 11, 184, 421);
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			panel.add(getBtElectronica());
			panel.add(getBtInfantil());
			panel.add(getBtOcio());
			panel.add(getBtnTodo());
		}
		return panel;
	}
	private JButton getBtnTodo() {
		if (btnTodo == null) {
			btnTodo = new JButton("Todo");
			btnTodo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getCbPremio().setModel(new DefaultComboBoxModel<Articulo>(vp.ap.getArticulos()));
					getLbImagen().setIcon(getImage());
				}
			});
			btnTodo.setBackground(new Color(255, 255, 255));
			btnTodo.setMnemonic('T');
		}
		return btnTodo;
	}
	private JButton getBtElectronica() {
		if (btElectronica == null) {
			btElectronica = new JButton("Electrónica");
			btElectronica.setActionCommand("Electronica");
			btElectronica.setBackground(new Color(255, 255, 255));
			btElectronica.setHorizontalTextPosition(SwingConstants.CENTER);
			btElectronica.addActionListener(ft);
			btElectronica.setVerticalTextPosition(SwingConstants.BOTTOM);
			btElectronica.setIcon(new ImageIcon(VentanaPremios.class.getResource("/img/iconoElectronica.png")));
			btElectronica.setMnemonic('E');
			
		}
		return btElectronica;
	}
	private JButton getBtInfantil() {
		if (btInfantil == null) {
			btInfantil = new JButton("Infantil");
			btInfantil.setActionCommand("Infantil");
			btInfantil.setBackground(new Color(255, 255, 255));
			btInfantil.setHorizontalTextPosition(SwingConstants.CENTER);
			btInfantil.addActionListener(ft);
			btInfantil.setVerticalTextPosition(SwingConstants.BOTTOM);
			btInfantil.setIcon(new ImageIcon(VentanaPremios.class.getResource("/img/iconoInfantil.png")));
			btInfantil.setMnemonic('I');
		}
		return btInfantil;
	}
	private JButton getBtOcio() {
		if (btOcio == null) {
			btOcio = new JButton("Ocio");
			btOcio.setActionCommand("Ocio");
			btOcio.setBackground(new Color(255, 255, 255));
			btOcio.addActionListener(ft);
			btOcio.setVerticalTextPosition(SwingConstants.BOTTOM);
			btOcio.setHorizontalTextPosition(SwingConstants.CENTER);
			btOcio.setIcon(new ImageIcon(VentanaPremios.class.getResource("/img/iconoOcio.png")));
			btOcio.setMnemonic('o');
		}
		return btOcio;
	}
	private JLabel getLbPremio() {
		if (lbPremio == null) {
			lbPremio = new JLabel("Elige Tu Premio:");
			lbPremio.setLabelFor(getCbPremio());
			lbPremio.setDisplayedMnemonic('E');
			lbPremio.setBounds(204, 226, 292, 29);
		}
		return lbPremio;
	}
	private JComboBox<Articulo> getCbPremio() {
		if (cbPremio == null) {
			cbPremio = new JComboBox<Articulo>();
			cbPremio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getLbImagen().setIcon(getImage());
					getSpUnidades().setValue(1);
				}
			});
			cbPremio.setModel(new DefaultComboBoxModel<Articulo>(vp.ap.getArticulos()));
			cbPremio.setBounds(315, 226, 274, 29);
		}
		return cbPremio;
	}
	private JSpinner getSpUnidades() {
		if (spUnidades == null) {
			spUnidades = new JSpinner();
			spUnidades.setModel(new SpinnerNumberModel(1, 1, 100, 1));
			spUnidades.setBounds(614, 226, 63, 29);
		}
		return spUnidades;
	}
	private JLabel getLbUnidades() {
		if (lbUnidades == null) {
			lbUnidades = new JLabel("Unidades:");
			lbUnidades.setDisplayedMnemonic('U');
			lbUnidades.setLabelFor(getSpUnidades());
			lbUnidades.setBounds(614, 201, 110, 14);
		}
		return lbUnidades;
	}
	private JLabel getLbPuntos() {
		if (lbPuntos == null) {
			lbPuntos = new JLabel("Puntos Restante:");
			lbPuntos.setBounds(380, 121, 135, 34);
		}
		return lbPuntos;
	}
	private JTextField getTFPuntos() {
		if (tFPuntos == null) {
			tFPuntos = new JTextField();
			tFPuntos.setEditable(false);
			tFPuntos.setText(vp.ap.getPoitns()+"");
			tFPuntos.setBounds(379, 166, 96, 20);
			tFPuntos.setColumns(10);
		}
		return tFPuntos;
	}
	private JButton getBtAñadir() {
		if (btAñadir == null) {
			btAñadir = new JButton("Añadir");
			btAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					procesar();
				}
			});
			btAñadir.setMnemonic('A');
			btAñadir.setBounds(588, 299, 119, 40);
		}
		return btAñadir;
	}
	private JTextArea getTxPedido() {
		if (txPedido == null) {
			txPedido = new JTextArea();
			txPedido.setLineWrap(true);
			txPedido.setWrapStyleWord(true);
			txPedido.setEditable(false);
			txPedido.setBounds(588, 37, 184, 137);
		}
		return txPedido;
	}
	private JLabel getLbPedido() {
		if (lbPedido == null) {
			lbPedido = new JLabel("Pedido:");
			lbPedido.setBounds(595, 12, 94, 14);
		}
		return lbPedido;
	}
	
	private void procesar() {
		Articulo art = (Articulo)getCbPremio().getSelectedItem();
		int units = (Integer)getSpUnidades().getValue();
		if(vp.ap.add(art, units)==-1)JOptionPane.showMessageDialog(null, "No tienes los puntos necesarios","Error",0);
		showPedido();
		showPoints();
	}
	
	private void showPoints() {
		getTFPuntos().setText(vp.ap.getPoitns()+"");
		
	}
	private void showPedido() {
		getTxPedido().setText(vp.ap.getPedido());
	}
	
	public class Filtro implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton bt =(JButton)e.getSource();
			getCbPremio().setModel(new DefaultComboBoxModel<Articulo>(vp.ap.getArticulos(bt.getActionCommand())));
			getLbImagen().setIcon(getImage());
		}
		
	}
	private JButton getBtnEnd() {
		if (btnEnd == null) {
			btnEnd = new JButton("Finalizar");
			btnEnd.setMnemonic('F');
			btnEnd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,"Enhorabuena y gracias por jugar","Gracias",1);
					disa();
				}
			});
			btnEnd.setBounds(574, 433, 164, 55);
		}
		return btnEnd;
	}
	private JLabel getLbImagen() {
		if (lbImagen == null) {
			lbImagen = new JLabel("");
			lbImagen.setBounds(250, 312, 0, 0);
			lbImagen.setIcon(getImage());
		}
		return lbImagen;
	}
	
	private Icon getImage() {
		Articulo art = (Articulo)getCbPremio().getSelectedItem();
		String path ="/img/"+art.getCode()+".png";
		Icon ic=  new ImageIcon(VentanaPremios.class.getResource(path));
		int wit=ic.getIconWidth();
		int he=ic.getIconHeight();
		getLbImagen().setBounds(250, 312, wit, he);
		return ic;
	}
	
	private void disa() {
		getBtElectronica().setEnabled(false);
		getBtOcio().setEnabled(false);
		getBtInfantil().setEnabled(false);
		getBtnTodo().setEnabled(false);
		getCbPremio().setEnabled(false);
		getSpUnidades().setEnabled(false);
		getBtAñadir().setEnabled(false);
		getBtnEnd().setEnabled(false);
		vp.disa();
	}
}
