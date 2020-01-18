package ui.gui;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import grid.cells.GridCell;

public class TileButton extends Button {
	private static final long serialVersionUID = -9171289008171628463L;
	
	//TODO: fix tileBlank image
	private static BufferedImage imgBack = GraphicsUtil.makeImage("resources/tileBlank.png");
	
	private GridCell cell;
	private BufferedImage image;
	
	public TileButton(GridCell cell) {
		this.image = imgBack;
		this.setPreferredSize(new Dimension(imgBack.getHeight(), imgBack.getHeight()));
		
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("clicked");
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}
}