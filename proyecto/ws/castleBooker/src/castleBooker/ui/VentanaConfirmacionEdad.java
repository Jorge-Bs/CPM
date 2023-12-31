package castleBooker.ui;



import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import castleBooker.sevice.App;

import java.awt.Toolkit;
import java.util.Locale;
import java.util.ResourceBundle;

public class VentanaConfirmacionEdad extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbMessageEdad;
	private App app;
	private Locale location;
	private ResourceBundle textos;
	

	/**
	 * Create the dialog.
	 */
	public VentanaConfirmacionEdad(App app) {
		this.app=app;
		this.location=app.getLocation();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConfirmacionEdad.class.getResource("/img/icon.png")));
		setModal(true);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().add(getLbMessageEdad());

		setTextLocation();
	}
	
	public void setTextLocation() {
		textos = ResourceBundle.getBundle("rcs/text",location);
		setTitle(textos.getString("tituloEdad"));
	}
	
	private JLabel getLbMessageEdad() {
		if (lbMessageEdad == null) {
			lbMessageEdad = new JLabel("New label");
			lbMessageEdad.setHorizontalAlignment(SwingConstants.CENTER);
			lbMessageEdad.setBounds(10, 11, 416, 44);
		}
		return lbMessageEdad;
	}
}
