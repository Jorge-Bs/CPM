package uo.cpm.p8.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel NorthPanel;
	private JPanel CenterPanel;
	private JLabel lbLogo;

	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logoTitulo.png")));
		setTitle("EII Music Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getNorthPanel());
		contentPane.add(getCenterPanel());
	}
	private JPanel getNorthPanel() {
		if (NorthPanel == null) {
			NorthPanel = new JPanel();
			NorthPanel.setBounds(5, 5, 426, 81);
			NorthPanel.setLayout(null);
			NorthPanel.add(getLbLogo());
		}
		return NorthPanel;
	}
	private JPanel getCenterPanel() {
		if (CenterPanel == null) {
			CenterPanel = new JPanel();
			CenterPanel.setBounds(5, 139, 426, 119);
			CenterPanel.setLayout(null);
		}
		return CenterPanel;
	}
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
			lbLogo.setBounds(10, 11, 186, 64);
		}
		return lbLogo;
	}
}
