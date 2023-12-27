package castleBooker.ui.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

public class JScrollPanelWithPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<JPanel> paneles=new ArrayList<>();
	private ruedaRatonDesplazada scM = new ruedaRatonDesplazada();
	private int amountOfPanels;
	private JPanel panelContenedor;
	private JScrollBar scrollBar;
	private int amountOfVisiblePanels;
	
	public JScrollPanelWithPanel(int amountOfPanels,int amountOfVisiblePanels) {
		super();
		this.setLayout(new BorderLayout());
		
		panelContenedor= new JPanel();
		panelContenedor.addMouseWheelListener(scM);
		setAmountOfVisiblePanels(amountOfVisiblePanels);
		
		getScrollBar();
		addPanels(amountOfPanels);
		
		
		showPanel(0);
		this.add(panelContenedor,BorderLayout.CENTER);
		this.add(scrollBar,BorderLayout.EAST);
	}

	public void setAmountOfVisiblePanels(int amountOfVisiblePanels) {
		panelContenedor.setLayout(new GridLayout(amountOfVisiblePanels, 0));
		this.amountOfVisiblePanels=amountOfVisiblePanels;
	}

	private void addPanels(int amountOfPanels) {
		for(int i=0;i<amountOfPanels;i++) {
			JPanel panel=new JPanel();
			panel.setBorder(new LineBorder(Color.BLACK));
			paneles.add(panel);
		}
		this.amountOfPanels=paneles.size();
		scrollBar.setMaximum(((amountOfPanels)*2)-(amountOfPanels/amountOfVisiblePanels));
	}
	
	private JScrollBar getScrollBar() {
		if(scrollBar==null) {
			scrollBar= new JScrollBar();
			scrollBar.addMouseWheelListener(scM);
			scrollBar.addAdjustmentListener(new AdjustmentListener() {
				public void adjustmentValueChanged(AdjustmentEvent e) {
					//System.out.println(e.getValue());
					showPanel(e.getValue());
				}
			});
		}return scrollBar;
	}
	
	private void showPanel(int value) {
		panelContenedor.removeAll();
		if(value>=(amountOfPanels-amountOfVisiblePanels)) {
			value=amountOfPanels-amountOfVisiblePanels;
		}
		for(int i=0;i<amountOfVisiblePanels;i++) {
			panelContenedor.add(paneles.get(i+value));
			panelContenedor.repaint();
			panelContenedor.validate();
		}
		panelContenedor.repaint();
		panelContenedor.validate();
	}
	
	public JPanel getPanel(int index) {
		return paneles.get(index);
	}
	
	private class ruedaRatonDesplazada extends MouseAdapter {
		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			
			int value = (int) e.getPreciseWheelRotation();
			getScrollBar().setValue(getScrollBar().getValue()+value);
		}
	}
	
	public int getScrollPosition() {
		return getScrollBar().getValue();
	}
	
	public int amountOfPanels() {
		return paneles.size();
	}
	
	@Override
	public void addMouseListener(MouseListener l) {
		for(JPanel panel:paneles) {
			panel.addMouseListener(l);
		}
		
	}

}
