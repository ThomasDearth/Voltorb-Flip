package grid.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import grid.cells.GridCell;
import grid.manager.GridManager;

class BoardTest {
  private static int[] all1s = {5,0};

  @Test
  void testNotAll1s() {
    GridManager manager = GridManager.getInstance();
    for(int i = 0; i < 100; i++) {
      manager.newBoard();
      Board board = manager.getBoard();
      
      boolean[] invalidRows = new boolean[5];
      for(int row = 0; row < 5; row++) {
        int[] info = board.getRowInfo(row);
        invalidRows[row] = info.equals(all1s);
      }
      
      boolean invalid = invalidRows[0];
      for(int j = 1; j < 5; j++) {
        invalid = invalid & invalidRows[j];
      }
      
      if(invalid) {
        fail();
      }
    }
  }
}
