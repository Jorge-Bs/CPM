package castleBooker.ui;



import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import castleBooker.sevice.App;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JPanel;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class VentanaGuardadoDescuento extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbMessageEdad;
	private App app;
	private ResourceBundle textos;
	private JLabel lbEdad;
	private JDateChooser calendario;
	private JPanel pnBotonesEdad;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private GameUi game;
	private ProcesaBotones pb = new ProcesaBotones();
	private JPanel pnComprobarEdad;
	private JPanel pnDescuentoObtenido;
	private JLabel lbDescuentoObtenido;
	private JLabel lbMaxDescuento;
	private JPanel pnBotenesDecuento;
	private JButton btnGuardar;
	private JButton btnReintentar;
	private JButton btnSalir;
	private JButton btnNoGuardarYReservar;
	private JPanel pnGuardado;
	private JLabel lbId;
	private JTextField txId;
	private JPanel pnBotonesGuardado;
	private JButton btnGuardarYReservar;
	private JButton btnGuardarYSalir;
	private JButton btnVolverGuardado;
	private JLabel lbDescuentoAGuardar;

	/**
	 * Create the dialog.
	 */
	public VentanaGuardadoDescuento(App app,GameUi game) {
		setResizable(false);
		this.app=app;
		this.game=game;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaGuardadoDescuento.class.getResource("/img/icon.png")));
		setModal(true);
		setBounds(100, 100, 509, 210);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new CardLayout(0, 0));
		getContentPane().add(getPnDescuentoObtenido(), "descuento");
		getContentPane().add(getPnComprobarEdad(), "edad");
		getContentPane().add(getPnGuardado(), "guardar");
		

		setTextLocation();
		crearAyuda();
	}
	
	public void setTextLocation() {
		textos = ResourceBundle.getBundle("rcs/text",app.getLocation());
		setTitle(textos.getString("tituloEdad"));
		
		getLbMessageEdad().setText(textos.getString("edad"));
		
		getLbEdad().setText(textos.getString("lbEdad"));
		getLbEdad().setDisplayedMnemonic(textos.getString("mnemonicLbEdad").charAt(0));
		
		getBtnAceptar().setText(textos.getString("aceptar"));
		getBtnAceptar().setMnemonic(textos.getString("mnemonicAceptar").charAt(0));
		
		getBtnCancelar().setText(textos.getString("volver"));
		getBtnCancelar().setMnemonic(textos.getString("mnemonicVolver").charAt(0));
		
		getLbMaxDescuento().setText(textos.getString("maxDescuento"));
		
		getBtnGuardar().setText(textos.getString("guardar"));
		getBtnGuardar().setMnemonic(textos.getString("mnemonicGuardar").charAt(0));
		
		getBtnReintentar().setText(textos.getString("intentar"));
		getBtnReintentar().setMnemonic(textos.getString("mnemonicIntentar").charAt(0));
		
		getBtnSalir().setText(textos.getString("salir"));
		getBtnSalir().setMnemonic(textos.getString("mnemonicSalir").charAt(0));
		
		getBtnNoGuardarYReservar().setText(textos.getString("reservar"));
		getBtnNoGuardarYReservar().setMnemonic(textos.getString("mnemonicReservar").charAt(0));
		
		getLbId().setText(textos.getString("id"));
		getLbId().setDisplayedMnemonic(textos.getString("mnemonicId").charAt(0));
		
		getBtnGuardarYReservar().setText(textos.getString("guardarReservar"));
		getBtnGuardarYReservar().setMnemonic(textos.getString("mnemonicGuardarReservar").charAt(0));
		
		getBtnGuardarYSalir().setText(textos.getString("guardarSalir"));
		getBtnGuardarYReservar().setMnemonic(textos.getString("mnemonicGuardarSalir").charAt(0));
		
		getBtnVolverGuardado().setText(textos.getString("volver"));
		getBtnVolverGuardado().setMnemonic(textos.getString("mnemonicVolver").charAt(0));
		
		updateTextsDiscount();
	}
	
	private JLabel getLbMessageEdad() {
		if (lbMessageEdad == null) {
			lbMessageEdad = new JLabel("New label");
			lbMessageEdad.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
			lbMessageEdad.setHorizontalAlignment(SwingConstants.CENTER);
			lbMessageEdad.setBounds(16, 13, 469, 30);
		}
		return lbMessageEdad;
	}
	private JLabel getLbEdad() {
		if (lbEdad == null) {
			lbEdad = new JLabel("New label");
			lbEdad.setHorizontalAlignment(SwingConstants.RIGHT);
			lbEdad.setLabelFor(getCalendario());
			lbEdad.setBounds(26, 54, 212, 35);
		}
		return lbEdad;
	}
	
	private JDateChooser getCalendario() {
		if(calendario==null) {
			calendario = new JDateChooser();
			calendario.setBounds(264, 61, 125, 20);
		}
		return calendario;
	}
	private JPanel getPnBotonesEdad() {
		if (pnBotonesEdad == null) {
			pnBotonesEdad = new JPanel();
			pnBotonesEdad.setBounds(16, 129, 469, 33);
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
	
	private class ProcesaBotones implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			aplicarCambios(e.getActionCommand());
			
		}
		
		
	}
	
	private void aplicarCambios(String id) {
		switch(id) {
		case "guardarSalir":
			if(app.camposValidos(getTxId().getText())) {
				if(JOptionPane.YES_OPTION==JOptionPane.showConfirmDialog(
						null,textos.getString("confirmacion"), 
						textos.getString("tituloConfirmacion"), JOptionPane.YES_OPTION,JOptionPane.NO_OPTION)) {
					if(app.guardarDescuento(getTxId().getText())) {
						JOptionPane.showMessageDialog(null, textos.getString("exito"));
						dispose();
						game.salir();
					}else {
						JOptionPane.showMessageDialog(null, textos.getString("yaDescuento"));
						dispose();
						game.salir();
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, textos.getString("errorDatos"));
			}
			break;
		case "guardarReservar":
			if(app.camposValidos(getTxId().getText())) {
				if(JOptionPane.YES_OPTION==JOptionPane.showConfirmDialog(
						null,textos.getString("confirmacion"), 
						textos.getString("tituloConfirmacion"), JOptionPane.YES_OPTION,JOptionPane.NO_OPTION)) {
					if(app.guardarDescuento(getTxId().getText())) {
						JOptionPane.showMessageDialog(null, textos.getString("exito"));
						dispose();
						app.saveId(getTxId().getText());
						game.salirReserva();
					}else {
						JOptionPane.showMessageDialog(null, textos.getString("yaDescuento"));
						app.saveId(getTxId().getText());
						game.salirReserva();
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, textos.getString("errorDatos"));
			}
			break;
		case "salirReservar":
			dispose();
			game.salirReserva();
			break;
		case "salir":
			inicializar();
			dispose();
			game.salir();
			break;
		case "reintentar":
			game.inicializar();
			dispose();
			break;
		case "guardar":
			cambiarPanelEdad();
			break;
		case "volverEdad":
			cambiarPanelDescuento();
			break;
		case "volverGuardar":
			cambiarPanelDescuento();
			break;
		case "aceptarEdad":
			app.saveAge(getCalendario().getDate());
			if(app.isAgeValid()) {
				cambiarPanelGuardado();
			}else {
				JOptionPane.showMessageDialog(null, textos.getString("menor"));
			}
		}
	}
	

	
	
	private void cambiarPanelGuardado() {
		CardLayout cd = (CardLayout) getContentPane().getLayout();
		cd.show(getContentPane(),"guardar");
	}
	
	private void cambiarPanelEdad() {
		if(app.isAgeValid()) {
			cambiarPanelGuardado();
		}else {
			CardLayout cd = (CardLayout) getContentPane().getLayout();
			cd.show(getContentPane(),"edad");
		}
	}
	
	private void cambiarPanelDescuento() {
		CardLayout cd = (CardLayout) getContentPane().getLayout();
		cd.show(getContentPane(),"descuento");
	}
	
	
	private JPanel getPnComprobarEdad() {
		if (pnComprobarEdad == null) {
			pnComprobarEdad = new JPanel();
			pnComprobarEdad.setLayout(null);
			pnComprobarEdad.add(getLbMessageEdad());
			pnComprobarEdad.add(getLbEdad());
			pnComprobarEdad.add(getCalendario());
			pnComprobarEdad.add(getPnBotonesEdad());
		}
		return pnComprobarEdad;
	}
	private JPanel getPnDescuentoObtenido() {
		if (pnDescuentoObtenido == null) {
			pnDescuentoObtenido = new JPanel();
			pnDescuentoObtenido.setLayout(null);
			pnDescuentoObtenido.add(getLbDescuentoObtenido());
			pnDescuentoObtenido.add(getLbMaxDescuento());
			pnDescuentoObtenido.add(getPnBotenesDecuento());
		}
		return pnDescuentoObtenido;
	}
	private JLabel getLbDescuentoObtenido() {
		if (lbDescuentoObtenido == null) {
			lbDescuentoObtenido = new JLabel("New label");
			lbDescuentoObtenido.setHorizontalAlignment(SwingConstants.CENTER);
			lbDescuentoObtenido.setBounds(10, 22, 480, 25);
		}
		return lbDescuentoObtenido;
	}
	private JLabel getLbMaxDescuento() {
		if (lbMaxDescuento == null) {
			lbMaxDescuento = new JLabel("New label");
			lbMaxDescuento.setVisible(false);
			lbMaxDescuento.setHorizontalAlignment(SwingConstants.CENTER);
			lbMaxDescuento.setBounds(10, 65, 480, 25);
		}
		return lbMaxDescuento;
	}
	private JPanel getPnBotenesDecuento() {
		if (pnBotenesDecuento == null) {
			pnBotenesDecuento = new JPanel();
			pnBotenesDecuento.setBounds(5, 93, 485, 78);
			GridBagLayout gbl_pnBotenesDecuento = new GridBagLayout();
			gbl_pnBotenesDecuento.columnWidths = new int[] {111, 50, 161, 50, 111, 0};
			gbl_pnBotenesDecuento.rowHeights = new int[]{39, 39, 0};
			gbl_pnBotenesDecuento.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pnBotenesDecuento.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			pnBotenesDecuento.setLayout(gbl_pnBotenesDecuento);
			GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
			gbc_btnGuardar.gridwidth = 2;
			gbc_btnGuardar.fill = GridBagConstraints.BOTH;
			gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
			gbc_btnGuardar.gridx = 0;
			gbc_btnGuardar.gridy = 0;
			pnBotenesDecuento.add(getBtnGuardar(), gbc_btnGuardar);
			GridBagConstraints gbc_btnReintentar = new GridBagConstraints();
			gbc_btnReintentar.fill = GridBagConstraints.BOTH;
			gbc_btnReintentar.insets = new Insets(0, 0, 5, 5);
			gbc_btnReintentar.gridx = 2;
			gbc_btnReintentar.gridy = 0;
			pnBotenesDecuento.add(getBtnReintentar(), gbc_btnReintentar);
			GridBagConstraints gbc_btnSalir = new GridBagConstraints();
			gbc_btnSalir.gridwidth = 2;
			gbc_btnSalir.fill = GridBagConstraints.BOTH;
			gbc_btnSalir.insets = new Insets(0, 0, 5, 0);
			gbc_btnSalir.gridx = 3;
			gbc_btnSalir.gridy = 0;
			pnBotenesDecuento.add(getBtnSalir(), gbc_btnSalir);
			GridBagConstraints gbc_btnNoGuardarYReservar = new GridBagConstraints();
			gbc_btnNoGuardarYReservar.gridwidth = 3;
			gbc_btnNoGuardarYReservar.fill = GridBagConstraints.BOTH;
			gbc_btnNoGuardarYReservar.insets = new Insets(0, 0, 0, 5);
			gbc_btnNoGuardarYReservar.gridx = 1;
			gbc_btnNoGuardarYReservar.gridy = 1;
			pnBotenesDecuento.add(getBtnNoGuardarYReservar(), gbc_btnNoGuardarYReservar);
		}
		return pnBotenesDecuento;
	}
	private JButton getBtnGuardar() {
		if (btnGuardar == null) {
			btnGuardar = new JButton("New button");
			btnGuardar.addActionListener(pb);
			btnGuardar.setActionCommand("guardar");
		}
		return btnGuardar;
	}
	private JButton getBtnReintentar() {
		if (btnReintentar == null) {
			btnReintentar = new JButton("New button");
			btnReintentar.addActionListener(pb);
			btnReintentar.setActionCommand("reintentar");
		}
		return btnReintentar;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("New button");
			btnSalir.addActionListener(pb);
			btnSalir.setActionCommand("salir");
		}
		return btnSalir;
	}
	private JButton getBtnNoGuardarYReservar() {
		if (btnNoGuardarYReservar == null) {
			btnNoGuardarYReservar = new JButton("New button");
			btnNoGuardarYReservar.addActionListener(pb);
			btnNoGuardarYReservar.setActionCommand("salirReservar");
		}
		return btnNoGuardarYReservar;
	}
	
	private void updateTextsDiscount() {
		String text = textos.getString("Descuento")+app.getDiscountValuePercentage()+"%";
		getLbDescuentoObtenido().setText(text);
		getLbDescuentoAGuardar().setText(textos.getString("descuentoAGuardar")+app.getDiscountValuePercentage()+"%");
	}
	
	void inicializar(){
		cambiarPanelDescuento();
		muestraMaxLabel();
		getCalendario().setDate(app.getDate());
		getTxId().setText("");
	}
	
	void muestraMaxLabel() {
		if(app.isMaxDiscount()) {
			getLbMaxDescuento().setVisible(true);
		}else {
			getLbMaxDescuento().setVisible(false);
		}
		updateTextsDiscount();
	}
	private JPanel getPnGuardado() {
		if (pnGuardado == null) {
			pnGuardado = new JPanel();
			pnGuardado.setLayout(null);
			pnGuardado.add(getLbId());
			pnGuardado.add(getTxId());
			pnGuardado.add(getPnBotonesGuardado());
			pnGuardado.add(getLbDescuentoAGuardar());
		}
		return pnGuardado;
	}
	private JLabel getLbId() {
		if (lbId == null) {
			lbId = new JLabel("New label");
			lbId.setLabelFor(getTxId());
			lbId.setHorizontalAlignment(SwingConstants.RIGHT);
			lbId.setBounds(10, 31, 213, 41);
		}
		return lbId;
	}
	private JTextField getTxId() {
		if (txId == null) {
			txId = new JTextField();
			txId.setBounds(288, 36, 149, 31);
			txId.setColumns(10);
		}
		return txId;
	}
	private JPanel getPnBotonesGuardado() {
		if (pnBotonesGuardado == null) {
			pnBotonesGuardado = new JPanel();
			pnBotonesGuardado.setBounds(10, 107, 475, 55);
			GridBagLayout gbl_pnBotonesGuardado = new GridBagLayout();
			gbl_pnBotonesGuardado.columnWidths = new int[] {119, 119, 119, 119, 0};
			gbl_pnBotonesGuardado.rowHeights = new int[]{27, 27, 0};
			gbl_pnBotonesGuardado.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pnBotonesGuardado.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			pnBotonesGuardado.setLayout(gbl_pnBotonesGuardado);
			GridBagConstraints gbc_btnGuardarYReservar = new GridBagConstraints();
			gbc_btnGuardarYReservar.gridwidth = 2;
			gbc_btnGuardarYReservar.fill = GridBagConstraints.BOTH;
			gbc_btnGuardarYReservar.insets = new Insets(0, 0, 5, 5);
			gbc_btnGuardarYReservar.gridx = 0;
			gbc_btnGuardarYReservar.gridy = 0;
			pnBotonesGuardado.add(getBtnGuardarYReservar(), gbc_btnGuardarYReservar);
			GridBagConstraints gbc_btnGuardarYSalir = new GridBagConstraints();
			gbc_btnGuardarYSalir.gridwidth = 2;
			gbc_btnGuardarYSalir.fill = GridBagConstraints.BOTH;
			gbc_btnGuardarYSalir.insets = new Insets(0, 0, 5, 0);
			gbc_btnGuardarYSalir.gridx = 2;
			gbc_btnGuardarYSalir.gridy = 0;
			pnBotonesGuardado.add(getBtnGuardarYSalir(), gbc_btnGuardarYSalir);
			GridBagConstraints gbc_btnVolverGuardado = new GridBagConstraints();
			gbc_btnVolverGuardado.gridwidth = 2;
			gbc_btnVolverGuardado.fill = GridBagConstraints.BOTH;
			gbc_btnVolverGuardado.insets = new Insets(0, 0, 0, 5);
			gbc_btnVolverGuardado.gridx = 1;
			gbc_btnVolverGuardado.gridy = 1;
			pnBotonesGuardado.add(getBtnVolverGuardado(), gbc_btnVolverGuardado);
		}
		return pnBotonesGuardado;
	}
	private JButton getBtnGuardarYReservar() {
		if (btnGuardarYReservar == null) {
			btnGuardarYReservar = new JButton("New button");
			btnGuardarYReservar.setActionCommand("guardarReservar");
			btnGuardarYReservar.addActionListener(pb);
		}
		return btnGuardarYReservar;
	}
	private JButton getBtnGuardarYSalir() {
		if (btnGuardarYSalir == null) {
			btnGuardarYSalir = new JButton("New button");
			btnGuardarYSalir.setActionCommand("guardarSalir");
			btnGuardarYSalir.addActionListener(pb);
		}
		return btnGuardarYSalir;
	}
	private JButton getBtnVolverGuardado() {
		if (btnVolverGuardado == null) {
			btnVolverGuardado = new JButton("New button");
			btnVolverGuardado.setActionCommand("volverGuardar");
			btnVolverGuardado.addActionListener(pb);
		}
		return btnVolverGuardado;
	}
	private JLabel getLbDescuentoAGuardar() {
		if (lbDescuentoAGuardar == null) {
			lbDescuentoAGuardar = new JLabel("New label");
			lbDescuentoAGuardar.setHorizontalAlignment(SwingConstants.CENTER);
			lbDescuentoAGuardar.setBounds(10, 71, 475, 31);
		}
		return lbDescuentoAGuardar;
	}
	
	void cambiarIdioma() {
		setTextLocation();
	}
	
	private void crearAyuda() {
		URL hsURL;
		   HelpSet hs;

		    try {
			    	File fichero = new File("help/ayuda.hs");
			    	hsURL = fichero.toURI().toURL();
			        hs = new HelpSet(null, hsURL);
			      }

		    catch (Exception e){
		      System.out.println("Ayuda no encontrada");
		      return;
		   }

		   HelpBroker hb = hs.createHelpBroker();
		   hb.initPresentation();

		   hb.enableHelpKey(getRootPane(),"juego", hs);//habilita la tecla f1

	}
}
