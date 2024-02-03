package castleBooker.ui;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JPanel;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;

import javax.swing.SwingConstants;

import castleBooker.sevice.App;

public class VentanaDescuento extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnBotones;
	private JPanel pnDescuento;
	private JButton btnReserva;
	private JButton btnVolver;
	private JLabel lbConsulta;
	private JTextField txDni;
	private App app;
	private ResourceBundle textos;
	private ProcesBotones pb = new ProcesBotones();
	private JLabel lbIndicaDescuento;
	private VentanaPrincipal vp;

	/**
	 * Create the dialog.
	 */
	public VentanaDescuento(App app,VentanaPrincipal vp) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.vp=vp;
		this.app=app;
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaDescuento.class.getResource("/img/icon.png")));
		setBounds(100, 100, 450, 230);
		getContentPane().setLayout(null);
		getContentPane().add(getPnBotones());
		getContentPane().add(getPnDescuento());
		getContentPane().add(getLbIndicaDescuento());
		setLocationRelativeTo(null);
		setTextLocation();
		
		crearAyuda();
	}
	
	private void setTextLocation() {
		textos = ResourceBundle.getBundle("rcs/text",app.getLocation());
		setTitle(textos.getString("tituloDecuento"));
	
		getLbConsulta().setText(textos.getString("consulta"));
		getLbConsulta().setDisplayedMnemonic(textos.getString("mnemonicConsulta").charAt(0));
		
		getBtnReserva().setText(textos.getString("reserva"));
		getBtnReserva().setMnemonic(textos.getString("mnemonicReserva").charAt(0));
		
		getBtnVolver().setText(textos.getString("volver"));
		getBtnVolver().setMnemonic(textos.getString("mnemonicVolver").charAt(0));
	}

	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setBounds(0, 160, 436, 33);
			pnBotones.add(getBtnReserva());
			pnBotones.add(getBtnVolver());
		}
		return pnBotones;
	}
	private JPanel getPnDescuento() {
		if (pnDescuento == null) {
			pnDescuento = new JPanel();
			pnDescuento.setBounds(0, 57, 436, 33);
			pnDescuento.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
			pnDescuento.add(getLbConsulta());
			pnDescuento.add(getTxDni());
		}
		return pnDescuento;
	}
	private JButton getBtnReserva() {
		if (btnReserva == null) {
			btnReserva = new JButton();
			btnReserva.setActionCommand("reservar");
			btnReserva.addActionListener(pb);
		}
		return btnReserva;
	}
	private JButton getBtnVolver() {
		if (btnVolver == null) {
			btnVolver = new JButton();
			btnVolver.setActionCommand("volver");
			btnVolver.addActionListener(pb);
		}
		return btnVolver;
	}
	private JLabel getLbConsulta() {
		if (lbConsulta == null) {
			lbConsulta = new JLabel();
			lbConsulta.setLabelFor(getTxDni());
		}
		return lbConsulta;
	}
	private JTextField getTxDni() {
		if (txDni == null) {
			txDni = new JTextField();
			txDni.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					JTextField tx = (JTextField) e.getSource();
					search(tx.getText());
				}
			});
			txDni.setColumns(10);
		}
		return txDni;
	}
	
	public void inicializar() {
		setTextLocation();
		getTxDni().setText("");
		getLbIndicaDescuento().setText("");
	}
	
	private void search(String key) {
		if(app.hasDiscount(key)) {
			double amount = app.consultDiscount(key);
			getLbIndicaDescuento().setText(textos.getString("tieneDescuento")+amount+"%");
		}else {
			getLbIndicaDescuento().setText(textos.getString("noTieneDescuento"));
		}
	}
	
	private class ProcesBotones implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			switch(action) {
			case "volver":
				app.saveId(getTxDni().getText());
				dispose();
				break;
			case "reservar":
				app.saveId(getTxDni().getText());
				dispose();
				vp.changeReserva();
				break;
			}
		}
		
	}
	private JLabel getLbIndicaDescuento() {
		if (lbIndicaDescuento == null) {
			lbIndicaDescuento = new JLabel("");
			lbIndicaDescuento.setHorizontalAlignment(SwingConstants.CENTER);
			lbIndicaDescuento.setHorizontalTextPosition(SwingConstants.CENTER);
			lbIndicaDescuento.setBounds(10, 101, 416, 33);
		}
		return lbIndicaDescuento;
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

		   hb.enableHelpKey(getRootPane(),"descuento", hs);
	}
}