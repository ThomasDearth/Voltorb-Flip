package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import view.board.BoardContainer;

public class GameWindow extends JFrame {
  private static final long serialVersionUID = -6399886456682347905L;

  private static BufferedImage imgBackground = ImageUtil.makeImage("resources/background/boardBackground.png");
  private GridLayout layout;
  private GameBackground background;

  public GameWindow() {
    super("Voltorb Flip");

    this.layout = new GridLayout();
    this.setLayout(layout);

    this.background = new GameBackground();
    this.add(background);

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

    this.setResizable(false);
    this.pack();
    this.setVisible(true);
  }

  private class GameBackground extends JPanel {
    private static final long serialVersionUID = 5780864222220760534L;

    private BoardContainer board;

    public GameBackground() {
      super();
      this.setPreferredSize(new Dimension(imgBackground.getWidth(), imgBackground.getHeight()));
      this.setLayout(new GridLayout());
      board = new BoardContainer();
      this.add(board);
    }

    @Override
    public void paint(Graphics g) {
      g.drawImage(imgBackground, 0, 0, null);
    }
  }
}
