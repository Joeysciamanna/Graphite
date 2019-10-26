package ch.g_7.graphite.entity.ui.layout;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2i;
import org.joml.Vector2ic;

import ch.g_7.graphite.entity.ui.IUIPanel;
import ch.g_7.graphite.entity.ui.UIPanel;
import ch.g_7.graphite.entity.ui.dimension.ScaledScreenDimension;
import ch.g_7.graphite.entity.ui.dimension.SimpleScreenDimension;

public class GridLayoutPanel extends UIPanel{

	private Vector2i gridSize;

	private SimpleScreenDimension columCellPlaceHolder;
	private SimpleScreenDimension rowsCellPlaceHolder;
	
	private final IUIPanel[][] childs;
	private List<IUIPanel> childList;
	
	public GridLayoutPanel(int colums, int rows) {
		this.gridSize = new Vector2i(colums, rows);
		this.childs = new IUIPanel[colums][rows];
		this.childList = new ArrayList<>();
		this.columCellPlaceHolder = new SimpleScreenDimension();
		this.rowsCellPlaceHolder = new SimpleScreenDimension();
	}
	
	@Override
	public void recalculate(Vector2ic screenSize) {
		recalculateDimension(columCellPlaceHolder, screenSize, SimpleScreenDimension.X_AXIS);
		recalculateDimension(rowsCellPlaceHolder, screenSize, SimpleScreenDimension.Y_AXIS);	
		super.recalculate(screenSize);
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
		panel.getMaxSize().reset().applyX((s)->s.addPF((float)100/gridSize.x).remove(new ScaledScreenDimension(columCellPlaceHolder, gridSize.x-1)));
		panel.getMinSize().reset().applyX((s)->s.addPF((float)100/gridSize.x).remove(new ScaledScreenDimension(columCellPlaceHolder, gridSize.x-1)));
		
		panel.getMaxSize().reset().applyY((s)->s.addPF((float)100/gridSize.y).remove(new ScaledScreenDimension(rowsCellPlaceHolder,  gridSize.y-1)));
		panel.getMinSize().reset().applyY((s)->s.addPF((float)100/gridSize.y).remove(new ScaledScreenDimension(rowsCellPlaceHolder,  gridSize.y-1)));
		
		panel.getPosition().applyX((s)->s.addPF((float)100/gridSize.x * x).add(new ScaledScreenDimension(columCellPlaceHolder, x)));
		panel.getPosition().applyY((s)->s.addPF((float)100/gridSize.y * y).add(new ScaledScreenDimension(rowsCellPlaceHolder,  y)));

		requestRecalculation(this);
	}
	
	
	@Override
	public List<IUIPanel> getChilds() {
		return childList;
	}

	public SimpleScreenDimension getColumCellPlaceHolder() {
		return columCellPlaceHolder;
	}
	
	public SimpleScreenDimension getRowsCellPlaceHolder() {
		return rowsCellPlaceHolder;
	}

}
