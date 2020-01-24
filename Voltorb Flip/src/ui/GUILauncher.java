package ui;

import java.util.concurrent.TimeUnit;

import grid.manager.GridManager;
import ui.gui.GameWindow;

/**
 * Manages information about the GUI
 * 
 * @author Akronoskos
 *
 */
public class GUILauncher extends UI {
  private GameWindow window;

  public static void main(String[] args) {
    GUILauncher launcher = new GUILauncher();
    GridManager.getInstance().setUI(launcher);
    launcher.newBoard();
  }

  public GUILauncher() {
    window = new GameWindow();
  }

  @Override
  public void newBoard() {
    GridManager.getInstance().newBoard();
  }

  @Override
  public void renderBoard() {
    window.updateBoard();
  }

  @Override
  public void win() {
    // TODO implement winning behavior
    System.out.println("You win!");
  }

  @Override
  public void lose() {
    // TODO implement losing behavior
    System.out.println("Whoops! Good game!");
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    renderBoard();
  }
}
