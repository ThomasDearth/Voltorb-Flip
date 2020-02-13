package view.board;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import model.Constants;
import model.board.Board;

public class BoardContainer extends JPanel {
  private static final long serialVersionUID = -4248173139160279554L;
  
  private TileButton[][] grid;
  private SpringLayout layout;
  private Board board;

  public BoardContainer() {
    this.layout = new SpringLayout();
    this.grid = new TileButton[Constants.ROWS][Constants.COLUMNS];
    this.setLayout(layout);
    this.board = new Board(1);  //TODO: add proper levels
    
    newBoard();
  }
  
  /**Renders a new set of tiles in the container.
   * 
   */
  public void newBoard() {
    //Clear the board
    for(int row = 0; row < Constants.ROWS; row++) {
      for(int col = 0; col < Constants.COLUMNS; col++) {
        if(grid[row][col] != null) {
          System.out.println("tile removed @ " + row + "," + col);
          this.remove(grid[row][col]);
          grid[row][col] = null;
        }
      }
    }
    
    //Create top-left button
    grid[0][0] = new TileButton(board.getTile(0, 0));
    this.add(grid[0][0]);
    layout.putConstraint(SpringLayout.NORTH, grid[0][0], Constants.BOARD_OFFSET_Y, SpringLayout.NORTH, this);
    layout.putConstraint(SpringLayout.WEST, grid[0][0], Constants.BOARD_OFFSET_X, SpringLayout.WEST, this);
    
    //Fill in top row
    for(int col = 1; col < Constants.COLUMNS; col++) {
      grid[0][col] = new TileButton(board.getTile(0, col));
      this.add(grid[0][col]);
      layout.putConstraint(SpringLayout.NORTH, grid[0][col], 0, SpringLayout.NORTH, grid[0][col-1]);
      layout.putConstraint(SpringLayout.WEST, grid[0][col], Constants.TILE_OFFSET, SpringLayout.EAST, grid[0][col-1]);
    }
    
    //Fill in lower rows
    for(int row = 1; row < Constants.ROWS; row++) {
      for(int col = 0; col < Constants.COLUMNS; col++) {
        grid[row][col] = new TileButton(board.getTile(row, col));
        this.add(grid[row][col]);
        layout.putConstraint(SpringLayout.NORTH, grid[row][col], Constants.TILE_OFFSET, SpringLayout.SOUTH, grid[row-1][col]);
        layout.putConstraint(SpringLayout.WEST, grid[row][col], 0, SpringLayout.WEST, grid[row-1][col]);
      }
    }
  }
}
