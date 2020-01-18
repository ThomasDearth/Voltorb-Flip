package ui;

import grid.manager.GridManager;
import ui.gui.GameWindow;

public class GUILauncher extends UI {
	private int level;
	
	public static void main(String[] args) {
		new GUILauncher();
	}
	
	public GUILauncher() {
		new GameWindow();
		this.level = 1;
		newBoard(level);
	}

	@Override
	public void newBoard(int level) {
		GridManager.getInstance().newBoard(level);
		renderBoard();
	}

	@Override
	public void renderBoard() {
		
	}

	@Override
	public void lose() {
		// TODO implement losing behavior
		
	}
}
