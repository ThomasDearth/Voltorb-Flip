package grid.board;

import java.util.Random;

import grid.cells.GridCell;
import grid.cells.NumberCell;
import grid.manager.GridManager;

/**A board of cells*/
public class Board {
	private GridCell[][] cells;
	private GridManager manager;

	private final static int ROWS = 5;
	private final static int COLUMNS = 5;

	public Board(GridManager manager) {
		this.manager = manager;
		Random random = new Random();

		// TODO: complete implementation
		cells = new GridCell[ROWS][COLUMNS];
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				cells[row][col] = new NumberCell(this, random.nextInt(3) + 1);
			}
		}
	}

	public GridManager getManager() {
		return manager;
	}

	public GridCell getCell(int row, int column) {
		return cells[row][column];
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
