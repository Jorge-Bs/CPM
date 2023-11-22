package uo.cpm.p8.ui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSlider;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import uo.cpm.p8.player.MusicPlayer;
import uo.cpm.p8.player.MyFile;

import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.ChangeEvent;

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
	private JList<MyFile> listLibrary;
	private JPanel pnBtLibrary;
	private JButton btAdd;
	private JButton btDelete;
	private JLabel lbPlayList;
	private JScrollPane scrPlayList;
	private JList<MyFile> listPlayList;
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
	
	private DefaultListModel<MyFile> modelLibrary;
	private DefaultListModel<MyFile> modelPlayList;
	
	private MusicPlayer mp;

	private JFileChooser chooser;
	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(MusicPlayer mp) {
		this.mp =mp;
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
	
	private JFileChooser getChooserPane() {
		if(chooser==null) {
			chooser = new JFileChooser();
			//permitir varios archivos
			chooser.setMultiSelectionEnabled(true);
			
			//Fijar el directorio de despliege del JFileChooser
			String path = System.getProperty("user.home")+"/music"; //user.dir<-directorio actual, escritorio user.home
			//establecer un filtro para la extensiones mp3
			chooser.setFileFilter(new FileNameExtensionFilter("Archvios mp3", "mp3"));
			chooser.setCurrentDirectory(new File(path));
		}
		return chooser;
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
			slVolumen.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					modificarVolumen();
				}
			});
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
	
	
	private void modificarVolumen() {
		int value = getSlVolumen().getValue();
		int maxValue= getSlVolumen().getMaximum();
		mp.setVolume(value, maxValue);
		getLbtxVolumen().setText(String.valueOf(value));
	}
	private JLabel getLbVolumen() {
		if (lbVolumen == null) {
			lbVolumen = new JLabel("Vol:");
			lbVolumen.setHorizontalAlignment(SwingConstants.RIGHT);
			lbVolumen.setFont(new Font("Dialog", Font.BOLD, 32));
			lbVolumen.setForeground(new Color(255, 128, 0));
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
			lbLibrary.setForeground(new Color(255, 128, 0));
			lbLibrary.setFont(new Font("Dialog", Font.BOLD, 18));
			lbLibrary.setText("\u266a"+"Library:");
		}
		return lbLibrary;
	}
	private JScrollPane getScrListLibrary() {
		if (scrListLibrary == null) {
			scrListLibrary = new JScrollPane();
			scrListLibrary.setBorder(new LineBorder(new Color(255, 128, 0), 3));
			scrListLibrary.setViewportView(getListLibrary());
		}
		return scrListLibrary;
	}
	private JList<MyFile> getListLibrary() {
		if (listLibrary == null) {
			modelLibrary = new DefaultListModel<MyFile>();
			listLibrary = new JList<MyFile>(modelLibrary);
			listLibrary.setBackground(Color.BLACK);
			listLibrary.setForeground(new Color(255, 128, 0));
			
			//listLibrary.setModel(modelLibrary);
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
			btAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarArchivos();
					enableButtons(true);
					getMmRandom().setEnabled(true);
				}
			});
			btAdd.setMnemonic('A');
			btAdd.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btAdd;
	}
	
	private void cambiarArchivos() {
		List<MyFile> lista = getListLibrary().getSelectedValuesList();
//		for(File element:lista) {
//			modelPlayList.addElement(element);
//		}
		modelPlayList.addAll(lista);
	}
	
	private void enableButtons(boolean status) {
		getBtRew().setEnabled(status);
		getBtPlay().setEnabled(status);
		getBtStop().setEnabled(status);
		getBtForward().setEnabled(status);
		getBtDel().setEnabled(status);
	}
	
	
	
	private JButton getBtDelete() {
		if (btDelete == null) {
			btDelete = new JButton("Delete");
			btDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					removeSongs();
					checkSize();
				}
			});
			btDelete.setEnabled(false);
			btDelete.setMnemonic('D');
			btDelete.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btDelete;
	}
	private void removeSongs() {
		List<MyFile> files =getListLibrary().getSelectedValuesList();
		for(MyFile file:files) {
			modelLibrary.removeElement(file);
		}
	}
	
	private void checkSize() {
		if(modelLibrary.isEmpty()) enableMainButtons(false);
	}
	
	private JLabel getLbPlayList() {
		if (lbPlayList == null) {
			lbPlayList = new JLabel();
			lbPlayList.setLabelFor(getListLibrary());
			lbPlayList.setDisplayedMnemonic('P');
			lbPlayList.setBackground(Color.BLACK);
			lbPlayList.setText("♪PlayList:");
			lbPlayList.setForeground(new Color(255, 128, 0));
			lbPlayList.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return lbPlayList;
	}
	private JScrollPane getScrPlayList() {
		if (scrPlayList == null) {
			scrPlayList = new JScrollPane();
			scrPlayList.setBorder(new LineBorder(new Color(255, 128, 0), 3));
			scrPlayList.setViewportView(getListPlayList());
		}
		return scrPlayList;
	}
	private JList<MyFile> getListPlayList() {
		if (listPlayList == null) {
			modelPlayList = new DefaultListModel<MyFile>();
			listPlayList = new JList<MyFile>();
			listPlayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listPlayList.setForeground(new Color(255, 128, 0));
			listPlayList.setBackground(Color.BLACK);
			listPlayList.setModel(modelPlayList);
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
			btRew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rewind();
				}
			});
			btRew.setEnabled(false);
			btRew.setToolTipText("Rewing");
			btRew.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btRew;
	}
	
	private void rewind() {
		int index=getListPlayList().getSelectedIndex()-1;
		if(index<0) index=modelPlayList.size()-1;
		getListPlayList().setSelectedIndex(index);
		play();
	}
	
	
	
	private JButton getBtDel() {
		if (btDel == null) {
			btDel = new JButton("Del");
			btDel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MyFile file = getListPlayList().getSelectedValue();
					modelPlayList.removeElement(file);
					if(modelPlayList.size()==0) {
						enableButtons(false);
						getMmRandom().setEnabled(false);
					}
				}
			});
			btDel.setEnabled(false);
			btDel.setMnemonic('e');
			btDel.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btDel;
	}
	private JButton getBtPlay() {
		if (btPlay == null) {
			btPlay = new JButton("►");
			btPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					play();
				}
			});
			btPlay.setEnabled(false);
			btPlay.setToolTipText("Play");
			btPlay.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btPlay;
	}
	
	private void play() {
		MyFile file = getListPlayList().getSelectedValue();
		if(file==null) {
			getListPlayList().setSelectedIndex(0);
		}
		mp.play(file.getF());
	}
	
	private JButton getBtStop() {
		if (btStop == null) {
			btStop = new JButton("■");
			btStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mp.stop();
				}
			});
			btStop.setEnabled(false);
			btStop.setToolTipText("Stop");
			btStop.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btStop;
	}
	private JButton getBtForward() {
		if (btForward == null) {
			btForward = new JButton("►►");
			btForward.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					forward();
				}
			});
			btForward.setEnabled(false);
			btForward.setToolTipText("Forward");
			btForward.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btForward;
	}
	
	private void forward() {
		int index = getListPlayList().getSelectedIndex()+1;
		if(index>=modelPlayList.getSize()) index=0;
		getListPlayList().setSelectedIndex(index);
		play();
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
			mmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirArchivos();
					enableMainButtons(true);
				}
			});
			mmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
			mmOpen.setMnemonic('o');
		}
		return mmOpen;
	}
	
	private void enableMainButtons(boolean condition ) {
		getBtAdd().setEnabled(condition);
		getBtDelete().setEnabled(condition);
	}
	
	private void abrirArchivos() {
		int respuesta = getChooserPane().showOpenDialog(this);
		if(respuesta==JFileChooser.APPROVE_OPTION) {
			File[] archivos=chooser.getSelectedFiles();
			for(File file:archivos) {
				//String[] letras = file.toString().split("\");
				MyFile myFile = new MyFile(file);
				if(!modelLibrary.contains(myFile)) {
					modelLibrary.addElement(myFile);
				}
			}
		}
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
			mmRandom.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					randomMusic();
				}
			});
			mmRandom.setMnemonic('r');
		}
		return mmRandom;
	}
	
	private void randomMusic() {
		int value = mp.random(modelLibrary.size());
		getListPlayList().setSelectedIndex(value);
		play();
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
