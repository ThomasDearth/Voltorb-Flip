package grid.manager;

import grid.board.Board;
import grid.cells.GridCell;
import grid.cells.NumberCell;

public class GridManager {
	private static GridManager instance;
	private Board board;
	private int score;
	
	private GridManager() {
		score = 0;
		newBoard();
	}
	
	public static GridManager getInstance() {
		if(instance == null) {
			instance = new GridManager();
		}
		return instance;
	}

	public void newBoard() {
		board = new Board(this);
	}
	
	/**Returns the {@link Board} currently in play
	 * 
	 * @return the {@link Board} currently in play
	 */
	public Board getBoard() {
		return board;
	}

	public void changeScore(int multiplier) {
		if (score == 0) {
			score = multiplier;
		} else {
			score *= multiplier;
		}
	}
	
	public int getScore() {
		return score;
	}
	
	public void flipCell(int row, int column) {
		board.flipCell(row, column);
	}
}
