package castleBooker.ui;


import javax.swing.JDialog;

import castleBooker.sevice.App;

import java.awt.Toolkit;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class VentanaReserva extends JDialog {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private App app;
	private Locale location;
	private JLabel lbAmountOfRooms;
	private JLabel lbAmountOfPersons;
	private JLabel lbAmountOfDays;
	private JComboBox<Integer> cbAmountOfRooms;
	private JComboBox<Integer> cbAmountOfPersons;
	private JComboBox<Integer> cbAmountOfDays;
	private ResourceBundle textos;
	private JLabel lbPrice;
	private JDateChooser calendario;

	/**
	 * Create the dialog.
	 */
	public VentanaReserva(App app) {
		this.location=app.getLocation();
		setResizable(false);
		setModal(true);
		this.app=app;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReserva.class.getResource("/img/icon.png")));
		setBounds(100, 100, 499, 412);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().add(getLbAmountOfRooms());
		getContentPane().add(getLbAmountOfPersons());
		getContentPane().add(getLbAmountOfDays());
		getContentPane().add(getCbAmountOfRooms());
		getContentPane().add(getCbAmountOfPersons());
		getContentPane().add(getCbAmountOfDays());
		getContentPane().add(getLbPrice());
		getContentPane().add(getCalendario());
		
		setTextLocation();
		
	}
	
	private void setTextLocation() {
		textos = ResourceBundle.getBundle("rcs/text",location);
		setTitle(textos.getString("tituloReserva"));
		
		getLbAmountOfRooms().setText(textos.getString("habitaciones"));
		getLbAmountOfRooms().setDisplayedMnemonic(textos.getString("mnemonicHabitaciones").charAt(0));
		
		getLbAmountOfPersons().setText(textos.getString("personas"));
		getLbAmountOfPersons().setDisplayedMnemonic(textos.getString("mnemonicPersonas").charAt(0));
		
		getLbAmountOfDays().setText(textos.getString("dias"));
		getLbAmountOfDays().setDisplayedMnemonic(textos.getString("mnemonicDias").charAt(0));
		
		getLbPrice().setText(textos.getString("precio")+app.getPrice()+textos.getString("moneda"));
				
		
		calendario.setLocale(location);
		
	}
	private JLabel getLbAmountOfRooms() {
		if (lbAmountOfRooms == null) {
			lbAmountOfRooms = new JLabel("New label");
			lbAmountOfRooms.setLabelFor(getCbAmountOfRooms());
			lbAmountOfRooms.setBounds(99, 138, 207, 39);
		}
		return lbAmountOfRooms;
	}
	private JLabel getLbAmountOfPersons() {
		if (lbAmountOfPersons == null) {
			lbAmountOfPersons = new JLabel("New label");
			lbAmountOfPersons.setLabelFor(getCbAmountOfPersons());
			lbAmountOfPersons.setBounds(99, 217, 207, 39);
		}
		return lbAmountOfPersons;
	}
	private JLabel getLbAmountOfDays() {
		if (lbAmountOfDays == null) {
			lbAmountOfDays = new JLabel("New label");
			lbAmountOfDays.setLabelFor(getCbAmountOfDays());
			lbAmountOfDays.setBounds(99, 296, 207, 39);
		}
		return lbAmountOfDays;
	}
	private JComboBox<Integer> getCbAmountOfRooms() {
		if (cbAmountOfRooms == null) {
			cbAmountOfRooms = new JComboBox<Integer>();
			cbAmountOfRooms.setBounds(233, 146, 207, 22);
		}
		return cbAmountOfRooms;
	}
	private JComboBox<Integer> getCbAmountOfPersons() {
		if (cbAmountOfPersons == null) {
			cbAmountOfPersons = new JComboBox<Integer>();
			cbAmountOfPersons.setBounds(233, 225, 207, 22);
		}
		return cbAmountOfPersons;
	}
	private JComboBox<Integer> getCbAmountOfDays() {
		if (cbAmountOfDays == null) {
			cbAmountOfDays = new JComboBox<Integer>();
			cbAmountOfDays.setBounds(233, 304, 207, 22);
		}
		return cbAmountOfDays;
	}
	private JLabel getLbPrice() {
		if (lbPrice == null) {
			lbPrice = new JLabel("New label");
			lbPrice.setBounds(143, 346, 361, 14);
		}
		return lbPrice;
	}
	
	private JDateChooser getCalendario() {
		if(calendario==null) {
			calendario= new JDateChooser();
			calendario.setBounds(233, 54, 207, 27);
		}
		return calendario;
	}
}
