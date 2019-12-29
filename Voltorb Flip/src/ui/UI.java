package ui;

import grid.manager.GridManager;

public abstract class UI {
	private GridManager gridManager;
	
	public UI() {
		gridManager = GridManager.getInstance();
	}
	
	protected GridManager getManager() {
		return gridManager;
	}
	
	public abstract void renderBoard();
}
