package ch.g_7.graphite.base.ui.layout;

import org.joml.Vector2i;
import org.joml.Vector2ic;

import ch.g_7.graphite.base.ui.IUIPanel;
import ch.g_7.graphite.base.ui.UIPanel;
import ch.g_7.graphite.base.ui.util.ScaledScreenDimension;
import ch.g_7.graphite.base.ui.util.ScreenDimension;

public class GridLayoutPanel extends UIPanel{

	private Vector2i gridSize;

	private ScreenDimension columCellPlaceHolder;
	private ScreenDimension rowCellPlaceHolder;
	
	private float panelWidth;
	private float panelHeight;
	private ScaledScreenDimension columPlaceHolderPerCell;
	private ScaledScreenDimension rowPlaceHolderPerCell;
	
	private final IUIPanel[][] childs;
	
	public GridLayoutPanel(int colums, int rows) {
		this.gridSize = new Vector2i(colums, rows);
		this.childs = new IUIPanel[colums][rows];

		this.columCellPlaceHolder = new ScreenDimension(ScreenDimension.X_AXIS);
		this.rowCellPlaceHolder = new ScreenDimension(ScreenDimension.Y_AXIS);
		
		this.panelWidth = (float) 100/gridSize.x;
		this.panelHeight = (float) 100/gridSize.y;
		this.columPlaceHolderPerCell = new ScaledScreenDimension(columCellPlaceHolder, (float)(gridSize.x-1)/gridSize.x);
		this.rowPlaceHolderPerCell = new ScaledScreenDimension(rowCellPlaceHolder, (float)(gridSize.y-1)/gridSize.y);
	}
	
	@Override
	public void recalculate(Vector2ic screenSize) {
		recalculateDimension(columCellPlaceHolder, screenSize);
		recalculateDimension(rowCellPlaceHolder, screenSize);
		super.recalculate(screenSize);
	}
	
	public void remove(int x, int y) {
		IUIPanel panel = childs[x][y];
		childs[x][y] = null;
		super.remove(panel);
	}
	
	public void add(IUIPanel panel, int x, int y) {
		if(childs[x][y] != null) {
			remove(x, y);
		}
		childs[x][y] = panel;
		super.add(panel);
		place(panel, x, y);
	}
	
	public void add(IUIPanel panel) {
		for (int y = 0; y < gridSize.y; y++) {
			for (int x = 0; x < gridSize.x; x++) {
				if(childs[x][y] == null) {
					add(panel, x, y);
					return;
				}
			}
		}
	}
	
	
	
	private void place(IUIPanel panel, int x, int y) {
		
		panel.getMaxWidth().reset().addPF(panelWidth).remove(columPlaceHolderPerCell);
		panel.getMinWidth().reset().addPF(panelWidth).remove(columPlaceHolderPerCell);
		
		panel.getMaxHeight().reset().addPF(panelHeight).remove(rowPlaceHolderPerCell);
		panel.getMinHeight().reset().addPF(panelHeight).remove(rowPlaceHolderPerCell);
		
		panel.getX().reset().addPF((float) 100f/gridSize.x * x).add(new ScaledScreenDimension(columPlaceHolderPerCell, x));
		panel.getY().reset().addPF((float) 100f/gridSize.y * y).add(new ScaledScreenDimension(rowPlaceHolderPerCell,  y));

		requestRecalculation(this);
	}
	
	

	public ScreenDimension getColumCellPlaceHolder() {
		return columCellPlaceHolder;
	}
	
	public ScreenDimension getRowsCellPlaceHolder() {
		return rowCellPlaceHolder;
	}

}
