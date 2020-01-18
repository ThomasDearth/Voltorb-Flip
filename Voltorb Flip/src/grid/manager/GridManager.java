package grid.manager;

import grid.board.Board;
import ui.UI;

/**
 * Interfaces between the model and the UI and handles general game information.
 * Access using the static getInstance() method.
 * 
 * @author Akronoskos
 *
 */
public class GridManager {
  private static GridManager instance;
  private Board board;
  private int level;
  private int score;
  private UI ui;

  private GridManager() {
    level = 1;
    score = 0;
  }

  /**
   * Returns the GridManager, or creates one if one does not exist. Implements the
   * Singleton design pattern.
   * 
   * @return the GridManager.
   */
  public static GridManager getInstance() {
    if (instance == null) {
      instance = new GridManager();
    }
    return instance;
  }

  /**
   * Creates a new board to display.
   * 
   * @param level the board's level
   */
  public void newBoard(int level) {
    board = new Board(level);
    ui.renderBoard();
  }

  /**
   * Sets a UI to be interacted with.
   * 
   * @param ui the UI to be interacted with.
   */
  public void setUI(UI ui) {
    this.ui = ui;
  }

  /**
   * Returns the {@link Board} currently in play
   * 
   * @return the {@link Board} currently in play
   */
  public Board getBoard() {
    return board;
  }

  /**
   * Multiplies the score by an integer.
   * 
   * @param multiplier the multiplier for the score.
   */
  public void changeScore(int multiplier) {
    if (score == 0) {
      score = multiplier;
    } else {
      score *= multiplier;
    }
  }

  /**
   * Returns the game score.
   * 
   * @return the game's score
   */
  public int getScore() {
    return score;
  }

  /**
   * Flips a cell at the given coordinates.
   * 
   * @param row    the row to flip
   * @param column the column to flip
   */
  public void flipCell(int row, int column) {
    board.flipCell(row, column);
  }
  
  public void win() {
    board.revealBoard();
    level++;
    ui.win();
    newBoard(level);
  }

  /**
   * Reveals the board and calls the UI to reveal the board.
   * 
   */
  public void lose() {
    board.revealBoard();
    ui.lose();
  }
}
