package grid.manager;

import grid.board.Board;
import ui.UI;

public class GridManager {
	private static GridManager instance;
	private Board board;
	private int score;
	private UI ui;
	
	private GridManager() {
		score = 0;
		newBoard(1);
	}
	
	public static GridManager getInstance() {
		if(instance == null) {
			instance = new GridManager();
		}
		return instance;
	}

	public void newBoard(int level) {
		board = new Board(this, level);
	}
	
	public void setUI(UI ui) {
		this.ui = ui;
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
	
	//TODO: implement losing behavior
	public void lose() {
		board.revealBoard();
		ui.lose();
	}
}
