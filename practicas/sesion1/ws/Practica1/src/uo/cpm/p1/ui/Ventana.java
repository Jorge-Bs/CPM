package uo.cpm.p1.ui;
import java.awt.Color;

import javax.swing.*;

public class Ventana extends JFrame{
	

	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private JButton btAceptar;
	private JButton btCancelar;
	private JLabel lbName;
	private JTextField tfName;

	public Ventana() {
		// TODO : es importante, paracedio al marco de una ventana
		setTitle("Ventana Principal");
		//setIconImage(image);
		setBounds(10, 10, 500, 500);//x y width height
		setLocationRelativeTo(null);
		
		//TODO : es importante crear panel en para el frame, JPanel, 
		//tambien llamado contenedor
		pnPrincipal = new JPanel();
		//unir panel con frame
		setContentPane(pnPrincipal);
		pnPrincipal.setBackground(Color.white);
		pnPrincipal.setLayout(null);//elimina el layout
		
		//pasos para cualquier boton , etiqueta ...
		//1 declarar atributo de tipo deseado
		//2 instanciar atributo
		//3 cambiar propiedades oportunas
		//4 a�adir el nuevo componente al contenedor
		btAceptar = new JButton();
		btAceptar.setText("Aceptar");
		pnPrincipal.add(btAceptar);
		btAceptar.setBounds(200, 350, 100, 40);
		btAceptar.setForeground(Color.blue);
		
		
		//Boton cancelar
		btCancelar = new JButton();
		btCancelar.setText("Cancelar");
		pnPrincipal.add(btCancelar);
		btCancelar.setBounds(350, 350, 100, 40);
		btCancelar.setForeground(Color.blue);
		//el contenedor tiene layout
		//1 se desactiva el layout
		//2 realizar el dise�o
		//3 aplicar layout
		
		//label de texto
		lbName = new JLabel();
		lbName.setText("Inserta nombre");
		lbName.setBounds(35, 35, 100, 60); 
		pnPrincipal.add(lbName);
		
		//campo de texto
		tfName = new JTextField();
		tfName.setBounds(150, 56, 150, 20); 
		pnPrincipal.add(tfName);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ventana v = new Ventana();
		v.setVisible(true);
	}
	
	

}
