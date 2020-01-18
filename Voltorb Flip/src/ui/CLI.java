package ui;

import grid.board.Board;

public class CLI extends UI {

	public CLI() {
		super();
	}
	
	@Override
	public void newBoard(int level) {
		getManager().newBoard(level);
		renderBoard();
	}
	
	@Override
	public void renderBoard() {
		Board board = getManager().getBoard();
		
		int[] colOrbs = new int[board.getSize()[1]];
		for(int i = 0; i < board.getSize()[1]; i++) {
			System.out.print(" ");
			int[] info = board.getColumnInfo(i);
			if(info[0] < 10) {
				System.out.print(" ");
			}
			colOrbs[i] = info[1];
			System.out.print(info[0] + " ");
		}
		System.out.println();
		for(int i = 0; i < board.getSize()[1]; i++) {
			System.out.print("  " + colOrbs[i] + " ");
		}
		System.out.println();
		
		System.out.println("---------------------");
		for(int row = 0; row < board.getSize()[0]; row++) {
			String rowStr = "| ";
			for(int col = 0; col < board.getSize()[1]; col++) {
				rowStr += board.getCell(row, col).toChar() + " | ";
			}
			int[] info = board.getRowInfo(row);
			rowStr += Integer.toString(info[0]) + " " + Integer.toString(info[1]);
			System.out.println(rowStr);
			System.out.println("---------------------");
		}
	}

	@Override
	public void lose() {
		System.out.println("You lose!");
		newBoard(1);
	}
}
