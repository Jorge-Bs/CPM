package castleBooker.ui;


import javax.swing.JDialog;

import castleBooker.sevice.App;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;

public class VentanaReserva extends JDialog {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private App app;
	private Locale location;
	private JLabel lbAmountOfRooms;
	private JLabel lbAmountOfPeople;
	private JLabel lbAmountOfDays;
	private ResourceBundle textos;
	private JLabel lbPrice;
	private JDateChooser calendario;
	private JLabel lbDate;
	private SpinnerModificados cbM= new SpinnerModificados();
	private JSpinner spRooms;
	private JSpinner spPeople;
	private JSpinner spDays;
	private JPanel pnBotonesConfirmacionFechas;
	private JButton btnAceptar;
	private JButton btnVolver;
	private ProcesaBotones pb = new ProcesaBotones();
	private JPanel pnFechas;
	private JPanel pnPrecio;
	private JPanel pnBotones;
	private JPanel pnPersonalData;
	private JLabel lbFullName;
	private JLabel lbId;
	private JLabel lbEmail;
	private JScrollPane scrComentarios;
	private JLabel lbComentarios;
	private JTextArea txComentarios;
	private JTextField txName;
	private JTextField txId;
	private JTextField txEmail;
	private JPanel pnBotonesConfirmacionDatos;
	private JPanel pnBotonesDatos;
	private JButton btnAceptarDatos;
	private JButton btnVolverDatos;
	private JPanel pnConfirmacion;
	private JLabel lbAdvertencia;
	private JPanel pnDescuento;
	private JScrollPane scrDescuento;
	private JTextArea txDescuento;
	private JPanel pnRadios;
	private JRadioButton rdbSi;
	private JRadioButton srbNo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lbCastillo;
	private JTextField txCastilloFinal;
	private JLabel lbName;
	private JLabel lbIdFinal;
	private JLabel lbArrivalDateFinal;
	private JLabel lbAmountOfDaysFinal;
	private JLabel lbAmountOfPeopleFinal;
	private JLabel lbEmailFinal;
	private JTextField txNameFinal;
	private JTextField txIdFinal;
	private JTextField txEmailFinal;
	private JTextField txArrivalDateFinal;
	private JTextField txAmountOfDaysFianl;
	private JTextField txAmountOfPeopleFinal;
	private JLabel lbRoomsFinal;
	private JTextField txRoomsFinal;
	private JPanel pnConfirmacionFinal;
	private JPanel pnBotonesFinales;
	private JPanel pnPreciosFinal;
	private JLabel lbPrecioDescuento;
	private ProcesaRadiosDecuentos pRD = new ProcesaRadiosDecuentos();
	private JButton btnConfirmarFinal;
	private JButton btnVolverADatos;
	private JPanel pnPrecioDatos;
	private VentanaPrincipal vp;

