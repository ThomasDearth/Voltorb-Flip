package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**Class for methods for handling images.
 * 
 * @author Akronoskos
 *
 */
public class ImageUtil {

  public static BufferedImage makeImage(String path) {
    try {
      return ImageIO.read(new File(path));
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
