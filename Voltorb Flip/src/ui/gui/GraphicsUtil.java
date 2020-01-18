package ui.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class GraphicsUtil {
	
	public static BufferedImage makeImage(String location) {
		try {
			return ImageIO.read(new File(location));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
