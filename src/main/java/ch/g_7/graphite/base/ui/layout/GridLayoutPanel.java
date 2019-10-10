package ch.g_7.graphite.base.ui.layout;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2i;
import org.joml.Vector2ic;

import ch.g_7.graphite.base.ui.IUIPanel;
import ch.g_7.graphite.base.ui.ScreenDimension;
import ch.g_7.graphite.base.ui.UIPanel;

public class GridLayoutPanel extends UIPanel{

	private Vector2i gridSize;

	private ScreenDimension columCellPlaceHolder;
	private ScreenDimension rowsCellPlaceHolder;
	
	private final IUIPanel[][] childs;
	private List<IUIPanel> childList;
	
	public GridLayoutPanel(int colums, int rows) {
		this.gridSize = new Vector2i(colums, rows);
		this.childs = new IUIPanel[colums][rows];
		this.childList = new ArrayList<>();
		this.columCellPlaceHolder = new ScreenDimension();
		this.rowsCellPlaceHolder = new ScreenDimension();
	}
	
	@Override
	public void recalculate(Vector2ic screenSize) {
		recalculateDimension(columCellPlaceHolder, screenSize, ScreenDimension.X_AXIS);
		recalculateDimension(rowsCellPlaceHolder, screenSize, ScreenDimension.Y_AXIS);	
		super.recalculate(screenSize);
	}
	
	public void add(IUIPanel panel, int x, int y) {
		if(childs[x][y] != null) {
			childList.remove(childs[x][y]);
		}
		childs[x][y] = panel;
		childList.add(panel);
		panel.setFather(this);
		place(panel, x, y);
	}
	
	public void add(IUIPanel panel) {
		for (int y = 0; y < childs[0].length; y++) {
			for (int x = 0; x < childs.length; x++) {
				if(childs[x][y] == null) {
					add(panel, x, y);
					return;
				}
			}
		}
	}
	
	private void place(IUIPanel panel, int x, int y) {
		panel.getWidth().reset().addPF((float)100/gridSize.x).remove(new ScreenDimension().add(columCellPlaceHolder).multiply(gridSize.x-1));
		panel.getHeight().reset().addPF((float)100/gridSize.y).remove(new ScreenDimension().add(rowsCellPlaceHolder).multiply(gridSize.y-1));
		
		panel.getX().reset().addPF((float)100/gridSize.x * x).add(new ScreenDimension().add(columCellPlaceHolder).multiply(x));
		panel.getY().reset().addPF((float)100/gridSize.y * y).add(new ScreenDimension().add(rowsCellPlaceHolder).multiply(y));

		requestRecalculation(this);
	}
	
	
	@Override
	public List<IUIPanel> getChilds() {
		return childList;
	}

	public ScreenDimension getColumCellPlaceHolder() {
		return columCellPlaceHolder;
	}
	
	public ScreenDimension getRowsCellPlaceHolder() {
		return rowsCellPlaceHolder;
	}

}
