package grid.manager;

import static org.junit.Assert.*;
import org.junit.jupiter.api.*;

import grid.cells.NumberCell;
import grid.manager.GridManager;
import ui.CLI;

class GridManagerTest {
	private GridManager manager;
	
	@BeforeEach
	public void setup() {
		manager = GridManager.getInstance();
	}
	
	@Test
	public void testRenderText() {
		manager.newBoard(6);
		CLI ui = new CLI();
		assertEquals(0, manager.getScore());
		System.out.println("Board: unrevealed\nScore: " + manager.getScore());
		ui.renderBoard();
		
		for(int row = 0; row < 5; row++) {
			for(int col = 0; col < 5; col++) {
				if(manager.getBoard().getCell(row, col).getClass().equals(NumberCell.class)) {
					manager.flipCell(row, col);
					assertTrue(manager.getScore() > 0);
				}
			}
		}
		System.out.println("\nBoard: revealed\nScore: " + manager.getScore());
		ui.renderBoard();
	}
}
