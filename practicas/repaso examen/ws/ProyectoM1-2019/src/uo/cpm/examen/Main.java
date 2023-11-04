package uo.cpm.examen;

import java.awt.EventQueue;

import uo.cpm.examen.service.App;
import uo.cpm.examen.ui.*;

public class Main {

	public static void main(String[] args) {
		App app = new App();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal(app);
					 frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
