package model.tile;

import model.board.Board;

/**
 * A single tile on the board.
 * 
 * @author Akronoskos
 *
 */
public class Tile {
  /** The point value of a tile */
  private int points;
  /** Whether a tile has been flipped */
  private boolean revealed;

  /**
   * Creates a new tile.
   * 
   * @param board  the {@link Board} the tile is on
   * @param points the point multiplier the tile is worth
   */
  public Tile(int points) {
    if (points < 0 || points > 3) {
      throw new IllegalArgumentException("Points must be between 0 and 3.");
    }
    this.points = points;
  }

  /** Returns the points multiplier of the tile. */
  public int getPoints() {
    return this.points;
  }

  /** Sets the tile to be revealed. */
  public void reveal() {
    this.revealed = true;
  }
  
  public boolean getRevealed() {
    return this.revealed;
  }

  /**
   * Behavior when a tile is clicked on on the board.
   * 
   * @return the points multiplier of the tile
   */
  public int select() {
    this.revealed = true;
    return getPoints();
  }
}
