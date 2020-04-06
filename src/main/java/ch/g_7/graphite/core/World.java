package ch.g_7.graphite.core;

import ch.g_7.graphite.entity.IEntity;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.INodeIdentifier;
import ch.g_7.graphite.rendering.RenderManager;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class World implements Initializable, Closeable {

    private final RenderManager renderManager;
    private final List<INode<?, ?>> nodes;

    public World() {
        this.renderManager = new RenderManager();
        this.nodes = new ArrayList<>();
    }

    public List<INode<?,?>> getNodesOfId(INodeIdentifier<?> id) {
        List<INode<?,?>> resultList = new ArrayList<>();
        for (INode<?, ?> node : nodes) {
            if(node.getId().equals(id)){
                resultList.add(node);
            }
        }
        return resultList;
    }

    public Optional<INode<?,?>> getNodeOfId(INodeIdentifier<?> id) {
        for (INode<?, ?> node : nodes) {
            if(node.getId().equals(id)){
                return Optional.of(node);
            }
        }
        return Optional.empty();
    }

    public void add(INode<?,?> node){
        nodes.add(node);
        renderManager.add(node);
    }

    public void remove(INode<?,?> node){
        nodes.remove(node);
        renderManager.add(node);
    }

    public void removeAll(){
        nodes.clear();
    }

    @Override
    public void init() {
        renderManager.init();
    }

    @Override
    public void close() {
        renderManager.close();
    }

    public List<INode<?, ?>> getNodes() {
        return nodes;
    }

    public RenderManager getRenderManager() {
        return renderManager;
    }
}
