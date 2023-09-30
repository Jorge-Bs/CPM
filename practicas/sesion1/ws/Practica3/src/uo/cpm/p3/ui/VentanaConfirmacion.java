package uo.cpm.p3.ui;

import javax.swing.JDialog;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import uo.cpm.p3.service.McDonalds;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaConfirmacion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbConfirmacion;
	private JTextField txCode;
	private JLabel lbCode;
	private JButton btConfirmar;
	private McDonalds mac;
	private JLabel lbTotal;
	private JTextField textField;


	/**
	 * Create the dialog.
	 */
	public VentanaConfirmacion(McDonalds mac) {
		setMac(mac);
		getContentPane().setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConfirmacion.class.getResource("/img/logo.png")));
		setTitle("McDonald's: Confirmacion");
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 736, 354);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().add(getLbConfirmacion());
		getContentPane().add(getTxCode());
		getContentPane().add(getLbCode());
		getContentPane().add(getBtConfirmar());
		getContentPane().add(getLbTotal());
		getContentPane().add(getTextField());
		setResizable(false);

	}

	/**
	 * @param mac the mac to set
	 */
	private void setMac(McDonalds mac) {
		if(mac==null) throw new IllegalArgumentException("el objeto mac no puede ser null");
		this.mac = mac;
	}

	private JLabel getLbConfirmacion() {
		if (lbConfirmacion == null) {
			lbConfirmacion = new JLabel("Pulsa Finalizar para confirmar su pedido");
			lbConfirmacion.setIcon(new ImageIcon(VentanaConfirmacion.class.getResource("/img/ok.png")));
			lbConfirmacion.setFont(new Font("Arial Black", Font.BOLD, 20));
			lbConfirmacion.setBounds(77, 37, 559, 118);
		}
		return lbConfirmacion;
	}
	private JTextField getTxCode() {
		if (txCode == null) {
			txCode = new JTextField();
			txCode.setEditable(false);
			txCode.setBounds(379, 148, 186, 26);
			txCode.setColumns(10);
			txCode.setText(mac.getCodigoPedido());
		}
		return txCode;
	}
	private JLabel getLbCode() {
		if (lbCode == null) {
			lbCode = new JLabel("El código de recogida es:");
			lbCode.setBounds(176, 140, 161, 49);
		}
		return lbCode;
	}
	private JButton getBtConfirmar() {
		if (btConfirmar == null) {
			btConfirmar = new JButton("Finalizar");
			btConfirmar.setMnemonic('F');
			btConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mac.grabarPedido();
					System.exit(0);
				}
			});
			btConfirmar.setBackground(new Color(0, 255, 0));
			btConfirmar.setBounds(532, 249, 161, 43);
		}
		return btConfirmar;
	}
	private JLabel getLbTotal() {
		if (lbTotal == null) {
			lbTotal = new JLabel("Total:");
			lbTotal.setBounds(176, 200, 131, 33);
		}
		return lbTotal;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(379, 200, 186, 26);
			textField.setColumns(10);
			textField.setText(mac.getTotalPedido()+"€");
		}
		return textField;
	}
}
