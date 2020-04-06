package ch.g_7.graphite.rendering.ui;//package ch.g_7.graphite.rendering.ui;
//
//import java.util.List;
//
//import org.lwjgl.opengl.GL11;
//
//import ch.g_7.graphite.rendering.BasicRenderer;
//import ch.g_7.graphite.rendering.BasicShaderProgram;
//import ch.g_7.graphite.rendering.transformator.PixelTransformator;
//import ch.g_7.graphite.ui.IUIPanel;
//import ch.g_7.graphite.ui.IUIRootContainer;
//import ch.g_7.graphite.util.Resources;
//
///**
// * TODO refactor ui rendering put all in shader programm -> performance
// * @author Joey Sciamanna
// *
// */
//public class UIRenderer extends BasicRenderer<IUIRootContainer> {
//
//	public UIRenderer() {
//		super(new BasicShaderProgram(Resources.UI_VERTEX_SHADER, Resources.UI_FRAGMENT_SHADER), new PixelTransformator());
//	}
//
//
//	@Override
//	public void render(List<? extends IUIRootContainer> rootContainers) {
//		for (IUIRootContainer container : rootContainers) {
//			if (container.isVisible()) {
//				for (IUIPanel panel : container.getChilds()) {
//					renderPanel(panel);
//				}
//			}
//		}
//	}
//
//
//	protected void renderPanel(IUIPanel panel) {
//		for (IUIPanel child : panel.getChilds()) {
//			if (child.isVisible()) {
//				renderPanel(child);
//			}
//		}
//		render(panel, GL11.GL_TRIANGLES);
//	}
//
//
//}
