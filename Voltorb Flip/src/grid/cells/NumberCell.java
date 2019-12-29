package grid.cells;

import grid.board.Board;

/**A cell with a point value*/
public class NumberCell extends GridCell {

	/**Creates a new NumberCell
	 * 
	 * @param manager the GridManager of the cell
	 * @param value the score the cell is worth
	 */
	public NumberCell(Board board, int value) {
		super(board, value);
	}

	@Override
	public void select() {
		setRevealed(true);
		getBoard().getManager().changeScore(getValue());
	}

	@Override
	public char toChar() {
		if(getRevealed()) {
			return (char) (getValue() + 48);	//Moves digit forward in ASCII
		} else {
			return 'X';
		}
	}
}
