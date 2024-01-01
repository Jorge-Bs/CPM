package castleBooker.ui;



import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import castleBooker.sevice.App;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;

public class VentanaConfirmacionEdad extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbMessageEdad;
	private App app;
	private Locale location;
	private ResourceBundle textos;
	private JLabel lbEdad;
	private JDateChooser calendario;
	private JPanel pnBotones;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private GameUi game;
	private ProcesaBotones pb = new ProcesaBotones();
	private JPanel pnComprobarEdad;

	/**
	 * Create the dialog.
	 */
	public VentanaConfirmacionEdad(App app,GameUi game) {
		setResizable(false);
		this.app=app;
		this.game=game;
		this.location=app.getLocation();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConfirmacionEdad.class.getResource("/img/icon.png")));
		setModal(true);
		setBounds(100, 100, 450, 210);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().add(getLbMessageEdad());
		getContentPane().add(getLbEdad());
		getContentPane().add(getCalendario());
		getContentPane().add(getPnBotones());
		getContentPane().add(getPnComprobarEdad());

		setTextLocation();
	}
	
	public void setTextLocation() {
		textos = ResourceBundle.getBundle("rcs/text",location);
		setTitle(textos.getString("tituloEdad"));
		
		getLbMessageEdad().setText(textos.getString("edad"));
		
		getLbEdad().setText(textos.getString("lbEdad"));
		getLbEdad().setDisplayedMnemonic(textos.getString("mnemonicLbEdad").charAt(0));
		
		getBtnAceptar().setText(textos.getString("aceptar"));
		getBtnAceptar().setMnemonic(textos.getString("mnemonicAceptar").charAt(0));
		
		getBtnCancelar().setText(textos.getString("volver"));
		getBtnCancelar().setMnemonic(textos.getString("mnemonicVolver").charAt(0));
	}
	
	private JLabel getLbMessageEdad() {
		if (lbMessageEdad == null) {
			lbMessageEdad = new JLabel("New label");
			lbMessageEdad.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
			lbMessageEdad.setHorizontalAlignment(SwingConstants.CENTER);
			lbMessageEdad.setBounds(10, 11, 416, 44);
		}
		return lbMessageEdad;
	}
	private JLabel getLbEdad() {
		if (lbEdad == null) {
			lbEdad = new JLabel("New label");
			lbEdad.setLabelFor(getCalendario());
			lbEdad.setBounds(20, 66, 210, 30);
		}
		return lbEdad;
	}
	
	private JDateChooser getCalendario() {
		if(calendario==null) {
			calendario = new JDateChooser();
			calendario.setBounds(281, 66, 145, 30);
		}
		return calendario;
	}
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setBounds(10, 132, 416, 30);
			pnBotones.add(getBtnAceptar());
			pnBotones.add(getBtnCancelar());
		}
		return pnBotones;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("New button");
			btnAceptar.addActionListener(pb);
			btnAceptar.setActionCommand("aceptar");
		}
		return btnAceptar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("New button");
			btnCancelar.addActionListener(pb);
			btnCancelar.setActionCommand("volver");
		}
		return btnCancelar;
	}
	
	private class ProcesaBotones implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			aplicarCambios(e.getActionCommand());
			
		}
		
		
	}
	
	private void aplicarCambios(String id) {
		switch(id) {
		case "volver":
			game.inicializar();
			dispose();
			break;
		case "aceptar":
			app.saveAge(getCalendario().getDate());
			if(app.isAgeValid()) {
				
			}else {
				game.inicializar();
				game.dispose();
				dispose();
			}
		}
	}
	private JPanel getPnComprobarEdad() {
		if (pnComprobarEdad == null) {
			pnComprobarEdad = new JPanel();
			pnComprobarEdad.setBounds(0, 0, 436, 173);
		}
		return pnComprobarEdad;
	}
}
