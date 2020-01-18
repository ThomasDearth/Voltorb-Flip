package grid.cells;

import grid.board.Board;
import grid.manager.GridManager;

/**
 * A Voltorb cell. Selecting a Voltorb causes the player to lose the game.
 * 
 * @author Akronoskos
 *
 */
public class VoltorbCell extends GridCell {

  /**
   * Creates a Voltorb cell.
   * 
   * @param board the board the cell is on
   */
  public VoltorbCell(Board board) {
    super(board, 0);
  }

  @Override
  public void select() {
    setRevealed(true);
    GridManager.getInstance().lose();
  }

  @Override
  public char toChar() {
    if (getRevealed()) {
      return 'O';
    } else {
      return ' ';
    }
  }

}
