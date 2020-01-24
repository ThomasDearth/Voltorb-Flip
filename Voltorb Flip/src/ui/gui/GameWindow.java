package ui.gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import javax.swing.SpringLayout;

public class GameWindow extends Frame {
  private static final long serialVersionUID = 4732891750003688342L;

  /** The icon image of the window. */
  private static final BufferedImage imgIcon = GraphicsUtil.makeImage("resources/tiles/tileVoltorb.png");
  /** The background color of the window. */
  private static final Color backgroundColor = new Color(24, 122, 90);
  
  /** The layout of the window */
  private SpringLayout layout;
  /** The area for the tiles */
  private GameContainer tileSquare;

  /** Creates a new game window. Bound to size of background image. */
  public GameWindow() {
    super("Voltorb Flip");
    this.setIconImage(imgIcon);
    this.setBackground(backgroundColor);
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
    // Create an array of buttons
    if (tileSquare != null) {
      this.remove(tileSquare);
      tileSquare.createNewCells();
      this.add(tileSquare);
    } else {
      tileSquare = new GameContainer();
      this.add(tileSquare);
    }

      // Binds the window size to the preferred size of the background
      layout.putConstraint(SpringLayout.NORTH, tileSquare, 0, SpringLayout.NORTH, this);
      layout.putConstraint(SpringLayout.WEST, tileSquare, 0, SpringLayout.WEST, this);
      layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH, tileSquare);
      layout.putConstraint(SpringLayout.EAST, this, 0, SpringLayout.EAST, tileSquare);
  }
}
