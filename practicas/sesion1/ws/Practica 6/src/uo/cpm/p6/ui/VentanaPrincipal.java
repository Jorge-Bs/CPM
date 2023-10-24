package uo.cpm.p6.ui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import uo.cpm.p6.service.SpaceInvaders;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnDado;
	private JPanel pnDisparos;
	private JPanel pnTablero;
	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private JButton bt4;
	private JButton bt5;
	private JButton bt6;
	private JButton b7;
	private JButton b8;
	private SpaceInvaders sp;
	private JTextField txtPuntos;
	private JLabel lbPuntos;
	private JLabel lbImgEarth;
	private JLabel lbImgShip;
	private JMenuBar menuBar;
	private JMenu meGame;
	private JMenu nMenuAyuda;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JSeparator separator;
	private JMenuItem nMenuContenidos;
	private JMenuItem nmtAcercaDE;
	private JSeparator separator_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(SpaceInvaders sp) {
		this.sp=sp;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/spaceship.png")));
		setResizable(false);
		setTitle("Invasion Espacial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 473);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnDado());
		contentPane.add(getPnDisparos());
		contentPane.add(getPnTablero());
		contentPane.add(getTxtPuntos());
		contentPane.add(getLbPuntos());
		contentPane.add(getLbImgEarth());
		contentPane.add(getLbImgShip());
		setLocationRelativeTo(null);
	}
	private JButton getBtnDado() {
		if (btnDado == null) {
			btnDado = new JButton("");
			btnDado.setBackground(new Color(0, 0, 0));
			btnDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					iniciarSpaceInvaders();
				}
			});
			btnDado.setToolTipText("Haz click para obtener disparos");
			btnDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dice.jpg")));
			btnDado.setBounds(55, 27, 114, 113);
		}
		return btnDado;
	}
	private JPanel getPnDisparos() {
		if (pnDisparos == null) {
			pnDisparos = new JPanel();
			pnDisparos.setBackground(new Color(0, 0, 0));
			pnDisparos.setForeground(new Color(0, 0, 0));
			pnDisparos.setBounds(35, 199, 851, 84);
		}
		return pnDisparos;
	}
	private JPanel getPnTablero() {
		if (pnTablero == null) {
			pnTablero = new JPanel();
			pnTablero.setBorder(new LineBorder(new Color(0, 0, 255), 2));
			pnTablero.setBackground(new Color(0, 0, 255));
			pnTablero.setForeground(new Color(0, 0, 255));
			pnTablero.setBounds(35, 322, 851, 84);
			pnTablero.setLayout(new GridLayout(0, 8, 4, 0));
			pnTablero.add(getBt1());
			pnTablero.add(getBt2());
			pnTablero.add(getBt3());
			pnTablero.add(getBt4());
			pnTablero.add(getBt5());
			pnTablero.add(getBt6());
			pnTablero.add(getB7());
			pnTablero.add(getB8());
			habilitaTablero(false);
		}
		return pnTablero;
	}
	private JButton getBt1() {
		if (bt1 == null) {
			bt1 = new JButton("");
			bt1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(0);
				}
			});
		}
		return bt1;
	}
	private JButton getBt2() {
		if (bt2 == null) {
			bt2 = new JButton("");
			bt2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(1);
				}
			});
		}
		return bt2;
	}
	private JButton getBt3() {
		if (bt3 == null) {
			bt3 = new JButton("");
			bt3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(2);
				}
			});
		}
		return bt3;
	}
	private JButton getBt4() {
		if (bt4 == null) {
			bt4 = new JButton("");
			bt4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(3);
				}
			});
		}
		return bt4;
	}
	private JButton getBt5() {
		if (bt5 == null) {
			bt5 = new JButton("");
			bt5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(4);
				}
			});
		}
		return bt5;
	}
	private JButton getBt6() {
		if (bt6 == null) {
			bt6 = new JButton("");
			bt6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(5);
				}
			});
		}
		return bt6;
	}
	private JButton getB7() {
		if (b7 == null) {
			b7 = new JButton("");
			b7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(6);
				}
			});
		}
		return b7;
	}
	private JButton getB8() {
		if (b8 == null) {
			b8 = new JButton("");
			b8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(7);
				}
			});
		}
		return b8;
	}
	
	private JTextField getTxtPuntos() {
		if (txtPuntos == null) {
			txtPuntos = new JTextField();
			txtPuntos.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtPuntos.setEditable(false);
			txtPuntos.setForeground(new Color(0, 255, 0));
			txtPuntos.setBackground(new Color(0, 0, 0));
			txtPuntos.setBounds(537, 96, 110, 37);
			txtPuntos.setColumns(10);
			getPoints();
		}
		return txtPuntos;
	}
	
	
	
	private JLabel nuevoDisparo() {
		JLabel lbDisparo = new JLabel("");
		lbDisparo.setBorder(new LineBorder(Color.GREEN, 1));
		lbDisparo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/shoot.png")));
		return lbDisparo;
	}
	
	
	private JLabel getLbPuntos() {
		if (lbPuntos == null) {
			lbPuntos = new JLabel("Puntos");
			lbPuntos.setFont(new Font("Unispace", Font.PLAIN, 20));
			lbPuntos.setBackground(new Color(0, 0, 0));
			lbPuntos.setBounds(527, 27, 166, 58);
		}
		return lbPuntos;
	}
	private JLabel getLbImgEarth() {
		if (lbImgEarth == null) {
			lbImgEarth = new JLabel("");
			lbImgEarth.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/earth.jpg")));
			lbImgEarth.setBounds(703, 26, 193, 175);
		}
		return lbImgEarth;
	}
	private JLabel getLbImgShip() {
		if (lbImgShip == null) {
			lbImgShip = new JLabel("");
			lbImgShip.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/spaceship.png")));
			lbImgShip.setBounds(265, 27, 137, 97);
		}
		return lbImgShip;
	}
	
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMeGame());
			menuBar.add(getNMenuAyuda());
		}
		return menuBar;
	}
	private JMenu getMeGame() {
		if (meGame == null) {
			meGame = new JMenu("Juego");
			meGame.setMnemonic('j');
			meGame.add(getMntmNewMenuItem());
			meGame.add(getSeparator());
			meGame.add(getMntmNewMenuItem_1());
		}
		return meGame;
	}
	private JMenu getNMenuAyuda() {
		if (nMenuAyuda == null) {
			nMenuAyuda = new JMenu("Ayuda");
			nMenuAyuda.setMnemonic('a');
			nMenuAyuda.add(getNMenuContenidos());
			nMenuAyuda.add(getSeparator_1());
			nMenuAyuda.add(getNmtAcercaDE());
		}
		return nMenuAyuda;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("Nueva Partida");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					iniciarNuevaPartida();
				}
			});
			mntmNewMenuItem.setMnemonic('p');
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("Salir");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			mntmNewMenuItem_1.setMnemonic('s');
		}
		return mntmNewMenuItem_1;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getNMenuContenidos() {
		if (nMenuContenidos == null) {
			nMenuContenidos = new JMenuItem("Contenidos");
			nMenuContenidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Ayuda no disponible", "Contenidos de la Ayuda",
							JOptionPane.INFORMATION_MESSAGE);
				}
			});
			nMenuContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
			nMenuContenidos.setMnemonic('c');
		}
		return nMenuContenidos;
	}
	private JMenuItem getNmtAcercaDE() {
		if (nmtAcercaDE == null) {
			nmtAcercaDE = new JMenuItem("Acerca de");
			nmtAcercaDE.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							"Version del Juego Space Ninvaders \n Realizada por Jorge Blanco Sanchez\n Prácticas CPM 22-23 \n EII Oviedo",
							"Acerca de", JOptionPane.INFORMATION_MESSAGE);
					}
			});
			nmtAcercaDE.setMnemonic('e');
		}
		return nmtAcercaDE;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	
