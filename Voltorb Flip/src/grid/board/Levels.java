package grid.board;

import java.util.Random;

/** Support class for determining the contents of levels */
public class Levels {

  /** Array of levels' sets of 2s, 3s, and Voltorbs */
  private int[][][] levelsArray = null;

  private static Levels levels;

  public static Levels getInstance() {
    if (levels == null) {
      levels = new Levels();
    }
    return levels;
  }

  public Levels() {
    // Source: https://bulbapedia.bulbagarden.net/wiki/Voltorb_Flip
    int[][] level1 = { { 3, 1, 6 }, { 0, 3, 6 }, { 5, 0, 6 }, { 2, 2, 6 }, { 4, 1, 6 } };
    int[][] level2 = { { 1, 3, 7 }, { 6, 0, 7 }, { 3, 2, 7 }, { 0, 4, 7 }, { 5, 1, 7 } };
    int[][] level3 = { { 2, 3, 8 }, { 7, 0, 8 }, { 4, 2, 8 }, { 1, 4, 8 }, { 6, 1, 8 } };
    int[][] level4 = { { 3, 3, 8 }, { 0, 5, 8 }, { 8, 0, 10 }, { 5, 2, 10 }, { 2, 4, 10 } };
    int[][] level5 = { { 7, 1, 10 }, { 4, 3, 10 }, { 1, 5, 10 }, { 9, 0, 10 }, { 6, 2, 10 } };
    int[][] level6 = { { 3, 4, 10 }, { 0, 6, 10 }, { 8, 1, 10 }, { 5, 3, 10 }, { 2, 5, 10 } };
    int[][] level7 = { { 7, 2, 10 }, { 4, 4, 10 }, { 1, 6, 13 }, { 9, 1, 13 }, { 6, 3, 10 } };
    int[][] level8 = { { 0, 7, 10 }, { 8, 2, 10 }, { 5, 4, 10 }, { 2, 6, 10 }, { 7, 3, 10 } };
    int[][][] levelsArray = { level1, level2, level3, level4, level5, level6, level7, level8 };
    this.levelsArray = levelsArray;
  }

  /**
   * Returns an array containing information about a level
   * 
   * @param level the number of the level played [1 to 8]
   * @return an array with the format [2s, 3s, Voltorbs]
   */
  public int[] getTiles(int level) {
    if (level < 1 || level > 8) {
      throw new IndexOutOfBoundsException();
    }
    Random random = new Random();
    int permutation = random.nextInt(5);
    return levelsArray[level - 1][permutation];
  }
}
