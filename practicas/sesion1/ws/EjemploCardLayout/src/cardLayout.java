import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cardLayout extends JFrame {

	private JPanel contentPane;
	private JPanel pnB;
	private JPanel pnR;
	private JPanel pnG;
	private JButton btSiguiente;
	private JButton btSiguiente1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cardLayout frame = new cardLayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public cardLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPnR(), "pnR");
		contentPane.add(getPnG(), "pnG");
		contentPane.add(getPnB(), "pnB");
	}

	private JPanel getPnB() {
		if (pnB == null) {
			pnB = new JPanel();
			pnB.setBackground(new Color(0, 255, 255));
			pnB.add(getBtSiguiente1());
		}
		return pnB;
	}
	private JPanel getPnR() {
		if (pnR == null) {
			pnR = new JPanel();
			pnR.setBackground(new Color(255, 0, 0));
			pnR.add(getBtSiguiente());
		}
		return pnR;
	}
	private JPanel getPnG() {
		if (pnG == null) {
			pnG = new JPanel();
			pnG.setBackground(new Color(0, 255, 0));
		}
		return pnG;
	}
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("siguiente");
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout cl =(CardLayout)getContentPane().getLayout();
					cl.next(getContentPane());//Siguiente panel
				}
			});
			btSiguiente.setMnemonic('s');
		}
		return btSiguiente;
	}
	private JButton getBtSiguiente1() {
		if (btSiguiente1 == null) {
			btSiguiente1 = new JButton("siguiente");
		}
		return btSiguiente1;
	}
}
