package ui;

import java.awt.*;

public class TestGUI {
	public static void main(String[] args) {
		TestGUI gui = new TestGUI();
		gui.makeWindow();
	}
	
	public void makeWindow() {
		Frame frame = new java.awt.Frame("Voltorb Flip");
		frame.setSize(400, 400);
		
		Panel panel = new java.awt.Panel();
		frame.add(panel);
		
		frame.setVisible(true);
	}
}
