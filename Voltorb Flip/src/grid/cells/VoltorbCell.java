package grid.cells;

import grid.board.Board;

public class VoltorbCell extends GridCell {

	public VoltorbCell(Board board) {
		super(board, 0);
	}

	@Override
	public void select() {
		setRevealed(true);
		getBoard().getManager().lose();
	}

	@Override
	public char toChar() {
		if(getRevealed()) {
			return 'O';
		} else {
			return ' ';
		}
	}

}
