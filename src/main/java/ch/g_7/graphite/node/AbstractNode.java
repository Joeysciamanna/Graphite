package ch.g_7.graphite.node;

import ch.g_7.graphite.base.transform.IROTransform;
import ch.g_7.util.bitkey.BitKey;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNode<T extends INode<?, ?>, R extends IViewModel> implements INode<T, R> {

    private final int abilities;
    private final List<T> children;

    public AbstractNode(int abilities) {
        this.abilities = abilities;
        this.children = new ArrayList<>();
    }

    public AbstractNode() {
        this(Renderable.ABILITY);
    }

    @Override
    public int getAbilities() {
        return abilities;
    }

    @Override
    public List<? extends T> getChildren() {
        return children;
    }

}
