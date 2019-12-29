package grid.board;

import java.util.Random;

import grid.cells.GridCell;
import grid.cells.NumberCell;
import grid.cells.VoltorbCell;
import grid.manager.GridManager;

/**A board of cells*/
public class Board {
	private GridCell[][] cells;
	private GridManager manager;

	private final static int ROWS = 5;
	private final static int COLUMNS = 5;

	public Board(GridManager manager, int level) {
		this.manager = manager;

		initializeBoard(level);
	}

	public GridManager getManager() {
		return manager;
	}

	public GridCell getCell(int row, int column) {
		return cells[row][column];
	}
	
	private void initializeBoard(int level) {
		Random random = new Random();
		int[] contents = Levels.getTiles(level);
		cells = new GridCell[ROWS][COLUMNS];
		
		while(contents[0] > 0 | contents[1] > 0 | contents[2] > 0) {
			int row = random.nextInt(ROWS);
			int col = random.nextInt(COLUMNS);
			if(cells[row][col] == null) {
				if(contents[0] > 0) {
					cells[row][col] = new NumberCell(this, 2);
					contents[0]--;
				} else if(contents[1] > 0) {
					cells[row][col] = new NumberCell(this, 3);
					contents[1]--;
				} else {
					cells[row][col] = new VoltorbCell(this);
					contents[2]--;
				}
			}
		}
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLUMNS; col++) {
				if(cells[row][col] == null) {
					cells[row][col] = new NumberCell(this, 1);
				}
			}
		}
	}
		

	public void flipCell(int row, int column) {
		cells[row][column].select();
	}

	public void revealBoard() {
		for (GridCell[] row : cells) {
			for (GridCell cell : row) {
				cell.setRevealed(true);
			}
		}
	}
}
