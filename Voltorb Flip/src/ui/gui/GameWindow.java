package ui.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import javax.swing.SpringLayout;

public class GameWindow extends Frame {
  private static final long serialVersionUID = 4732891750003688342L;

  /** The icon image of the window. */
  private static final BufferedImage imgIcon = GraphicsUtil.makeImage("resources/tiles/tileVoltorb.png");
  /** The background of a game of VoltorbFlip. */
  private static final BufferedImage imgBackground = GraphicsUtil.makeImage("resources/background/boardBackground.png");

  /** The layout of the window */
  private static SpringLayout layout;

  /** Creates a new game window. Bound to size of background image. */
  public GameWindow() {
    super("Voltorb Flip");
    this.setIconImage(imgIcon);
    // Set up listeners
    this.addWindowListener(new WindowListener() {

      @Override
      public void windowOpened(WindowEvent e) {
      }

      @Override
      public void windowIconified(WindowEvent e) {
      }

      @Override
      public void windowDeiconified(WindowEvent e) {
      }

      @Override
      public void windowDeactivated(WindowEvent e) {
      }

      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }

      @Override
      public void windowClosed(WindowEvent e) {
      }

      @Override
      public void windowActivated(WindowEvent e) {
      }
    });

    // Create a layout
    this.setSize(500, 500);
    layout = new SpringLayout();
    this.setLayout(layout);

    // Render the board
    this.updateBoard();

    this.pack();
    this.setResizable(false);

    // Makes the window visible
    this.setVisible(true);
  }

  /** Updates the appearance of the board */
  public void updateBoard() {
    // TODO create buttons here

    // Create a background
    this.setBackground(new Color(25, 128, 95));
    Background b = new Background();
    this.add(b);

    // Binds the window size to the preferred size of the background
    layout.putConstraint(SpringLayout.NORTH, b, 0, SpringLayout.NORTH, this);
    layout.putConstraint(SpringLayout.WEST, b, 0, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH, b);
    layout.putConstraint(SpringLayout.EAST, this, 0, SpringLayout.EAST, b);
  }

  /** Component containing an image of the background */
  private class Background extends Container {
    private static final long serialVersionUID = -4861146958994103107L;

    @Override
    public void paint(Graphics g) {
      this.getGraphics().drawImage(imgBackground, 0, 0, null);
      this.setSize(new Dimension(imgBackground.getWidth(), imgBackground.getHeight()));
    }

    @Override
    public Dimension getPreferredSize() {
      return new Dimension(imgBackground.getWidth(), imgBackground.getHeight());
    }
  }
}
