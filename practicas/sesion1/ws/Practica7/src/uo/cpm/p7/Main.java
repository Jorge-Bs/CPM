package uo.cpm.p7;

import java.awt.EventQueue;

import javax.swing.UIManager;

import uo.cpm.p7.service.SpaceInvaders;
import uo.cpm.p7.ui.VentanaPrincipal;

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
