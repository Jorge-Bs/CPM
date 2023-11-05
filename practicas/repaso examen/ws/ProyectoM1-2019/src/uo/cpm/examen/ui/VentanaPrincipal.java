package uo.cpm.examen.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uo.cpm.examen.service.App;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btRuleta;
	private JLabel lbPuntos;
	private JTextField txtPuntos;
	private JButton btPremio;
	 App ap;
	 private JMenuBar menuBar;
	 private JMenu mJuego;
	 private JMenu mAyuda;
	 private JMenuItem mNuevo;
	 private JMenuItem mSalir;
	 private JSeparator separator;
	 private JMenuItem mAcerca;
	 private ProcesaFinalizar ps = new ProcesaFinalizar();
	
	public VentanaPrincipal(App ap) {
		this.ap = ap;
		setResizable(false);
		setTitle("Ruleta de la Suerte");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/ruleta.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 395);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBar_1());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtRuleta());
		contentPane.add(getLbPuntos());
		contentPane.add(getTxtPuntos());
		contentPane.add(getBtPremio());
	}
	private JButton getBtRuleta() {
		if (btRuleta == null) {
			btRuleta = new JButton("");
			btRuleta.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/ruleta.png")));
			btRuleta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btRuleta.setEnabled(false);
					ap.lanzar();
					setPoints();
					getBtPremio().setEnabled(true);
				}
			});
			btRuleta.setToolTipText("Haz clic para que gire la ruleta");
			btRuleta.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/ruleta.png")));
			btRuleta.setBounds(10, 27, 223, 224);
		}
		return btRuleta;
	}
	
	private void setPoints() {
		getTxtPuntos().setText(ap.getPoitns()+"");
	}
	private JLabel getLbPuntos() {
		if (lbPuntos == null) {
			lbPuntos = new JLabel("Tus puntos:");
			lbPuntos.setBounds(307, 40, 164, 39);
		}
		return lbPuntos;
	}
	private JTextField getTxtPuntos() {
		if (txtPuntos == null) {
			txtPuntos = new JTextField();
			txtPuntos.setBackground(new Color(255, 255, 255));
			txtPuntos.setEditable(false);
			txtPuntos.setBounds(311, 90, 96, 20);
			txtPuntos.setColumns(10);
		}
		return txtPuntos;
	}
	private JButton getBtPremio() {
		if (btPremio == null) {
			btPremio = new JButton("Canjea tu premio");
			btPremio.setMnemonic('c');
			btPremio.setEnabled(false);
			btPremio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaPremios vp = new VentanaPremios(ventana());
					vp.setVisible(true);
				}
			});
			btPremio.setBackground(new Color(0, 255, 0));
			btPremio.setBounds(259, 293, 148, 29);
		}
		return btPremio;
	}
	
	private VentanaPrincipal ventana() {
		return this;
	}
	
	public void disa() {
		getBtPremio().setEnabled(false);
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMJuego());
			menuBar.add(getMAyuda());
		}
		return menuBar;
	}
	private JMenu getMJuego() {
		if (mJuego == null) {
			mJuego = new JMenu("Juego");
			mJuego.setMnemonic('j');
			mJuego.add(getMNuevo());
			mJuego.add(getSeparator());
			mJuego.add(getMSalir());
		}
		return mJuego;
	}
	private JMenu getMAyuda() {
		if (mAyuda == null) {
			mAyuda = new JMenu("Ayuda");
			mAyuda.setMnemonic('a');
			mAyuda.add(getMAcerca());
		}
		return mAyuda;
	}
	private JMenuItem getMNuevo() {
		if (mNuevo == null) {
			mNuevo = new JMenuItem("Nuevo");
			mNuevo.setMnemonic('n');
			mNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			mNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
		}
		return mNuevo;
	}
	private JMenuItem getMSalir() {
		if (mSalir == null) {
			mSalir = new JMenuItem("Salir");
			mSalir.setMnemonic('s');
			mSalir.addActionListener(ps);
		}
		return mSalir;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMAcerca() {
		if (mAcerca == null) {
			mAcerca = new JMenuItem("Acerca de");
			mAcerca.setMnemonic('c');
			mAcerca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,"Practica de Examan Realizada por:\n"
							+ "Jorge Blanco Sánchez", "Acerca de", 1);
				}
			});
		}
		return mAcerca;
	}
	
	private class ProcesaFinalizar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
		
	}
	
	private void inicializar() {
		getTxtPuntos().setText("0");
		getBtPremio().setEnabled(false);
		getBtRuleta().setEnabled(true);
		ap.inicializar();
		
	}
}
