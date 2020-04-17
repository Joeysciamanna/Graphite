package ch.g_7.graphite.xjfxi;

import ch.g_7.graphite.base.texture.ITexture;
import ch.g_7.graphite.base.transform.IROTransform;
import ch.g_7.graphite.base.transform.Transform;
import ch.g_7.graphite.node.AbstractEntity;
import ch.g_7.graphite.node.IEntityId;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.IViewModel;
import ch.g_7.graphite.rendering.IRenderType;
import ch.g_7.graphite.rendering.RenderType;
import ch.g_7.util.common.DynamicIdentifier;

public class JFXIStageContainer extends AbstractEntity<INode<?,?>, IViewModel> {

    private final ViewModel viewModel;
    private final Transform transform;

    public JFXIStageContainer(ITexture texture) {
        super(new JFXIObjectId("jfxi_object"));
        this.viewModel = new ViewModel(texture);
        this.transform = new Transform();
    }

    @Override
    public IViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public IROTransform getTransform() {
        return transform;
    }

    @Override
    public void update(float deltaMillis) { }

    @Override
    public void close() { }

    public void setTexture(ITexture texture){
        viewModel.setTexture(texture);
    }



    private static class JFXIObjectId extends DynamicIdentifier implements IEntityId {
        public JFXIObjectId(String name) {
            super(name);
        }
    }

    private static class ViewModel implements IViewModel {

        private ITexture texture;

        public ViewModel(ITexture texture) {
            this.texture = texture;
        }

        @Override
        public IRenderType<?> getRenderType() {
            return RenderType.JFXI;
        }

        @Override
        public void bind() {
            texture.bind();
        }

        @Override
        public void unbind() {
            texture.unbind();
        }

        public void setTexture(ITexture texture) {
            this.texture = texture;
        }
    }
}
