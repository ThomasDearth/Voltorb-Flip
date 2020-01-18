package ui;

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
    launcher.newBoard(1);
  }

  public GUILauncher() {
    window = new GameWindow();
  }

  @Override
  public void newBoard(int level) {
    GridManager.getInstance().newBoard(level);
  }

  @Override
  public void renderBoard() {
    window.updateBoard();
  }

  @Override
  public void win() {
    // TODO implement winning behavior
  }

  @Override
  public void lose() {
    // TODO implement losing behavior

  }
}
