package ch.g_7.graphite.core;

import ch.g_7.graphite.node.*;
import ch.g_7.graphite.rendering.RenderManager;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;
import ch.g_7.util.listener.Event;
import ch.g_7.util.listener.IListener;
import ch.g_7.util.listener.Notifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class World implements Initializable, Closeable, Updatable {

    private final Notifier<WorldEvent> onAddNotifier;
    private final Notifier<WorldEvent> onRemoveNotifier;

    private final List<INode<?,?>> nodes;


    public World() {
        this.onAddNotifier = new Notifier<>();
        this.onRemoveNotifier = new Notifier<>();

        this.nodes = new ArrayList<>();
    }

    @Override
    public void update(float deltaMillis) {
        onAddNotifier.reportAll();
        onRemoveNotifier.reportAll();
    }

    public List<IEntity<?, ?>> getEntitiesWithId(IEntityId id) {
        List<IEntity<?, ?>> resultList = new ArrayList<>();
        for (INode<?, ?> node : nodes) {
            if((node.getAbilities() & Identifiable.ABILITY) != 0 && ((IEntity<?,?>)node).getId().equals(id)){
                resultList.add((IEntity<?, ?>) node);
            }
        }
        return resultList;
    }

    public Optional<IEntity<?, ?>> getEntityWithId(IEntityId id) {
        for (INode<?, ?> node : nodes) {
            if((node.getAbilities() & Identifiable.ABILITY) != 0 && ((IEntity<?,?>)node).getId().equals(id)){
                return Optional.of((IEntity<?, ?>) node);
            }
        }
        return Optional.empty();
    }

    public List<INode<?, ?>> getNodesWithAbility(int ability) {
        List<INode<?, ?>> resultList = new ArrayList<>();
        for (INode<?, ?> node : nodes) {
            if((node.getAbilities() & ability) != 0){
                resultList.add(node);
            }
        }
        return resultList;
    }

    public void addNode(INode<?,?> node){
        nodes.add(node);
        onAddNotifier.register(new WorldEvent(node));
    }

    public void removeNode(INode<?,?> node){
        nodes.remove(node);
        onRemoveNotifier.register(new WorldEvent(node));
    }

    public void removeAll(){
        for (INode<?, ?> node : new ArrayList<>(nodes)) {
            node.close();
            removeNode(node);
        }
    }

    @Override
    public void init() { }

    @Override
    public void close() {
        removeAll();
    }

    public void onAdd(IListener<WorldEvent> listener) {
        onAddNotifier.addListner(listener);
    }

    public void onRemove(IListener<WorldEvent> listener) {
        onRemoveNotifier.addListner(listener);
    }

    public static class WorldEvent extends Event{

        private final INode<?, ?> node;

        private WorldEvent(INode<?, ?> node) {
            this.node = node;
        }

        public INode<?, ?> getNode() {
            return node;
        }
    }
}
