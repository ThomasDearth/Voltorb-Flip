package ui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageComponent extends Component {
	private static final long serialVersionUID = -7923913394004301363L;
	private BufferedImage img;

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
	
	public ImageComponent(String pathname) {
		try {
			img = ImageIO.read(new File(pathname));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Dimension getPreferredSize() {
        if (img == null) {
           return new Dimension(100,100);
		} else {
			return new Dimension(img.getWidth(), img.getHeight());
		}
	}
}
