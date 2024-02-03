package castleBooker;

import java.awt.EventQueue;

import javax.swing.UIManager;

import castleBooker.sevice.App;
import castleBooker.ui.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		App app = new App();
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
					VentanaPrincipal frame = new VentanaPrincipal(app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
