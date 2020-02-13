package model.board;

import java.util.Random;

import exception.CannotPlaceTileException;
import model.Constants;
import model.tile.Tile;

/**
 * The board of tiles displayed on the board.
 * 
 * @author Akronoskos
 *
 */
public class Board {
  private static final int ROWS = Constants.ROWS;
  private static final int COLUMNS = Constants.COLUMNS;

  /** An array of tiles found on the board, in row-major order */
  private Tile[][] grid;
  /** The current score of the board */
  private int score;
  /**The number of obtainable points on the board.*/
  private int goal;

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
    goal = 1;

    int[] info = Levels.getLevelInfo(level);
    Random r = new Random();

    // Generate 2s
    int failureCount = 0;
    while (info[0] > 0) {
      int row = r.nextInt(ROWS);
      int col = r.nextInt(COLUMNS);
      if (grid[row][col] == null) {
        grid[row][col] = new Tile(2);
        goal *= 2;
        info[0] = info[0] - 1;
      } else {
        failureCount++;
        if (failureCount > 100) {
          throw new CannotPlaceTileException();
        }
      }
    }

    // Generate 3s
    failureCount = 0;
    while (info[1] > 0) {
      int row = r.nextInt(ROWS);
      int col = r.nextInt(COLUMNS);
      if (grid[row][col] == null) {
        grid[row][col] = new Tile(3);
        goal *= 3;
        info[1] = info[1] - 1;
      } else {
        failureCount++;
        if (failureCount > 100) {
          throw new CannotPlaceTileException();
        }
      }
    }

    // Generate 0s
    failureCount = 0;
    while (info[2] > 0) {
      int row = r.nextInt(ROWS);
      int col = r.nextInt(COLUMNS);
      if (grid[row][col] == null) {
        grid[row][col] = new Tile(0);
        info[2] = info[2] - 1;
      } else {
        failureCount++;
        if (failureCount > 100) {
          throw new CannotPlaceTileException();
        }
      }
    }

    // Fill in the rest of the grid
    for (int row = 0; row < ROWS; row++) {
      for (int col = 0; col < COLUMNS; col++) {
        if (grid[row][col] == null) {
          grid[row][col] = new Tile(1);
        }
      }
    }
  }

  /**
   * Returns the number of points in a given tile.
   * 
   * @param row    the row number, starting from the top
   * @param column the column number, starting from the left
   * @return the number of points at the given tile
   */
  public int getTileScore(int row, int column) {
    return grid[row][column].getPoints();
  }
  
  public Tile getTile(int row, int column) {
    return grid[row][column];
  }

  /**
   * Selects a tile at the given coordinates, starting at the upper left corner
   * 
   * @param row    the row of the tile
   * @param column the column of the tile
   */
  public void selectTile(int row, int column) {
    int multiplier = grid[row][column].select();
    if (multiplier == 0) {
      // TODO: add losing behavior
      System.out.println("Lose");
    } else {
      if (score == 0) {
        score = multiplier;
      } else {
        score *= multiplier;
      }
      if(score == goal) {
        //TODO: implement winning behavior
        System.out.println("You win!");
      }
    }
  }

  /**
   * Returns the number of points and voltorbs in a row
   * 
   * @param row the number of the row, starting from the top
   * @return an array containing the sum total of points in the row, then the
   *         number of 0s
   */
  public int[] getRowInfo(int row) {
    int[] ret = {0, 0};
    for(int col = 0; col < COLUMNS; col++) {
      if(getTileScore(row, col) == 0) {
        ret[1]++;
      } else {
        ret[0] += getTileScore(row, col);
      }
    }
    return ret;
  }

  /**
   * Returns the number of points and voltorbs in a column
   * 
   * @param row the number of the row, starting from the left
   * @return an array containing the sum total of points in the column, then the
   *         number of 0s
   */
  public int[] getColumnInfo(int col) {
    // TODO: test this method
    int[] ret = {0,0};
    for(int row = 0; row < ROWS; row++) {
      if(getTileScore(row, col) == 0) {
        ret[1]++;
      } else {
        ret[0] += getTileScore(row, col);
      }
    }
    return ret;
  }

  /** Displays the board as text in standard out */
  public void renderText() {
    System.out.println("Target score: " + goal + "\n");
    for (int row = 0; row < ROWS; row++) {
      for (int col = 0; col < COLUMNS; col++) {
        System.out.print(getTileScore(row, col) + "   ");
      }
      System.out.println(getRowInfo(row)[0] + " " + getRowInfo(row)[1] + "\n");
    }
  }
}
