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
import java.awt.Color;
import javax.swing.JSlider;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel NorthPanel;
	private JPanel CenterPanel;
	private JLabel lbLogo;
	private JSlider slVolumen;
	private JLabel lbVolumen;
	private JLabel lbtxVolumen;
	private JPanel pnVolumen;
	private JPanel pnLibrary;
	private JPanel pnPlay;
	private JLabel lbLibrary;
	private JScrollPane scrListLibrary;
	private JList listLibrary;
	private JPanel pnBtLibrary;
	private JButton btAdd;
	private JButton btDelete;
	private JLabel lbPlayList;
	private JScrollPane scrPlayList;
	private JList listPlayList;
	private JPanel pnPlayList;
	private JButton btRew;
	private JButton btDel;
	private JButton btPlay;
	private JButton btStop;
	private JButton btForward;
	private JMenuBar menuBar;
	private JMenu mFile;
	private JMenu mPlay;
	private JMenu mOptions;
	private JMenu mHelp;
	private JMenuItem mmOpen;
	private JMenuItem mmSalir;
	private JSeparator separator;
	private JMenuItem mmNExt;
	private JMenuItem mmRandom;
	private JMenuItem mmContents;
	private JMenuItem mmAbout;
	private JSeparator separator_1;

	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logoTitulo.png")));
		setTitle("EII Music Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 729);
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getNorthPanel(), BorderLayout.NORTH);
		contentPane.add(getCenterPanel());
	}
	private JPanel getNorthPanel() {
		if (NorthPanel == null) {
			NorthPanel = new JPanel();
			NorthPanel.setBackground(new Color(0, 0, 0));
			NorthPanel.setLayout(new GridLayout(1, 4, 0, 0));
			NorthPanel.add(getLbLogo());
			NorthPanel.add(getSlVolumen());
			NorthPanel.add(getPnVolumen());
		}
		return NorthPanel;
	}
	private JPanel getCenterPanel() {
		if (CenterPanel == null) {
			CenterPanel = new JPanel();
			CenterPanel.setBackground(new Color(0, 0, 0));
			CenterPanel.setLayout(new GridLayout(1, 2, 6, 0));
			CenterPanel.add(getPnLibrary());
			CenterPanel.add(getPnPlay());
		}
		return CenterPanel;
	}
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
		}
		return lbLogo;
	}
	private JSlider getSlVolumen() {//propiedades del slider
		if (slVolumen == null) {
			slVolumen = new JSlider();
			slVolumen.setFocusable(false);//quita el borde del componente al tener el foco
			slVolumen.setForeground(Color.WHITE);
			slVolumen.setBackground(new Color(0, 0, 0));
			slVolumen.setMinimum(0);
			slVolumen.setMaximum(100);
			slVolumen.setValue(50);
			slVolumen.setMajorTickSpacing(20);
			slVolumen.setMinorTickSpacing(5);
			slVolumen.setPaintLabels(true);
			slVolumen.setPaintTicks(true);
		}
		return slVolumen;
	}
	private JLabel getLbVolumen() {
		if (lbVolumen == null) {
			lbVolumen = new JLabel("Vol:");
			lbVolumen.setHorizontalAlignment(SwingConstants.RIGHT);
			lbVolumen.setFont(new Font("Dialog", Font.BOLD, 32));
			lbVolumen.setForeground(Color.ORANGE);
			lbVolumen.setBackground(Color.BLACK);
		}
		return lbVolumen;
	}
	private JLabel getLbtxVolumen() {
		if (lbtxVolumen == null) {
			lbtxVolumen = new JLabel("50");
			lbtxVolumen.setHorizontalAlignment(SwingConstants.LEFT);
			lbtxVolumen.setFont(new Font("Dialog", Font.BOLD, 40));
			lbtxVolumen.setForeground(Color.WHITE);
			lbtxVolumen.setBackground(Color.BLACK);
		}
		return lbtxVolumen;
	}
	private JPanel getPnVolumen() {
		if (pnVolumen == null) {
			pnVolumen = new JPanel();
			pnVolumen.setBackground(Color.BLACK);
			pnVolumen.add(getLbVolumen());
			pnVolumen.add(getLbtxVolumen());
		}
		return pnVolumen;
	}
	private JPanel getPnLibrary() {
		if (pnLibrary == null) {
			pnLibrary = new JPanel();
			pnLibrary.setBackground(Color.BLACK);
			pnLibrary.setLayout(new BorderLayout(0, 0));
			pnLibrary.add(getLbLibrary(), BorderLayout.NORTH);
			pnLibrary.add(getScrListLibrary());
			pnLibrary.add(getPnBtLibrary(), BorderLayout.SOUTH);
		}
		return pnLibrary;
	}
	private JPanel getPnPlay() {
		if (pnPlay == null) {
			pnPlay = new JPanel();
			pnPlay.setBackground(Color.BLACK);
			pnPlay.setLayout(new BorderLayout(0, 0));
			pnPlay.add(getLbPlayList(), BorderLayout.NORTH);
			pnPlay.add(getScrPlayList(), BorderLayout.CENTER);
			pnPlay.add(getPnPlayList(), BorderLayout.SOUTH);
		}
		return pnPlay;
	}
	private JLabel getLbLibrary() {
		if (lbLibrary == null) {
			lbLibrary = new JLabel();
			lbLibrary.setDisplayedMnemonic('l');
			lbLibrary.setLabelFor(getListLibrary());
			lbLibrary.setForeground(Color.ORANGE);
			lbLibrary.setFont(new Font("Dialog", Font.BOLD, 18));
			lbLibrary.setText("\u266a"+"Library:");
		}
		return lbLibrary;
	}
	private JScrollPane getScrListLibrary() {
		if (scrListLibrary == null) {
			scrListLibrary = new JScrollPane();
			scrListLibrary.setBorder(new LineBorder(Color.ORANGE, 3));
			scrListLibrary.setViewportView(getListLibrary());
		}
		return scrListLibrary;
	}
	private JList getListLibrary() {
		if (listLibrary == null) {
			listLibrary = new JList();
			listLibrary.setBackground(Color.BLACK);
			listLibrary.setForeground(Color.ORANGE);
		}
		return listLibrary;
	}
	private JPanel getPnBtLibrary() {
		if (pnBtLibrary == null) {
			pnBtLibrary = new JPanel();
			pnBtLibrary.setBackground(Color.BLACK);
			pnBtLibrary.setLayout(new GridLayout(1, 2, 0, 0));
			pnBtLibrary.add(getBtAdd());
			pnBtLibrary.add(getBtDelete());
		}
		return pnBtLibrary;
	}
	private JButton getBtAdd() {
		if (btAdd == null) {
			btAdd = new JButton("Add to PlayList");
			btAdd.setEnabled(false);
			btAdd.setMnemonic('A');
			btAdd.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btAdd;
	}
	private JButton getBtDelete() {
		if (btDelete == null) {
			btDelete = new JButton("Delete");
			btDelete.setEnabled(false);
			btDelete.setMnemonic('D');
			btDelete.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btDelete;
	}
	private JLabel getLbPlayList() {
		if (lbPlayList == null) {
			lbPlayList = new JLabel();
			lbPlayList.setLabelFor(getListLibrary());
			lbPlayList.setDisplayedMnemonic('P');
			lbPlayList.setBackground(Color.BLACK);
			lbPlayList.setText("♪PlayList:");
			lbPlayList.setForeground(Color.ORANGE);
			lbPlayList.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return lbPlayList;
	}
	private JScrollPane getScrPlayList() {
		if (scrPlayList == null) {
			scrPlayList = new JScrollPane();
			scrPlayList.setBorder(new LineBorder(Color.ORANGE, 3));
			scrPlayList.setViewportView(getListPlayList());
		}
		return scrPlayList;
	}
	private JList getListPlayList() {
		if (listPlayList == null) {
			listPlayList = new JList();
			listPlayList.setForeground(Color.ORANGE);
			listPlayList.setBackground(Color.BLACK);
		}
		return listPlayList;
	}
	private JPanel getPnPlayList() {
		if (pnPlayList == null) {
			pnPlayList = new JPanel();
			pnPlayList.setBackground(Color.BLACK);
			pnPlayList.setLayout(new GridLayout(1, 5, 0, 0));
			pnPlayList.add(getBtRew());
			pnPlayList.add(getBtPlay());
			pnPlayList.add(getBtStop());
			pnPlayList.add(getBtForward());
			pnPlayList.add(getBtDel());
		}
		return pnPlayList;
	}
	private JButton getBtRew() {
		if (btRew == null) {
			btRew = new JButton("◄◄");
			btRew.setEnabled(false);
			btRew.setToolTipText("Rewing");
			btRew.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btRew;
	}
	private JButton getBtDel() {
		if (btDel == null) {
			btDel = new JButton("Del");
			btDel.setEnabled(false);
			btDel.setMnemonic('e');
			btDel.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btDel;
	}
	private JButton getBtPlay() {
		if (btPlay == null) {
			btPlay = new JButton("►");
			btPlay.setEnabled(false);
			btPlay.setToolTipText("Play");
			btPlay.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btPlay;
	}
	private JButton getBtStop() {
		if (btStop == null) {
			btStop = new JButton("■");
			btStop.setEnabled(false);
			btStop.setToolTipText("Stop");
			btStop.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btStop;
	}
	private JButton getBtForward() {
		if (btForward == null) {
			btForward = new JButton("►►");
			btForward.setEnabled(false);
			btForward.setToolTipText("Forward");
			btForward.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btForward;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMFile());
			menuBar.add(getMPlay());
			menuBar.add(getMOptions());
			menuBar.add(getMHelp());
		}
		return menuBar;
	}
	private JMenu getMFile() {
		if (mFile == null) {
			mFile = new JMenu("File");
			mFile.setMnemonic('f');
			mFile.add(getMmOpen());
			mFile.add(getSeparator());
			mFile.add(getMmSalir());
		}
		return mFile;
	}
	private JMenu getMPlay() {
		if (mPlay == null) {
			mPlay = new JMenu("Play");
			mPlay.setMnemonic('p');
			mPlay.add(getMmNExt());
		}
		return mPlay;
	}
	private JMenu getMOptions() {
		if (mOptions == null) {
			mOptions = new JMenu("Options");
			mOptions.setMnemonic('o');
			mOptions.add(getMmRandom());
		}
		return mOptions;
	}
	private JMenu getMHelp() {
		if (mHelp == null) {
			mHelp = new JMenu("Help");
			mHelp.setMnemonic('h');
			mHelp.add(getMmContents());
			mHelp.add(getSeparator_1());
			mHelp.add(getMmAbout());
		}
		return mHelp;
	}
	private JMenuItem getMmOpen() {
		if (mmOpen == null) {
			mmOpen = new JMenuItem("Open");
			mmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
			mmOpen.setMnemonic('o');
		}
		return mmOpen;
	}
	private JMenuItem getMmSalir() {
		if (mmSalir == null) {
			mmSalir = new JMenuItem("Exit");
			mmSalir.setMnemonic('x');
		}
		return mmSalir;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMmNExt() {
		if (mmNExt == null) {
			mmNExt = new JMenuItem("Next");
			mmNExt.setEnabled(false);
			mmNExt.setMnemonic('n');
		}
		return mmNExt;
	}
	private JMenuItem getMmRandom() {
		if (mmRandom == null) {
			mmRandom = new JMenuItem("Random");
			mmRandom.setEnabled(false);
			mmRandom.setMnemonic('r');
		}
		return mmRandom;
	}
	private JMenuItem getMmContents() {
		if (mmContents == null) {
			mmContents = new JMenuItem("Contents");
			mmContents.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
			mmContents.setMnemonic('c');
		}
		return mmContents;
	}
	private JMenuItem getMmAbout() {
		if (mmAbout == null) {
			mmAbout = new JMenuItem("About");
			mmAbout.setMnemonic('b');
		}
		return mmAbout;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
}
