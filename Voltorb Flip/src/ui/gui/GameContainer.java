package ui.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.SpringLayout;

import grid.board.Board;
import grid.manager.GridManager;

/** Container which has a background image and a grid of tiles. */
public class GameContainer extends Container {
  private static final long serialVersionUID = -4861146958994103107L;

  /** The background of a game of VoltorbFlip. */
  private static final BufferedImage imgBackground = GraphicsUtil.makeImage("resources/background/boardBackground.png");

  /** The distance from the top of the board to the top row of cells. */
  private static final int Y_OFFSET = 10;
  /** The distance from the left of the board to the left column of cells. */
  private static final int X_OFFSET = 11;
  /** The distance (X or Y) between cells. */
  private static final int CELL_DIST = 8;

  private GridManager manager;
  private CellButton[][] grid;
  private SpringLayout layout;

  public GameContainer() {
    // Set up fields
    this.manager = GridManager.getInstance();
    int[] dims = manager.getBoard().getSize();
    this.grid = new CellButton[dims[0]][dims[1]];

    // Make a new board
    createNewCells();
  }

  @Override
  public void paint(Graphics g) {
    this.getGraphics().drawImage(imgBackground, 0, 0, null);
    this.setSize(new Dimension(imgBackground.getWidth(), imgBackground.getHeight()));
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(imgBackground.getWidth(), imgBackground.getHeight());
  }

  public void createNewCells() {
    this.setVisible(false);
    this.layout = new SpringLayout();
    this.setLayout(layout);

    manager.newBoard();
    Board board = manager.getBoard();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] != null) {
          this.remove(grid[i][j]);
          grid[i][j] = null;
        }
      }
    }

    // Create the first cell
    grid[0][0] = new CellButton(board.getCell(0, 0));
    this.add(grid[0][0]);
    this.layout.putConstraint(SpringLayout.NORTH, grid[0][0], Y_OFFSET, SpringLayout.NORTH, this);
    this.layout.putConstraint(SpringLayout.WEST, grid[0][0], X_OFFSET, SpringLayout.WEST, this);

    // Create the first row
    for (int col = 1; col < grid[0].length; col++) {
      grid[0][col] = new CellButton(board.getCell(0, col));
      this.add(grid[0][col]);
      this.layout.putConstraint(SpringLayout.NORTH, grid[0][col], Y_OFFSET, SpringLayout.NORTH, this);
      this.layout.putConstraint(SpringLayout.WEST, grid[0][col], CELL_DIST, SpringLayout.EAST, grid[0][col - 1]);
    }

    // Create other rows below them
    for (int row = 1; row < grid.length; row++) {
      // Create a new cell
      grid[row][0] = new CellButton(board.getCell(row, 0));
      this.add(grid[row][0]);

      // The position of the cell is based on the position of the row above
      this.layout.putConstraint(SpringLayout.NORTH, grid[row][0], CELL_DIST, SpringLayout.SOUTH, grid[row - 1][0]);
      this.layout.putConstraint(SpringLayout.WEST, grid[row][0], X_OFFSET, SpringLayout.WEST, this);

      // Fill out the rest of the row
      for (int col = 1; col < grid[0].length; col++) {
        grid[row][col] = new CellButton(board.getCell(row, col));
        this.add(grid[row][col]);
        this.layout.putConstraint(SpringLayout.NORTH, grid[row][col], CELL_DIST, SpringLayout.SOUTH,
            grid[row - 1][col]);
        this.layout.putConstraint(SpringLayout.WEST, grid[row][col], CELL_DIST, SpringLayout.EAST, grid[row][col - 1]);
      }
    }
    this.setVisible(true);
    this.doLayout();
  }
}
