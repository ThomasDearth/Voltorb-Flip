package grid.cells;

import grid.board.Board;

/**A generic cell in a {@link Board}*/
public abstract class GridCell {
	/**Board the cell is in*/
	private Board board;
	/**Whether the cell is flipped or not*/
	private boolean revealed;
	/**The number of points a cell is worth*/
	private int value;
	
	/**Creates a new GridCell object
	 * 
	 * @param board the board the cell is in
	 * @param value the points multiplier of this cell
	 */
	public GridCell(Board board, int value) {
		this.board = board;
		setRevealed(false);
		setValue(value);
	}
	
	/**Returns whether the tile has been revealed or not
	 * 
	 * @return whether the tile has been revealed or not
	 */
	public boolean getRevealed() {
		return revealed;
	}
	
	/**Sets whether the tile has been revealed or not
	 * 
	 * @param revealed the revealed status
	 */
	public void setRevealed(boolean revealed) {
		this.revealed = revealed;
	}
	
	/**Returns the Board this cell is in
	 * 
	 * @return the Board this cell is in
	 */
	protected Board getBoard() {
		return board;
	}
	
	/**Behavior when a cell is selected*/
	public abstract void select();
	
	/**Returns the cell as a char*/
	public abstract char toChar();
	
	/**Returns the score a cell has*/
	public int getValue() {
		return value;
	}
	
	/**Sets the value
	 * 
	 * @param value the score of the tile
	 */
	private void setValue(int value) {
		this.value = value;
	}
}
