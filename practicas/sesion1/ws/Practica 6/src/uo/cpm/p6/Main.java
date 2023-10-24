package uo.cpm.p6;

import java.awt.EventQueue;

import javax.swing.UIManager;

import uo.cpm.p6.service.SpaceInvaders;
import uo.cpm.p6.ui.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		SpaceInvaders sp = new SpaceInvaders();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					VentanaPrincipal frame = new VentanaPrincipal(sp);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
