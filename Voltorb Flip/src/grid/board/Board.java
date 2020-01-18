package grid.board;

import java.util.Random;

import grid.cells.GridCell;
import grid.cells.NumberCell;
import grid.cells.VoltorbCell;
import grid.manager.GridManager;

/** A board of cells */
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

	/** Gets information about a cell
	 * 
	 * @param row the row (starts at 0)
	 * @param column the column (starts at 0)
	 * @return the GridCell at the given coordinates
	 */
	public GridCell getCell(int row, int column) {
		return cells[row][column];
	}

	/**Returns the dimensions of the board
	 * 
	 * @return an array with contents {rows, columns}
	 */
	public int[] getSize() {
		int[] ret = { ROWS, COLUMNS };
		return ret;
	}

	private void initializeBoard(int level) {
		Random random = new Random();
		int[] contents = Levels.getTiles(level);
		cells = new GridCell[ROWS][COLUMNS];

		while (contents[0] > 0 | contents[1] > 0 | contents[2] > 0) {
			int row = random.nextInt(ROWS);
			int col = random.nextInt(COLUMNS);
			if (cells[row][col] == null) {
				if (contents[0] > 0) {
					cells[row][col] = new NumberCell(this, 2);
					contents[0]--;
				} else if (contents[1] > 0) {
					cells[row][col] = new NumberCell(this, 3);
					contents[1]--;
				} else {
					cells[row][col] = new VoltorbCell(this);
					contents[2]--;
				}
			}
		}
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				if (cells[row][col] == null) {
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

	/**Returns information about a row
	 * 
	 * @param row the number of the row
	 * @return an array of {score, voltorbs}
	 */
	public int[] getRowInfo(int row) {
		int[] ret = { 0, 0 };
		for (int i = 0; i < ROWS; i++) {
			if (cells[row][i].getClass() == NumberCell.class) {
				ret[0] += cells[row][i].getValue();
			} else {
				ret[1]++;
			}
		}
		return ret;
	}

	/**Returns information about a column
	 * 
	 * @param column the number of the column
	 * @return an array of {score, voltorbs}
	 */
	public int[] getColumnInfo(int column) {
		int[] ret = { 0, 0 };
		for (int i = 0; i < COLUMNS; i++) {
			if (cells[i][column].getClass() == NumberCell.class) {
				ret[0] += cells[i][column].getValue();
			} else {
				ret[1]++;
			}
		}
		return ret;
	}
}
