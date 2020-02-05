package model.board;

import model.tile.NumberTile;
import model.tile.Tile;

/**
 * The board of tiles displayed on the board.
 * 
 * @author Akronoskos
 *
 */
public class Board {
  private static final int ROWS = 5;
  private static final int COLUMNS = 5;

  /** An array of tiles found on the board, in row-major order */
  private Tile[][] grid;
  /** The current score of the board */
  private int score;

  /**
   * Generates a new board randomly
   * 
   * @param level the level that the board represents, from 1 to 8
   */
  public Board(int level) {
    if (level < 1 || level > 8) {
      throw new IllegalArgumentException("Invalid level number.");
    }
    grid = new Tile[ROWS][COLUMNS];

    // TODO: get level information
    // TODO: randomly place important tiles
    for (int row = 0; row < ROWS; row++) {
      for (int col = 0; col < COLUMNS; col++) {
        if (grid[row][col] == null) {
          grid[row][col] = new NumberTile(this, 1);
        }
      }
    }
  }

  /**
   * Selects a tile at the given coordinates, starting at the upper left corner
   * 
   * @param row    the row of the tile
   * @param column the column of the tile
   */
  public void selectTile(int row, int column) {
    int multiplier = grid[row][column].select();
    if(multiplier == 0) {
      //TODO: add losing behavior
      System.out.println("Lose");
    } else {
      if(score == 0) {
        score = multiplier;
      } else {
        score *= multiplier;
      }
    }
  }
  
  /**Displays the board as text in standard out*/
  public void renderText() {
    for(int row = 0; row < ROWS; row++) {
      for(int col = 0; col < COLUMNS; col++) {
        System.out.print(grid[row][col].getPoints() + "   ");
      }
      System.out.println();
      System.out.println();
    }
  }
}
