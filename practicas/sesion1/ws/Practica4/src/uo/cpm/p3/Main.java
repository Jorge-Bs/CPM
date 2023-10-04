package uo.cpm.p3;

import java.awt.EventQueue;

import javax.swing.UIManager;

import uo.cpm.p3.service.McDonalds;
import uo.cpm.p3.ui.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		McDonalds mac = new McDonalds();
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					VentanaPrincipal frame = new VentanaPrincipal(mac);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
