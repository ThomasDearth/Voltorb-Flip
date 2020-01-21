package ui.gui;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import grid.cells.GridCell;
import grid.cells.NumberCell;
import grid.cells.VoltorbCell;
import grid.manager.GridManager;

public class CellButton extends Button {
  private static final long serialVersionUID = -9171289008171628463L;

  private static BufferedImage imgBack = GraphicsUtil.makeImage("resources/tiles/tileBlank.png");
  private static BufferedImage imgTile1 = GraphicsUtil.makeImage("resources/tiles/tile1.png");
  private static BufferedImage imgTile2 = GraphicsUtil.makeImage("resources/tiles/tile2.png");
  private static BufferedImage imgTile3 = GraphicsUtil.makeImage("resources/tiles/tile3.png");
  private static BufferedImage imgVoltorb = GraphicsUtil.makeImage("resources/tiles/tileVoltorb.png");

  private GridCell cell;
  private BufferedImage image;

  public CellButton(GridCell cell) {
    this.image = imgBack;
    this.setSize(getPreferredSize());
    this.cell = cell;

    this.addMouseListener(new CellButtonMouseListener(this));
  }

  @Override
  public void paint(Graphics g) {
    g.drawImage(image, 0, 0, null);
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(imgBack.getHeight(), imgBack.getHeight());
  }

  @Override
  public Dimension getMinimumSize() {
    return getPreferredSize();
  }

  private class CellButtonMouseListener implements MouseListener {
    private CellButton button;

    public CellButtonMouseListener(CellButton button) {
      this.button = button;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      if (button.cell instanceof NumberCell) {
        NumberCell cell = (NumberCell) button.cell;
        if(cell.getValue() == 1) {
          button.image = imgTile1;
        } else if (cell.getValue() == 2) {
          button.image = imgTile2;
        } else {
          button.image = imgTile3;
        }
      } else if (button.cell instanceof VoltorbCell) {
        button.image = imgVoltorb;
      }
      button.cell.select();
      System.out.println(GridManager.getInstance().getScore());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

  }
}
