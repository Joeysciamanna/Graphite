package ch.g_7.graphite.entity.ui.layout;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2i;
import org.joml.Vector2ic;

import ch.g_7.graphite.entity.ui.IUIPanel;
import ch.g_7.graphite.entity.ui.UIPanel;
import ch.g_7.graphite.entity.ui.dimension.ScaledScreenDimension;
import ch.g_7.graphite.entity.ui.dimension.ScreenDimension;

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
		this.columCellPlaceHolder = new ScreenDimension(ScreenDimension.X_AXIS);
		this.rowsCellPlaceHolder = new ScreenDimension(ScreenDimension.Y_AXIS);
	}
	
	@Override
	public void recalculateDimensions(Vector2ic screenSize) {
		recalculateDimension(columCellPlaceHolder, screenSize);
		recalculateDimension(rowsCellPlaceHolder, screenSize);	
		super.recalculateDimensions(screenSize);
	}
	
	public void remove(int x, int y) {
		IUIPanel panel = childs[x][y];
		childs[x][y] = null;
		childList.remove(panel);
	}
	
	public void add(IUIPanel panel, int x, int y) {
		if(childs[x][y] != null) {
			childList.remove(childs[x][y]);
			childs[x][y] = null;
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

		panel.getMaxWidth().reset().addPF((float)100/gridSize.x).remove(new ScaledScreenDimension(columCellPlaceHolder, gridSize.x-1));
		panel.getMinWidth().reset().addPF((float)100/gridSize.x).remove(new ScaledScreenDimension(columCellPlaceHolder, gridSize.x-1));
		
		panel.getMaxHeight().reset().addPF((float)100/gridSize.y).remove(new ScaledScreenDimension(rowsCellPlaceHolder, gridSize.y-1));
		panel.getMinHeight().reset().addPF((float)100/gridSize.y).remove(new ScaledScreenDimension(rowsCellPlaceHolder, gridSize.y-1));
		
		panel.getX().reset().addPF((float)100/gridSize.x * x).add(new ScaledScreenDimension(columCellPlaceHolder, x));
		panel.getY().reset().addPF((float)100/gridSize.y * y).add(new ScaledScreenDimension(rowsCellPlaceHolder,  y));

		requestDimensionRecalculation(this);
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
