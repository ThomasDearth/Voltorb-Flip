package ui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestGUI extends Frame {
	private static final long serialVersionUID = 6574051626320712093L;
	private static final int TITLE_HEIGHT = 31;

	public static void main(String[] args) {
		new TestGUI();
	}
	
	public TestGUI() {
		this.setTitle("Voltorb Flip");
		this.setSize(1154, 863 + TITLE_HEIGHT);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});
		
//		Panel panel = new Panel();
//		panel.setBackground(new Color(0,128,255));
//		frame.add(panel);
		
		ImageComponent background = new ImageComponent("resources/Board0.PNG");
		background.setBackground(new Color(0, 255, 128));
		this.add(background);
		
		this.setVisible(true);
	}
}
