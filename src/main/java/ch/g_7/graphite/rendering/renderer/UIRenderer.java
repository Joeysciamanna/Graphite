package ch.g_7.graphite.rendering.renderer;

import java.util.List;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import ch.g_7.graphite.core.Camera;
import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.rendering.ITransformation;
import ch.g_7.graphite.rendering.shaderprogram.UIShaderProgram;
import ch.g_7.graphite.ui.IUIPanel;
import ch.g_7.graphite.ui.IUIRootContainer;

public class UIRenderer extends BasicRenderer<UIShaderProgram, IUIRootContainer, IUIPanel> {
	
	public UIRenderer() {
		super(new UIShaderProgram(), new Transformation());
	}

	
	@Override
	protected void renderAll(List<IUIRootContainer> renderables) {
		for (IUIRootContainer container : renderables) {
			if (container.isVisible()) {
				for (IUIPanel panel : container.getChilds()) {
					renderPanel(panel);
				}
			}
		}
	}

	protected void renderPanel(IUIPanel r) {
		for (IUIPanel child : r.getChilds()) {
			if (child.isVisible()) {
				renderPanel(child);
			}
		}
		super.render(r);
	}

	
	private static class Transformation implements ITransformation<IUIPanel>{
		
		private Matrix4f projectionMatrix;
		private Matrix4f modelViewMatrix;
		
		public Transformation() {
			projectionMatrix = new Matrix4f();
			modelViewMatrix = new Matrix4f();
		}
		
		@Override
		public Matrix4f getProjectionMatrix(Window window, Camera camera) {
			return projectionMatrix;
		}
		
		@Override
		public Matrix4f getModelViewMatrix(IUIPanel panel) {
			return modelViewMatrix.identity()
					  .translate(new Vector3f(panel.getPosition().x() - 1 , panel.getPosition().y()*-1 + 1, -1))
					  .scaleXY(panel.getSize().x(), panel.getSize().y());
		}

	}
	

}
