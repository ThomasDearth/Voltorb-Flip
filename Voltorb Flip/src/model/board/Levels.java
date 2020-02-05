package model.board;

import java.util.Random;

/**Helper class which generates random info about a level.
 * 
 * @author Akronoskos
 *
 */
public class Levels {
  // Source: https://bulbapedia.bulbagarden.net/wiki/Voltorb_Flip
  private final static int[][] level1 = { { 3, 1, 6 }, { 0, 3, 6 }, { 5, 0, 6 }, { 2, 2, 6 }, { 4, 1, 6 } };
  private final static int[][] level2 = { { 1, 3, 7 }, { 6, 0, 7 }, { 3, 2, 7 }, { 0, 4, 7 }, { 5, 1, 7 } };
  private final static int[][] level3 = { { 2, 3, 8 }, { 7, 0, 8 }, { 4, 2, 8 }, { 1, 4, 8 }, { 6, 1, 8 } };
  private final static int[][] level4 = { { 3, 3, 8 }, { 0, 5, 8 }, { 8, 0, 10 }, { 5, 2, 10 }, { 2, 4, 10 } };
  private final static int[][] level5 = { { 7, 1, 10 }, { 4, 3, 10 }, { 1, 5, 10 }, { 9, 0, 10 }, { 6, 2, 10 } };
  private final static int[][] level6 = { { 3, 4, 10 }, { 0, 6, 10 }, { 8, 1, 10 }, { 5, 3, 10 }, { 2, 5, 10 } };
  private final static int[][] level7 = { { 7, 2, 10 }, { 4, 4, 10 }, { 1, 6, 13 }, { 9, 1, 13 }, { 6, 3, 10 } };
  private final static int[][] level8 = { { 0, 7, 10 }, { 8, 2, 10 }, { 5, 4, 10 }, { 2, 6, 10 }, { 7, 3, 10 } };

  /**Returns info about a level from one of 5 configurations.
   * 
   * @param level the number of the level, from 1 to 8
   * @return an array of the number of 2s, 3s, and voltorbs, respectively.
   */
  public static int[] getLevelInfo(int level) {
    if (level < 1 || level > 8) {
      throw new IllegalArgumentException("Invalid level number.");
    }
    int[][][] levels = { level1, level2, level3, level4, level5, level6, level7, level8 };
    int set = new Random().nextInt(5);
    return levels[level-1][set];
  }
}