//-----------------------------------------------------------------------------------------------------	
	
	private void habilitaTablero(boolean estado) {
		for (int i=0; i<getPnTablero().getComponents().length;i++)
			getPnTablero().getComponents()[i].setEnabled(estado);
	}
	
	private void iniciarSpaceInvaders() {
		sp.lanzarDado();
		mostrarDisparos();
		habilitaTablero(true);
		getBtnDado().setEnabled(false);
	}
	
	private void mostrarDisparos() {
		for(int i=0;i <sp.getDisparos();i++) {
			getPnDisparos().add(nuevoDisparo());
		}
		validate(); //repinta la ventana despues de añadir componente
	}
	
	private void dispara(int value) {
		sp.dipara(value);
		limpiarDisparos();
		getPoints();
		desabilitaBoton(value);
		compruebaFin();
	}
	
	private void limpiarDisparos() {
		//getPnDisparos().getComponent(0).setVisible(false);
		getPnDisparos().remove(0);
		getPnDisparos().repaint();
	}
	
	private void getPoints() {
		getTxtPuntos().setText(sp.getPuntuacion()+"");
	}
	
	private void compruebaFin() {
		if (sp.isPartidaFinalizada()) {
			habilitaTablero(false);
			limpiarCasillas();
			JOptionPane.showMessageDialog(null, "Partida finalizada", "Invasión espacial",
					JOptionPane.INFORMATION_MESSAGE);
			iniciarNuevaPartida();
		}
	}
	
	private void desabilitaBoton(int value) {
			ImageIcon imagen = new ImageIcon(VentanaPrincipal.class.getResource(sp.obtenerImagen(value)));
			((JButton) getPnTablero().getComponent(value)).setIcon(imagen);
			((JButton) getPnTablero().getComponent(value)).setDisabledIcon(imagen);
			((JButton) getPnTablero().getComponent(value)).setEnabled(false);
		}
	private void limpiarCasillas() {
		JPanel pnael= getPnTablero();
		for(int i=0;i<pnael.getComponents().length;i++) {
			desabilitaBoton(i);
		}
	}
	
	private void iniciarNuevaPartida() {
		getBtnDado().setEnabled(true);
		int value = sp.getDisparos();
		for(int i=0;i<value;i++) limpiarDisparos();
		sp.inicializar();
		habilitaTablero(false);
		getTxtPuntos().setText(sp.getPuntuacion()+"");
		setOriginalColor();
	}
	
	private void setOriginalColor() {
		for(int i=0;i<getPnTablero().getComponents().length;i++) {
			((JButton)getPnTablero().getComponent(i)).setIcon(null);
		}
	}
	
}
