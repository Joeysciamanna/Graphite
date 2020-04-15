package ch.g_7.graphite.xjfxi;

import ch.g_7.graphite.base.transform.IROTransform;
import ch.g_7.graphite.node.AbstractEntity;
import ch.g_7.graphite.node.IEntityId;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.IViewModel;
import ch.g_7.util.common.DynamicIdentifier;

public class JFXIObject extends AbstractEntity<INode<?,?>, IViewModel> {


    private static class JFXIObjectId extends DynamicIdentifier implements IEntityId {
        public JFXIObjectId(String name) {
            super(name);
        }
    }

    public JFXIObject() {
        super(new JFXIObjectId("jfxi_object"));
    }

    @Override
    public IViewModel getViewModel() {
        return null;
    }

    @Override
    public IROTransform getTransform() {
        return null;
    }

    @Override
    public void update(float deltaMillis) {

    }

    @Override
    public void close() {

    }
}
