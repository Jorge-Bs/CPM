package uo.cpm.p3.ui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import uo.cpm.p3.exception.InvalidFieldsException;
import uo.cpm.p3.service.McDonalds;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;


public class VentanaRegistro extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int CURRENT_YEAR=2023;

	private JPanel pnContenidos;
	private JLabel lbNombre;
	private JTextField txNombre;
	private JLabel lbYear;
	private JComboBox<String> cbYears;
	private JLabel lbPass;
	private JPasswordField pwPass1;
	private JLabel lbPass2;
	private JPasswordField pwPass2;
	private JButton btSiguiente;
	private JButton btCancelar;
	private JPanel pnData;
	private JPanel pnPedido;
	private JRadioButton rdBtLocal;
	private JRadioButton rdBtLlevar;
	private final ButtonGroup bGroupPedido = new ButtonGroup();
	private McDonalds mac;

	
	
	/*
	 * Tareas 
	 * 
	 * 1 A�o de nacimiento
	 * 		poner datos al combobox utilizar model 100 a�os
	 * 
	 * 2 programar botones, siempre que se quiera cerrar a la aplicacion existe  system.exit(0)
	 * 	siguiente
	 * 
	 * 
	 * 
	 */
	

	/**
	 * Create the frame.
	 */
	public VentanaRegistro(McDonalds mac) {
		setMacdonal(mac);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegistro.class.getResource("/img/logo.png")));
		//Marco
		setTitle("McDonald's: Datos de Registro");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//operacion de la x(cerrar) de la ventana, cierra todos los procesos abiertos
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//cierra la ventana pero no mata los procesos abiertos
		setBounds(100, 100, 600, 300);
		//Panel
		pnContenidos = new JPanel();
		pnContenidos.setBackground(Color.WHITE);
		pnContenidos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnContenidos);//añadir panel al marco
		pnContenidos.setLayout(null);//eliminar layout
		//Añadir todos los componentes al panel
		
		pnContenidos.add(getBtSiguiente());
		pnContenidos.add(getBtCancelar());
		pnContenidos.add(getPnData());
		pnContenidos.add(getPnPedido());
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private void setMacdonal(McDonalds mac) {
		this.mac = mac;
	}
	
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre y apellidos:");
			lbNombre.setBounds(28, 31, 125, 14);
		}
		return lbNombre;
	}
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setBounds(220, 28, 120, 20);
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	private JLabel getLbYear() {
		if (lbYear == null) {
			lbYear = new JLabel("Año de nacimiento:");
			lbYear.setBounds(28, 56, 125, 14);
		}
		return lbYear;
	}
	private JComboBox<String> getCbYears() {
		if (cbYears == null) {
			cbYears = new JComboBox<String>();
			cbYears.setModel(new DefaultComboBoxModel<String>(getYears()));//tarea 1 utilizar programacion
			cbYears.setBounds(220, 61, 86, 22);
		}
		return cbYears;
	}
	
	/**
	 * Establece una lista de string con 100 años
	 * @return a string list with 100 years
	 */
	private String[] getYears() {
		String[] years = new String[100];
		for (int i=0; i<100;i++) {
			Integer year = CURRENT_YEAR-i;
			years[i]= year.toString();
		}
		return years;
	}
	
	
	private JLabel getLbPass() {
		if (lbPass == null) {
			lbPass = new JLabel("Password:");
			lbPass.setBounds(28, 90, 106, 14);
		}
		return lbPass;
	}
	private JPasswordField getPwPass1() {
		if (pwPass1 == null) {
			pwPass1 = new JPasswordField();
			pwPass1.setBounds(220, 94, 120, 14);
		}
		return pwPass1;
	}
	private JLabel getLbPass2() {
		if (lbPass2 == null) {
			lbPass2 = new JLabel("Reinserte Password:");
			lbPass2.setBounds(28, 133, 125, 14);
		}
		return lbPass2;
	}
	private JPasswordField getPwPass2() {
		if (pwPass2 == null) {
			pwPass2 = new JPasswordField();
			pwPass2.setBounds(220, 133, 120, 14);
		}
		return pwPass2;
	}
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						checkFields();
						createConfirmWindow();
					}catch(InvalidFieldsException exception) {
						JOptionPane.showMessageDialog(null, exception.getMessage(),"Revise datos",1);
					}
					
				}
			});
			btSiguiente.setBounds(368, 216, 89, 23);
			btSiguiente.setBackground(Color.GREEN);
		}
		return btSiguiente;
	}
	
	private void createConfirmWindow() {
		VentanaConfirmacion vC = new VentanaConfirmacion();
		vC.setModal(true);
		vC.setVisible(true);
	}
	
	/**
	 * Comprueba que los campos sean correctos
	 * @return
	 */
	private void checkFields() throws InvalidFieldsException{
		checkName(txNombre.getText());
		checkPassword(parseCharToString(pwPass1.getPassword()),parseCharToString(pwPass2.getPassword()));
	}
	
	/**
	 * Se comprueba que el nombre no este vacio
	 * @throws InvalidFieldsException if name is empty
	 */
	private void checkName(String name) throws InvalidFieldsException {
		if(name.isEmpty() || name.isBlank()) {
			throw new InvalidFieldsException("Campos obligatorios: El nombre no puede estar vacio");
		}
	}
	
	/**
	 * Parse una lista de char a String
	 * @param char[] list a parsear
	 * @return string
	 */
	private String parseCharToString(char[] list) {
		return String.valueOf(list);
	}
	
	/**
	 * Compara si las dos contraseñas son iguales
	 * @throws InvalidFieldsException si las contraseñas no son iguales
	 */
	private void checkPassword(String password1, String password2) throws InvalidFieldsException {
		if(password1.isBlank()|| password1.isEmpty()) {
			throw new InvalidFieldsException("El campo de contrasena no puede estar vacio");
		}
		if(password2.isBlank()|| password2.isEmpty()) {
			throw new InvalidFieldsException("El campo de contrasena no puede estar vacio");
		}
		if(!password1.equals(password2)) {
			throw new InvalidFieldsException("Las contraseñas no coinciden");
		}
	}
	
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//System.exit(0);
					//finalizar();
					dispose();
				}
			});
			btCancelar.setBounds(467, 216, 89, 23);
			btCancelar.setBackground(Color.RED);
		}
		return btCancelar;
	}
	
	/*private void finalizar() {
		System.exit(0);
	}*/
	
	private JPanel getPnData() {
		if (pnData == null) {
			pnData = new JPanel();
			pnData.setBackground(new Color(255, 255, 255));
			pnData.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnData.setBounds(60, 11, 362, 158);
			pnData.setLayout(null);
			
			//elementos al panel
			pnData.add(getLbNombre());
			pnData.add(getTxNombre());
			pnData.add(getLbYear());
			pnData.add(getCbYears());
			pnData.add(getLbPass());
			pnData.add(getPwPass1());
			pnData.add(getLbPass2());
			pnData.add(getPwPass2());
			
		}
		return pnData;
	}
	private JPanel getPnPedido() {
		if (pnPedido == null) {
			pnPedido = new JPanel();
			pnPedido.setBorder(new TitledBorder(null, "Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnPedido.setBackground(new Color(255, 255, 255));
			pnPedido.setBounds(66, 190, 163, 49);
			pnPedido.setLayout(null);
			pnPedido.add(getRdBtLocal());
			pnPedido.add(getRdBtLlevar());
		}
		return pnPedido;
	}
	private JRadioButton getRdBtLocal() {
		if (rdBtLocal == null) {
			rdBtLocal = new JRadioButton("Local");
			bGroupPedido.add(rdBtLocal);
			rdBtLocal.setSelected(true);
			rdBtLocal.setBackground(new Color(255, 255, 255));
			rdBtLocal.setBounds(6, 17, 59, 25);
		}
		return rdBtLocal;
	}
	private JRadioButton getRdBtLlevar() {
		if (rdBtLlevar == null) {
			rdBtLlevar = new JRadioButton("Llevar");
			bGroupPedido.add(rdBtLlevar);
			rdBtLlevar.setBackground(new Color(255, 255, 255));
			rdBtLlevar.setBounds(66, 17, 73, 25);
		}
		return rdBtLlevar;
	}
	
}
