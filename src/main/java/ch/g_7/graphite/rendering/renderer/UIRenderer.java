package ch.g_7.graphite.rendering.renderer;

import java.util.List;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import ch.g_7.graphite.base.ui.IUIPanel;
import ch.g_7.graphite.base.ui.IUIRootContainer;
import ch.g_7.graphite.rendering.ITransformation;
import ch.g_7.graphite.rendering.shaderprogram.UIShaderProgram;

public class UIRenderer extends BasicRenderer<UIShaderProgram, IUIRootContainer> implements ITransformation<IUIPanel> {

	private Matrix4f viewMatrix;

	private IUIPanel panel;
	
	public UIRenderer() {
		super(new UIShaderProgram());
		viewMatrix = new Matrix4f();
	}

	@Override
	protected void renderAll(List<IUIRootContainer> renderables) {
		for (IUIRootContainer container : renderables) {
			if (container.isVisible()) {
				for (IUIPanel panel : container.getChilds()) {
					renderPanel(panel, this);
				}
			}
		}
	}

	protected void renderPanel(IUIPanel r, ITransformation<IUIPanel> transformation) {
	
		for (IUIPanel child : r.getChilds()) {
			if (child.isVisible()) {
				renderPanel(child, transformation);
			}
		}

		super.render(r, transformation);
	}


	
	@Override
	public void prepareFor(IUIPanel r) {
		this.panel = r;
	}

	
	@Override
	public Matrix4f getViewMatrix() {
		return viewMatrix.identity()
						  .translate(new Vector3f(panel.getPosition().x() - 1 , panel.getPosition().y()*-1 + 1, -1))
						  .scaleXY(panel.getSize().x(), panel.getSize().y());
	}

}
