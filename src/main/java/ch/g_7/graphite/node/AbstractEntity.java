package ch.g_7.graphite.node;

import ch.g_7.graphite.base.transform.IROTransform;
import ch.g_7.util.bitkey.BitKey;

import javax.swing.text.FieldView;

public abstract class AbstractEntity<T extends INode<?, ?>, R extends IViewModel> extends AbstractNode<T, R> implements IEntity<T, R> {

    private final IEntityId id;

    public AbstractEntity(IEntityId id, int abilities) {
        super(abilities);
        this.id = id;
    }

    public AbstractEntity(IEntityId id) {
        this(id, Updatable.ABILITY | Renderable.ABILITY | Identifiable.ABILITY);
    }

    @Override
    public IEntityId getId() {
        return id;
    }

}
