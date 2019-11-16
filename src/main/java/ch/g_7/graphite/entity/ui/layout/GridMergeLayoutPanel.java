package ch.g_7.graphite.entity.ui.layout;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2i;

import ch.g_7.graphite.entity.ui.IUIPanel;
import ch.g_7.graphite.entity.ui.UIPanel;
import ch.g_7.graphite.entity.ui.dimension.ScaledScreenDimension;

public class GridMergeLayoutPanel extends UIPanel {

	private Vector2i gridSize;

	private final IUIPanel[][] childs;
	private List<IUIPanel> childList;

	public GridMergeLayoutPanel(int colums, int rows) {
		this.gridSize = new Vector2i(colums, rows);
		this.childs = new IUIPanel[colums][rows];
		this.childList = new ArrayList<>();
	}

	public void add(IUIPanel panel, int x, int y, int width, int height) {
		for (int i = x; i < x + width; i++) {
			for (int j = y; j < y + height; j++) {
				if(childs[i][j] != null) {
					remove(i, j);
				}
				childs[i][j] = panel;
			}
		}
		childList.add(panel);
		panel.setFather(this);
		place(panel, x, y, width, height);
	}

	private void place(IUIPanel panel, int x, int y, int width, int height) {

		panel.getMaxWidth().reset().addPF((float) 100 / gridSize.x * width);
		panel.getMinWidth().reset().addPF((float) 100 / gridSize.x * width);

		panel.getMaxHeight().reset().addPF((float) 100 / gridSize.y * width);
		panel.getMinHeight().reset().addPF((float) 100 / gridSize.y * width);
		
		panel.getX().reset().addPF((float) 100 / gridSize.x * x);
		panel.getY().reset().addPF((float) 100 / gridSize.y * y);
		
		requestDimensionRecalculation(this);
	}

	public void remove(int x, int y) {
		IUIPanel panel = null;
		for (int i = x; i < childs.length; i++) {
			for (int j = y; j < childs[i].length; j++) {
				if (panel == null || panel.equals(childs[i][j])) {
					panel = childs[i][j];
					childs[i][j] = null;
				}

			}
		}
		childList.remove(panel);
	}

	@Override
	public List<IUIPanel> getChilds() {
		return childList;
	}

}