	/**
	 * Create the dialog.
	 */
	public VentanaReserva(VentanaPrincipal vp,App app) {
		this.vp=vp;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.location=app.getLocation();
		setResizable(false);
		setModal(true);
		this.app=app;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReserva.class.getResource("/img/icon.png")));
		setBounds(100, 100, 499, 478);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new CardLayout(0, 0));
		getContentPane().add(getPnFechas(), "fecha");
		getContentPane().add(getPnPersonalData(), "info");
		getContentPane().add(getPnConfirmacion(), "confirmar");
		
		
		setTextLocation();
		
		
	}
	
	private void setTextLocation() {
		textos = ResourceBundle.getBundle("rcs/text",location);
		setTitle(textos.getString("tituloReserva"));
		
		getLbAmountOfRooms().setText(textos.getString("habitaciones"));
		getLbAmountOfRooms().setDisplayedMnemonic(textos.getString("mnemonicHabitaciones").charAt(0));
		
		getLbAmountOfPeople().setText(textos.getString("personas"));
		getLbAmountOfPeople().setDisplayedMnemonic(textos.getString("mnemonicPersonas").charAt(0));
		
		getLbAmountOfDays().setText(textos.getString("dias"));
		getLbAmountOfDays().setDisplayedMnemonic(textos.getString("mnemonicDias").charAt(0));
		
		setTextLabelPrice();
		
		getLbDate().setText(textos.getString("date"));
		getLbDate().setDisplayedMnemonic(textos.getString("mnemonicDate").charAt(0));
		
		getBtnAceptar().setText(textos.getString("aceptar"));
		getBtnAceptar().setMnemonic(textos.getString("mnemonicAceptar").charAt(0));
		
		getBtnVolver().setText(textos.getString("volver"));
		getBtnVolver().setMnemonic(textos.getString("mnemonicVolver").charAt(0));
				
		JButton boton = (JButton) getCalendario().getComponent(0);
		boton.setToolTipText(textos.getString("tooltipCalendario"));
		
		calendario.setLocale(location);
		
		
		getLbFullName().setText(textos.getString("fullName"));
		getLbFullName().setDisplayedMnemonic(textos.getString("mnemonicFullName").charAt(0));
		
		getLbId().setText(textos.getString("id"));
		getLbId().setDisplayedMnemonic(textos.getString("mnemonicId").charAt(0));
		
		getLbEmail().setText(textos.getString("email"));
		getLbEmail().setDisplayedMnemonic(textos.getString("mnemonicEmail").charAt(0));
		
		getLbComentarios().setText(textos.getString("comentarios"));
		getLbComentarios().setDisplayedMnemonic(textos.getString("mnemonicComentarios").charAt(0));
		
		getBtnAceptarDatos().setText(textos.getString("aceptar"));
		getBtnAceptarDatos().setMnemonic(textos.getString("mnemonicAceptar").charAt(0));
		
		getBtnVolverDatos().setText(textos.getString("volver"));
		getBtnVolverDatos().setMnemonic(textos.getString("mnemonicVolver").charAt(0));
		
		getLbAdvertencia().setText(textos.getString("advertencia"));
		
		getTxDescuento().setText(textos.getString("aplicarDescuento"));
		
		getLbCastillo().setText(textos.getString("castilloFinal"));
		
		getLbName().setText(textos.getString("nombreFinal"));
		
		getLbIdFinal().setText(textos.getString("idFinal"));
		
		getLbEmailFinal().setText(textos.getString("emailFinal"));
		
		getLbRoomsFinal().setText(textos.getString("habitaciones"));
		
		getLbArrivalDateFinal().setText(textos.getString("date"));
		
		getLbAmountOfDaysFinal().setText(textos.getString("dias"));
		
		getLbAmountOfPeopleFinal().setText(textos.getString("personas"));
		
		
		getBtnConfirmarFinal().setText(textos.getString("aceptar"));
		getBtnConfirmarFinal().setMnemonic(textos.getString("mnemonicAceptar").charAt(0));
		
		getBtnVolverADatos().setText(textos.getString("volver"));
		getBtnVolverADatos().setMnemonic(textos.getString("mnemonicVolver").charAt(0));
		
	}
	private void setTextLabelPrice() {
		NumberFormat precio = NumberFormat.getCompactNumberInstance(location, Style.LONG);
		getLbPrice().setText(textos.getString("precio")+precio.format(app.getPrice())+textos.getString("moneda"));
	}

	private JLabel getLbAmountOfRooms() {
		if (lbAmountOfRooms == null) {
			lbAmountOfRooms = new JLabel("New label");
			lbAmountOfRooms.setLabelFor(getSpRooms());
			lbAmountOfRooms.setBounds(110, 142, 144, 30);
		}
		return lbAmountOfRooms;
	}
	private JLabel getLbAmountOfPeople() {
		if (lbAmountOfPeople == null) {
			lbAmountOfPeople = new JLabel("New label");
			lbAmountOfPeople.setLabelFor(getSpPeople());
			lbAmountOfPeople.setBounds(110, 233, 144, 30);
		}
		return lbAmountOfPeople;
	}
	private JLabel getLbAmountOfDays() {
		if (lbAmountOfDays == null) {
			lbAmountOfDays = new JLabel("New label");
			lbAmountOfDays.setLabelFor(getSpDays());

			lbAmountOfDays.setBounds(110, 324, 144, 30);
		}
		return lbAmountOfDays;
	}
	private JLabel getLbPrice() {
		if (lbPrice == null) {
			lbPrice = new JLabel("New label");
		}
		return lbPrice;
	}
	
	private JDateChooser getCalendario() {
		if(calendario==null) {
			calendario= new JDateChooser();
			calendario.setBounds(289, 56, 128, 22);
			calendario.setDate(app.getDate());
			
		}
		return calendario;
	}
	private JLabel getLbDate() {
		if (lbDate == null) {
			lbDate = new JLabel("");
			lbDate.setLabelFor(getCalendario());
			lbDate.setBounds(110, 51, 144, 30);
		}
		return lbDate;
	}
	
	private class SpinnerModificados implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			procesaCambiosFechas();
			setTextLabelPrice();
		}
		
	}
	
	private void procesaCambiosFechas() {
		app.updateDate((Integer)getSpRooms().getValue(),(Integer)getSpPeople().getValue(),
				(Integer)getSpDays().getValue(),getCalendario().getDate());
	}
	
	private JSpinner getSpRooms() {
		if (spRooms == null) {
			spRooms = new JSpinner();
			spRooms.setModel(new SpinnerNumberModel(app.getRoomsInfo(), 1, 20, 1));
			spRooms.setBounds(313, 148, 59, 20);
			spRooms.addChangeListener(cbM);
		}
		return spRooms;
	}
	private JSpinner getSpPeople() {
		if (spPeople == null) {
			spPeople = new JSpinner();
			spPeople.setModel(new SpinnerNumberModel(app.getPeopleInfo(), 1, 40, 1));
			spPeople.setBounds(313, 240, 59, 20);
			spPeople.addChangeListener(cbM);
		}
		return spPeople;
	}
	private JSpinner getSpDays() {
		if (spDays == null) {
			spDays = new JSpinner();
			spDays.setModel(new SpinnerNumberModel(app.getDaysInfo(), 1, 31, 1));
			spDays.setBounds(313, 332, 59, 20);
			spDays.addChangeListener(cbM);
		}
		return spDays;
	}
	private JPanel getPnBotonesConfirmacionFechas() {
		if (pnBotonesConfirmacionFechas == null) {
			pnBotonesConfirmacionFechas = new JPanel();
			pnBotonesConfirmacionFechas.setBounds(52, 365, 388, 65);
			pnBotonesConfirmacionFechas.setLayout(new GridLayout(0, 1, 0, 0));
			pnBotonesConfirmacionFechas.add(getPnPrecio());
			pnBotonesConfirmacionFechas.add(getPnBotones());
		}
		return pnBotonesConfirmacionFechas;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("New button");
			btnAceptar.setActionCommand("confirmar");
			btnAceptar.addActionListener(pb);
		}
		return btnAceptar;
	}
	private JButton getBtnVolver() {
		if (btnVolver == null) {
			btnVolver = new JButton("New button");
			btnVolver.setActionCommand("volver");
			btnVolver.addActionListener(pb);
		}
		return btnVolver;
	}
	
	public void updateDate() {
		setTextLabelPrice();
		getSpRooms().setModel(new SpinnerNumberModel(app.getRoomsInfo(), 1, 20, 1));
		getSpPeople().setModel(new SpinnerNumberModel(app.getPeopleInfo(), 1, 40, 1));
		getSpDays().setModel(new SpinnerNumberModel(app.getDaysInfo(), 1, 31, 1));
		getCalendario().setDate(app.getDate());
	}
	
	private void updatePersonalData() {
		getTxName().setText("");
		getTxId().setText("");
		getTxEmail().setText("");
		getTxComentarios().setText("");
	}
	
	
	//TODO:Inicializar los datos de la labels
	public void inicializar() {
		CardLayout cd = (CardLayout) getContentPane().getLayout();
		cd.show(getContentPane(), "fecha");
		getPnFechas().add(getLbPrice());
		updateDate();
		updatePersonalData();
	}
	
	private class ProcesaBotones implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String id = e.getActionCommand();
			switch(id) {
			case "volver":
				dispose();
				break;
			case "confirmar":
				confirmarFechas();
				break;
			case "volverDatos":
				cambiarPanelFechas();
				break;
			case "confirmarDatos":
				if(comprobarCampos()) {
					confirmarDatos();
					cambiarPanelConfirmacion();
				}else {
					JOptionPane.showMessageDialog(null, textos.getString("errorDatos"),
							textos.getString("errorHabitacionTitulo"),JOptionPane.INFORMATION_MESSAGE);
					spRooms.grabFocus();
				}
				break;
			case "volverFinal":
				confirmarFechas();
			}
		}
	}
	
	private void cambiarPanelConfirmacion() {
		CardLayout cd = (CardLayout) getContentPane().getLayout();
		cd.show(getContentPane(), "confirmar");
		getPnPreciosFinal().add(getLbPrice());
		updateFinalFields();
		if(app.hasActualUserDiscount()) {
			getPnDescuento().setVisible(true);
			if(getRdbSi().isSelected()) {
				getLbPrecioDescuento().setVisible(true);
				String value = textos.getString("Preciodescuento")+ app.getDiscountPrice() + textos.getString("moneda");
				getLbPrecioDescuento().setText(value);
			}
		}else {
			getPnDescuento().setVisible(false);
			getLbPrecioDescuento().setVisible(false);
			String value = textos.getString("Preciodescuento")+ app.getDiscountPrice() + textos.getString("moneda");
			getLbPrecioDescuento().setText(value);
		}
	}
	
	private boolean comprobarCampos() {
		if(getTxName().getText().isEmpty()||getTxName().getText().isBlank()) {
			getTxName().grabFocus();
			return false;
		}else if(getTxId().getText().isEmpty() || getTxId().getText().isBlank()) {
			getTxId().grabFocus();
			return false;
		}else if(getTxEmail().getText().isEmpty() || getTxEmail().getText().isBlank()) {
			getTxEmail().grabFocus();
			return false;
		}else {
			return true;
		}
	}
	
	private void confirmarFechas() {
		if(!app.habitacionesValidas()) {
			JOptionPane.showMessageDialog(null, textos.getString("errorHabitacion"),
					textos.getString("errorHabitacionTitulo"),JOptionPane.INFORMATION_MESSAGE);
			spRooms.grabFocus();
		}else {
			procesaCambiosFechas();
			cambiarPanelInfoPersonal();
		}
	}
	
	private void confirmarDatos() {
		app.updatePersonalData(getTxName().getText(),getTxId().getText(),getTxEmail().getText(),getTxComentarios().getText());
	}
	
	private void cambiarPanelInfoPersonal() {
		getPnPrecioDatos().add(getLbPrice(), 0);
		CardLayout cd = (CardLayout) getContentPane().getLayout();
		cd.show(getContentPane(), "info");
	}
	
	private void cambiarPanelFechas() {
		getPnPrecio().add(getLbPrice(),0);
		CardLayout cd = (CardLayout) getContentPane().getLayout();
		cd.show(getContentPane(), "fecha");
	}

	private JPanel getPnFechas() {
		if (pnFechas == null) {
			pnFechas = new JPanel();
			pnFechas.setLayout(null);
			pnFechas.add(getLbDate());
			pnFechas.add(getLbAmountOfRooms());
			pnFechas.add(getLbAmountOfPeople());
			pnFechas.add(getLbAmountOfDays());
			pnFechas.add(getCalendario());
			pnFechas.add(getSpRooms());
			pnFechas.add(getSpPeople());
			pnFechas.add(getSpDays());
			pnFechas.add(getPnBotonesConfirmacionFechas());
		}
		return pnFechas;
	}
	private JPanel getPnPrecio() {
		if (pnPrecio == null) {
			pnPrecio = new JPanel();
			pnPrecio.add(getLbPrice());
		}
		return pnPrecio;
	}
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.add(getBtnAceptar());
			pnBotones.add(getBtnVolver());
		}
		return pnBotones;
	}
	
