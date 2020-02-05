package model.tile;

import model.board.Board;

/**
 * A tile with a regular score.
 * 
 * @author Games
 *
 */
public class NumberTile extends Tile {

  /**
   * Creates a new basic tile.
   * 
   * @param board the board this tile is on
   * @param points the number of points a tile is worth, from 1 to 3
   */
  public NumberTile(Board board, int points) {
    super(board, points); 
    if (points < 1 || points > 3) {
      throw new IllegalArgumentException("Points must be between 1 and 3.");
    }
  }

}
