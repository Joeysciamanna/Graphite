package ch.g_7.graphite.base.ui.layout;

import org.joml.Vector2i;

import ch.g_7.graphite.base.ui.IUIPanel;
import ch.g_7.graphite.base.ui.UIPanel;

public class GridMergeLayoutPanel extends UIPanel {

	private Vector2i gridSize;

	private final IUIPanel[][] childs;

	public GridMergeLayoutPanel(int colums, int rows) {
		this.gridSize = new Vector2i(colums, rows);
		this.childs = new IUIPanel[colums][rows];
	}

	public void add(IUIPanel panel, int x, int y, int width, int height) {
		for (int i = x; i < x + width; i++) {
			for (int j = y; j < y + height; j++) {
				if(childs[i][j] != null) {
					remove(childs[i][j]);
				}
				childs[i][j] = panel;
			}
		}
		super.add(panel);
		place(panel, x, y, width, height);
	}

	private void place(IUIPanel panel, int x, int y, int width, int height) {

		panel.getMaxWidth().reset().addPF((float) 100 / gridSize.x * width);
		panel.getMinWidth().reset().addPF((float) 100 / gridSize.x * width);

		panel.getMaxHeight().reset().addPF((float) 100 / gridSize.y * width);
		panel.getMinHeight().reset().addPF((float) 100 / gridSize.y * width);
		
		panel.getX().reset().addPF((float) 100 / gridSize.x * x);
		panel.getY().reset().addPF((float) 100 / gridSize.y * y);
		
		requestRecalculation(this);
	}
	
	
	@Override
	protected void remove(IUIPanel panel) {
		for (int i = 0; i < childs.length; i++) {
			for (int j = 0; j < childs[i].length; j++) {
				if (panel.equals(childs[i][j])) {
					childs[i][j] = null;
				}
			}
		}
		super.remove(panel);
	}



}
