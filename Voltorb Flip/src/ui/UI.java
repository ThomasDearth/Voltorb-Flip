package ui;

import grid.manager.GridManager;

public abstract class UI {
	private GridManager gridManager;
	
	public UI() {
		gridManager = GridManager.getInstance();
		gridManager.setUI(this);
	}
	
	protected GridManager getManager() {
		return gridManager;
	}
	
	public abstract void renderNewBoard(int level);
	
	public abstract void lose();
}