//-----------------------------------------------------------------------------------------------------------------------	
	
	
	private JPanel getPnPersonalData() {
		if (pnPersonalData == null) {
			pnPersonalData = new JPanel();
			pnPersonalData.setLayout(null);
			pnPersonalData.add(getLbFullName());
			pnPersonalData.add(getLbId());
			pnPersonalData.add(getLbEmail());
			pnPersonalData.add(getLbComentarios());
			pnPersonalData.add(getScrComentarios());
			pnPersonalData.add(getTxName());
			pnPersonalData.add(getTxId());
			pnPersonalData.add(getTxEmail());
			pnPersonalData.add(getPnBotonesConfirmacionDatos());
			fillFields();
		}
		return pnPersonalData;
	}
	
	private void fillFields() {
		getTxId().setText(app.getUserId());
	}
	private JLabel getLbFullName() {
		if (lbFullName == null) {
			lbFullName = new JLabel("New label");
			lbFullName.setLabelFor(getTxName());
			lbFullName.setBounds(36, 40, 417, 21);
		}
		return lbFullName;
	}
	private JLabel getLbId() {
		if (lbId == null) {
			lbId = new JLabel("New label");
			lbId.setLabelFor(getTxId());
			lbId.setBounds(36, 87, 417, 21);
		}
		return lbId;
	}
	private JLabel getLbEmail() {
		if (lbEmail == null) {
			lbEmail = new JLabel("New label");
			lbEmail.setLabelFor(getTxEmail());
			lbEmail.setBounds(36, 147, 417, 21);
		}
		return lbEmail;
	}
	private JScrollPane getScrComentarios() {
		if (scrComentarios == null) {
			scrComentarios = new JScrollPane();
			scrComentarios.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrComentarios.setBounds(253, 216, 200, 143);
			scrComentarios.setViewportView(getTxComentarios());
		}
		return scrComentarios;
	}
	private JLabel getLbComentarios() {
		if (lbComentarios == null) {
			lbComentarios = new JLabel("New label");
			lbComentarios.setLabelFor(getTxComentarios());
			lbComentarios.setBounds(36, 277, 184, 21);
		}
		return lbComentarios;
	}
	private JTextArea getTxComentarios() {
		if (txComentarios == null) {
			txComentarios = new JTextArea();
			txComentarios.setWrapStyleWord(true);
			txComentarios.setLineWrap(true);
		}
		return txComentarios;
	}
	private JTextField getTxName() {
		if (txName == null) {
			txName = new JTextField();
			txName.setBounds(292, 38, 161, 25);
			txName.setColumns(10);
		}
		return txName;
	}
	private JTextField getTxId() {
		if (txId == null) {
			txId = new JTextField();
			txId.setBounds(292, 85, 161, 25);
			txId.setColumns(10);
		}
		return txId;
	}
	private JTextField getTxEmail() {
		if (txEmail == null) {
			txEmail = new JTextField();
			txEmail.setBounds(292, 145, 161, 25);
			txEmail.setColumns(10);
		}
		return txEmail;
	}
	private JPanel getPnBotonesConfirmacionDatos() {
		if (pnBotonesConfirmacionDatos == null) {
			pnBotonesConfirmacionDatos = new JPanel();
			pnBotonesConfirmacionDatos.setBounds(72, 370, 343, 60);
			pnBotonesConfirmacionDatos.setLayout(new GridLayout(2, 0, 0, 0));
			pnBotonesConfirmacionDatos.add(getPnPrecioDatos());
			pnBotonesConfirmacionDatos.add(getPnBotonesDatos());
		}
		return pnBotonesConfirmacionDatos;
	}
	private JPanel getPnBotonesDatos() {
		if (pnBotonesDatos == null) {
			pnBotonesDatos = new JPanel();
			pnBotonesDatos.add(getBtnAceptarDatos());
			pnBotonesDatos.add(getBtnVolverDatos());
		}
		return pnBotonesDatos;
	}
	private JButton getBtnAceptarDatos() {
		if (btnAceptarDatos == null) {
			btnAceptarDatos = new JButton("New button");
			btnAceptarDatos.setActionCommand("confirmarDatos");
			btnAceptarDatos.addActionListener(pb);
		}
		return btnAceptarDatos;
	}
	private JButton getBtnVolverDatos() {
		if (btnVolverDatos == null) {
			btnVolverDatos = new JButton("New button");
			btnVolverDatos.setActionCommand("volverDatos");
			btnVolverDatos.addActionListener(pb);
		}
		return btnVolverDatos;
	}
	
	
	private JPanel getPnConfirmacion() {
		if (pnConfirmacion == null) {
			pnConfirmacion = new JPanel();
			pnConfirmacion.setLayout(null);
			pnConfirmacion.add(getLbAdvertencia());
			pnConfirmacion.add(getPnDescuento());
			pnConfirmacion.add(getLbCastillo());
			pnConfirmacion.add(getTxCastilloFinal());
			pnConfirmacion.add(getLbName());
			pnConfirmacion.add(getLbIdFinal());
			pnConfirmacion.add(getLbEmailFinal());
			pnConfirmacion.add(getLbRoomsFinal());
			pnConfirmacion.add(getLbArrivalDateFinal());
			pnConfirmacion.add(getLbAmountOfDaysFinal());
			pnConfirmacion.add(getLbAmountOfPeopleFinal());
			pnConfirmacion.add(getTxCastilloFinal());
			pnConfirmacion.add(getTxNameFinal());
			pnConfirmacion.add(getTxIdFinal());
			pnConfirmacion.add(getTxEmailFinal());
			pnConfirmacion.add(getTxArrivalDateFinal());
			pnConfirmacion.add(getTxAmountOfDaysFianl());
			pnConfirmacion.add(getTxAmountOfPeopleFinal());
			pnConfirmacion.add(getTxRoomsFinal());
			pnConfirmacion.add(getPnConfirmacionFinal());
			
		}
		return pnConfirmacion;
	}
	private JLabel getLbAdvertencia() {
		if (lbAdvertencia == null) {
			lbAdvertencia = new JLabel("New label");
			lbAdvertencia.setHorizontalAlignment(SwingConstants.CENTER);
			lbAdvertencia.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
			lbAdvertencia.setBounds(10, 5, 465, 42);
		}
		return lbAdvertencia;
	}
	private JPanel getPnDescuento() {
		if (pnDescuento == null) {
			pnDescuento = new JPanel();
			pnDescuento.setVisible(false);
			pnDescuento.setBounds(331, 58, 144, 118);
			pnDescuento.setLayout(new BorderLayout(0, 0));
			pnDescuento.add(getScrDescuento(), BorderLayout.CENTER);
			pnDescuento.add(getPnRadios(), BorderLayout.SOUTH);
		}
		return pnDescuento;
	}
	private JScrollPane getScrDescuento() {
		if (scrDescuento == null) {
			scrDescuento = new JScrollPane();
			scrDescuento.setViewportView(getTxDescuento());
		}
		return scrDescuento;
	}
	private JTextArea getTxDescuento() {
		if (txDescuento == null) {
			txDescuento = new JTextArea();
			txDescuento.setEditable(false);
			txDescuento.setLineWrap(true);
			txDescuento.setWrapStyleWord(true);
		}
		return txDescuento;
	}
	private JPanel getPnRadios() {
		if (pnRadios == null) {
			pnRadios = new JPanel();
			pnRadios.setLayout(new GridLayout(1, 1, 0, 0));
			pnRadios.add(getRdbSi());
			pnRadios.add(getSrbNo());
		}
		return pnRadios;
	}
	private JRadioButton getRdbSi() {
		if (rdbSi == null) {
			rdbSi = new JRadioButton("si");
			rdbSi.setSelected(true);
			buttonGroup.add(rdbSi);
			rdbSi.addActionListener(pRD);
		}
		return rdbSi;
	}
	private JRadioButton getSrbNo() {
		if (srbNo == null) {
			srbNo = new JRadioButton("no");
			srbNo.addActionListener(pRD);
			buttonGroup.add(srbNo);
		}
		return srbNo;
	}
	private JLabel getLbCastillo() {
		if (lbCastillo == null) {
			lbCastillo = new JLabel("New label");
			lbCastillo.setBounds(20, 58, 153, 27);
		}
		return lbCastillo;
	}
	private JTextField getTxCastilloFinal() {
		if (txCastilloFinal == null) {
			txCastilloFinal = new JTextField();
			txCastilloFinal.setEditable(false);
			txCastilloFinal.setBounds(183, 58, 148, 27);
			txCastilloFinal.setColumns(10);
		}
		return txCastilloFinal;
	}
	private JLabel getLbName() {
		if (lbName == null) {
			lbName = new JLabel("New label");
			lbName.setBounds(20, 96, 153, 27);
		}
		return lbName;
	}
	private JLabel getLbIdFinal() {
		if (lbIdFinal == null) {
			lbIdFinal = new JLabel("New label");
			lbIdFinal.setBounds(20, 134, 153, 27);
		}
		return lbIdFinal;
	}
	private JLabel getLbArrivalDateFinal() {
		if (lbArrivalDateFinal == null) {
			lbArrivalDateFinal = new JLabel("New label");
			lbArrivalDateFinal.setBounds(20, 248, 153, 27);
		}
		return lbArrivalDateFinal;
	}
	private JLabel getLbAmountOfDaysFinal() {
		if (lbAmountOfDaysFinal == null) {
			lbAmountOfDaysFinal = new JLabel("New label");
			lbAmountOfDaysFinal.setBounds(20, 286, 153, 27);
		}
		return lbAmountOfDaysFinal;
	}
	private JLabel getLbAmountOfPeopleFinal() {
		if (lbAmountOfPeopleFinal == null) {
			lbAmountOfPeopleFinal = new JLabel("New label");
			lbAmountOfPeopleFinal.setBounds(20, 324, 153, 27);
		}
		return lbAmountOfPeopleFinal;
	}
	private JLabel getLbEmailFinal() {
		if (lbEmailFinal == null) {
			lbEmailFinal = new JLabel("New label");
			lbEmailFinal.setBounds(20, 172, 153, 27);
		}
		return lbEmailFinal;
	}
	private JTextField getTxNameFinal() {
		if (txNameFinal == null) {
			txNameFinal = new JTextField();
			txNameFinal.setEditable(false);
			txNameFinal.setColumns(10);
			txNameFinal.setBounds(183, 96, 148, 27);
		}
		return txNameFinal;
	}
	private JTextField getTxIdFinal() {
		if (txIdFinal == null) {
			txIdFinal = new JTextField();
			txIdFinal.setEditable(false);
			txIdFinal.setColumns(10);
			txIdFinal.setBounds(183, 134, 148, 27);
		}
		return txIdFinal;
	}
	private JTextField getTxEmailFinal() {
		if (txEmailFinal == null) {
			txEmailFinal = new JTextField();
			txEmailFinal.setEditable(false);
			txEmailFinal.setColumns(10);
			txEmailFinal.setBounds(183, 172, 148, 27);
		}
		return txEmailFinal;
	}
	private JTextField getTxArrivalDateFinal() {
		if (txArrivalDateFinal == null) {
			txArrivalDateFinal = new JTextField();
			txArrivalDateFinal.setEditable(false);
			txArrivalDateFinal.setColumns(10);
			txArrivalDateFinal.setBounds(183, 248, 148, 27);
		}
		return txArrivalDateFinal;
	}
	private JTextField getTxAmountOfDaysFianl() {
		if (txAmountOfDaysFianl == null) {
			txAmountOfDaysFianl = new JTextField();
			txAmountOfDaysFianl.setEditable(false);
			txAmountOfDaysFianl.setColumns(10);
			txAmountOfDaysFianl.setBounds(183, 286, 148, 27);
		}
		return txAmountOfDaysFianl;
	}
	private JTextField getTxAmountOfPeopleFinal() {
		if (txAmountOfPeopleFinal == null) {
			txAmountOfPeopleFinal = new JTextField();
			txAmountOfPeopleFinal.setEditable(false);
			txAmountOfPeopleFinal.setColumns(10);
			txAmountOfPeopleFinal.setBounds(183, 324, 148, 27);
		}
		return txAmountOfPeopleFinal;
	}
	private JLabel getLbRoomsFinal() {
		if (lbRoomsFinal == null) {
			lbRoomsFinal = new JLabel("New label");
			lbRoomsFinal.setBounds(20, 210, 153, 27);
		}
		return lbRoomsFinal;
	}
	private JTextField getTxRoomsFinal() {
		if (txRoomsFinal == null) {
			txRoomsFinal = new JTextField();
			txRoomsFinal.setEditable(false);
			txRoomsFinal.setColumns(10);
			txRoomsFinal.setBounds(183, 210, 148, 27);
		}
		return txRoomsFinal;
	}
	private JPanel getPnConfirmacionFinal() {
		if (pnConfirmacionFinal == null) {
			pnConfirmacionFinal = new JPanel();
			pnConfirmacionFinal.setBounds(69, 362, 356, 68);
			pnConfirmacionFinal.setLayout(new GridLayout(2, 0, 0, 0));
			pnConfirmacionFinal.add(getPnPreciosFinal());
			pnConfirmacionFinal.add(getPnBotonesFinales());
		}
		return pnConfirmacionFinal;
	}
	private JPanel getPnBotonesFinales() {
		if (pnBotonesFinales == null) {
			pnBotonesFinales = new JPanel();
			pnBotonesFinales.add(getBtnConfirmarFinal());
			pnBotonesFinales.add(getBtnVolverADatos());
		}
		return pnBotonesFinales;
	}
	private JPanel getPnPreciosFinal() {
		if (pnPreciosFinal == null) {
			pnPreciosFinal = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnPreciosFinal.getLayout();
			flowLayout.setHgap(20);
			pnPreciosFinal.add(getLbPrecioDescuento());
		}
		return pnPreciosFinal;
	}
	private JLabel getLbPrecioDescuento() {
		if (lbPrecioDescuento == null) {
			lbPrecioDescuento = new JLabel("New label");
			lbPrecioDescuento.setVisible(false);
		}
		return lbPrecioDescuento;
	}
	
	private void updateFinalFields() {
		getTxCastilloFinal().setText(app.getCatleReserva());
		getTxNameFinal().setText(app.getUserName());
		getTxIdFinal().setText(app.getUserId());
		getTxEmailFinal().setText(app.getUserEmail());
		getTxRoomsFinal().setText(app.getRoomsInfo()+"");
		getTxArrivalDateFinal().setText(app.getArriveDate());
		getTxAmountOfDaysFianl().setText(app.getDaysInfo()+"");
		getTxAmountOfPeopleFinal().setText(app.getPeopleInfo()+"");
	}
	
	private class ProcesaRadiosDecuentos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(getRdbSi().isSelected()) {
				getLbPrecioDescuento().setVisible(true);
			}else {
				getLbPrecioDescuento().setVisible(false);
			}
		}
		
	}
	private JButton getBtnConfirmarFinal() {
		if (btnConfirmarFinal == null) {
			btnConfirmarFinal = new JButton("New button");
			btnConfirmarFinal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					terminar();
				}
			});
		}
		return btnConfirmarFinal;
	}
	private JButton getBtnVolverADatos() {
		if (btnVolverADatos == null) {
			btnVolverADatos = new JButton("New button");
			btnVolverADatos.setActionCommand("volverFinal");
			btnVolverADatos.addActionListener(pb);
		}
		return btnVolverADatos;
	}
	private JPanel getPnPrecioDatos() {
		if (pnPrecioDatos == null) {
			pnPrecioDatos = new JPanel();
		}
		return pnPrecioDatos;
	}
	
	private void terminar() {
		app.procesarReserva(getRdbSi().isSelected());
		vp.cambiarPanelInicio();
		dispose();
	}
}
