package ui;

import grid.board.Board;
import grid.cells.GridCell;
import grid.manager.GridManager;

public class TextUI extends UI{
	
	public TextUI() {
		super();
	}
	
	@Override
	public void renderBoard() {
		Board cells = getManager().getBoard();
		for(int row = 0; row < 5; row++) {
			String rowStr = "";
			for(int col = 0; col < 5; col++) {
				rowStr += cells.getCell(row, col).toChar();
			}
			System.out.println(rowStr);
		}
	}
}
