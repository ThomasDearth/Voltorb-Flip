package view.board;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.tile.Tile;
import view.ImageUtil;

public class TileButton extends JButton {
  private static final long serialVersionUID = -4569916702411465331L;

  private static final String imgBlankURL = "resources/tiles/tileBlank.png";
  private static final String imgTile1URL = "resources/tiles/tile1.png";
  private static final String imgTile2URL = "resources/tiles/tile2.png";
  private static final String imgTile3URL = "resources/tiles/tile3.png";
  private static final String imgVoltorbURL = "resources/tiles/tileVoltorb.png";

  private Tile tile;

  public TileButton(Tile tile) {
    super(new ImageIcon(imgBlankURL));
    this.tile = tile;
    BufferedImage imgBlank = ImageUtil.makeImage(imgBlankURL);
    this.setPreferredSize(new Dimension(imgBlank.getWidth(), imgBlank.getHeight()));
    this.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        //TODO: add click behavior
        System.out.println(e.getSource());
        int score = tile.select();
        if(score == 1) {
           setIcon(new ImageIcon(imgTile1URL));
        } else if(score == 2) {
           setIcon(new ImageIcon(imgTile2URL));
        } else if(score == 3) {
          setIcon(new ImageIcon(imgTile3URL));
        } else {
          setIcon(new ImageIcon(imgVoltorbURL));
        }
      }
    });
    this.setVisible(true);
  }
}
