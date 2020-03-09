//package ch.g_7.graphite.ui.layout;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.joml.Vector2ic;
//
//import ch.g_7.graphite.ui.IUIPanel;
//import ch.g_7.graphite.ui.UIPanel;
//import ch.g_7.graphite.ui.util.ScaledScreenDimension;
//import ch.g_7.graphite.ui.util.ScreenDimension;
//
//public class ListLayoutPanel extends UIPanel {
//
//	public static final byte X_AXIS = 0;
//	public static final byte Y_AXIS = 1;
//
//	private ScreenDimension placeHolder;
//
//	private byte axis;
//
//
//	public ListLayoutPanel(byte axis) {
//		this.axis = axis;
//		this.childs = new ArrayList<>();
//		this.placeHolder = new ScreenDimension(axis);
//	}
//
//
//	@Override
//	public void recalculate(Vector2ic screenSize, Vector2ic fatherSize) {
//		recalculateDimension(placeHolder, screenSize);
//		super.recalculate(screenSize, fatherSize);
//	}
//
//	@Override
//	public void add(IUIPanel panel) {
//		super.add(panel);
//		place(panel, childs.size()-1);
//	}
//
//
//	private void place(IUIPanel panel, int index) {
//		panel.getMaxWidth().reset().addPF(100);
//		panel.getMaxHeight().reset().addPF(100);
//		panel.getMinWidth().reset();
//		panel.getMinHeight().reset();
//		panel.getX().reset();
//		panel.getY().reset();
//		List<IUIPanel> bofore = childs.stream().limit(index).collect(Collectors.toList());
//		if(axis == X_AXIS) {
//			bofore.forEach((p)-> panel.getX().add(p.getWidth()));
//			panel.getX().add(new ScaledScreenDimension(placeHolder, index));
//			panel.getMinHeight().reset().addPF(100);
//
//		} else {
//			bofore.forEach((p)-> panel.getY().add(p.getHeight()));
//			panel.getY().add(new ScaledScreenDimension(placeHolder, index));
//			panel.getMinWidth().reset().addPF(100);
//		}
//		requestRecalculation(this);
//	}
//
//
//
//	public ScreenDimension getPlaceHolder() {
//		return placeHolder;
//	}
//}
