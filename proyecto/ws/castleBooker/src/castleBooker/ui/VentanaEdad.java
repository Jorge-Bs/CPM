package castleBooker.ui;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import castleBooker.sevice.App;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class VentanaEdad extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnComprobarEdad;
	private JLabel lbMessageEdad;
	private JLabel lbEdad;
	private JDateChooser calendario;
	private JPanel pnBotonesEdad;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private ProcesBotones pb = new ProcesBotones();
	private App app;
	private ResourceBundle textos;
	
	public VentanaEdad(App app) {
		this.app=app;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaEdad.class.getResource("/img/icon.png")));
		setModal(true);
		setBounds(100, 100, 450, 234);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().add(getPnComprobarEdad());

		setTextLocation();
	}
	
	void setTextLocation(){
		textos = ResourceBundle.getBundle("rcs/text",app.getLocation());
		
		setTitle(textos.getString("tituloEdad"));
		
		getLbMessageEdad().setText(textos.getString("edad"));
		
		getLbEdad().setText(textos.getString("lbEdad"));
		getLbEdad().setDisplayedMnemonic(textos.getString("mnemonicLbEdad").charAt(0));
		
		getBtnAceptar().setText(textos.getString("aceptar"));
		getBtnAceptar().setMnemonic(textos.getString("mnemonicAceptar").charAt(0));
		
		getBtnCancelar().setText(textos.getString("volver"));
		getBtnCancelar().setMnemonic(textos.getString("mnemonicVolver").charAt(0));
		
		calendario.setLocale(app.getLocation());
	}
	
	private JPanel getPnComprobarEdad() {
		if (pnComprobarEdad == null) {
			pnComprobarEdad = new JPanel();
			pnComprobarEdad.setBounds(0, 0, 436, 197);
			pnComprobarEdad.setLayout(null);
			pnComprobarEdad.add(getLbMessageEdad());
			pnComprobarEdad.add(getLbEdad());
			pnComprobarEdad.add(getCalendario());
			pnComprobarEdad.add(getPnBotonesEdad());
		}
		return pnComprobarEdad;
	}
	
	private JLabel getLbMessageEdad() {
		if (lbMessageEdad == null) {
			lbMessageEdad = new JLabel("New label");
			lbMessageEdad.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
			lbMessageEdad.setHorizontalAlignment(SwingConstants.CENTER);
			lbMessageEdad.setBounds(16, 13, 410, 30);
		}
		return lbMessageEdad;
	}
	private JLabel getLbEdad() {
		if (lbEdad == null) {
			lbEdad = new JLabel("New label");
			lbEdad.setHorizontalAlignment(SwingConstants.RIGHT);
			lbEdad.setLabelFor(getCalendario());
			lbEdad.setBounds(16, 90, 212, 35);
		}
		return lbEdad;
	}
	
	private JDateChooser getCalendario() {
		if(calendario==null) {
			calendario = new JDateChooser();
			calendario.setBounds(254, 97, 125, 20);
		}
		return calendario;
	}
	private JPanel getPnBotonesEdad() {
		if (pnBotonesEdad == null) {
			pnBotonesEdad = new JPanel();
			pnBotonesEdad.setBounds(10, 164, 416, 33);
			pnBotonesEdad.add(getBtnAceptar());
			pnBotonesEdad.add(getBtnCancelar());
		}
		return pnBotonesEdad;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("New button");
			btnAceptar.addActionListener(pb);
			btnAceptar.setActionCommand("aceptarEdad");
		}
		return btnAceptar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("New button");
			btnCancelar.addActionListener(pb);
			btnCancelar.setActionCommand("volverEdad");
		}
		return btnCancelar;
	}
	
	private class ProcesBotones implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String id = e.getActionCommand();
			procesaOpcion(id);
		}
		
	}

	private void procesaOpcion(String id) {
		switch(id) {
		case "aceptarEdad":
			app.saveAge(getCalendario().getDate());
			dispose();
			break;
		case "volverEdad":
			dispose();
		}
	}
	
	void cambiarIdioma() {
		setTextLocation();
	}
}
