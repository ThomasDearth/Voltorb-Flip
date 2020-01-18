package ui.gui;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

import javax.swing.SpringLayout;

public class GameWindow extends Frame {
	private static final long serialVersionUID = 4732891750003688342L;

	private static final BufferedImage imgBackground = GraphicsUtil.makeImage("resources/background/boardBackground.png");

	private static SpringLayout layout;
	
	public GameWindow() {
		this.setSize(imgBackground.getWidth(), imgBackground.getHeight());
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
		layout = new SpringLayout();
		this.setLayout(layout);

		addComponents();
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(imgBackground, 10, 30, null);
	}

	public void addComponents() {
		TileButton b1 = new TileButton(null);
		this.add(b1);
		layout.putConstraint(SpringLayout.NORTH, b1, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, b1, 10, SpringLayout.WEST, this);
	}
}
