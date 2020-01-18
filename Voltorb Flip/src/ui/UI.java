package ui;

import grid.manager.GridManager;

/**
 * Abstract class defining what a UI should be able to do.
 * 
 * @author Akronoskos
 *
 */
public abstract class UI {

  public UI() {
    GridManager.getInstance().setUI(this);
  }

  public abstract void newBoard(int level);

  public abstract void renderBoard();

  public abstract void win();
  
  public abstract void lose();
}
