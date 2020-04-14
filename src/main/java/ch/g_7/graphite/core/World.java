package ch.g_7.graphite.core;

import ch.g_7.graphite.node.IEntity;
import ch.g_7.graphite.node.IEntityIdentifier;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.rendering.RenderManager;
import ch.g_7.util.common.Closeable;
import ch.g_7.util.common.Initializable;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class World implements Initializable, Closeable {

    private final RenderManager renderManager;

    private final List<IEntity<?,?>> entities;


    public World() {
        this.renderManager = new RenderManager();
        this.entities = new ArrayList<>();
    }

    public void forEachEntity(Consumer<IEntity<?,?>> consumer){
        for (IEntity<?, ?> entity : entities) {
            consumer.accept(entity);
        }
    }

    public void saveForEachEntity(Consumer<IEntity<?,?>> consumer){
        for (IEntity<?, ?> entity : new ArrayList<>(entities)) {
            consumer.accept(entity);
        }
    }

    public List<IEntity<?, ?>> getEntitiesOfId(IEntityIdentifier<?> id) {
        List<IEntity<?, ?>> resultList = new ArrayList<>();
        for (IEntity<?, ?> entity : entities) {
            if(entity.getId().equals(id)){
                resultList.add(entity);
            }
        }
        return resultList;
    }

    public Optional<IEntity<?, ?>> getEntityOfId(IEntityIdentifier<?> id) {
        for (IEntity<?, ?> node : entities) {
            if(node.getId().equals(id)){
                return Optional.of(node);
            }
        }
        return Optional.empty();
    }

    public void addEntity(IEntity<?, ?> entity){
        entities.add(entity);
        renderManager.add(entity);
    }

    public void removeEntity(IEntity<?, ?> entity){
        entities.remove(entity);
        renderManager.remove(entity);
    }

    public void addNode(INode<?,?> node){
        renderManager.add(node);
    }

    public void removeNode(INode<?,?> node){
        renderManager.remove(node);
    }

    public void removeAll(){
        entities.clear();
        renderManager.clear();
    }

    @Override
    public void init() {
        renderManager.init();
    }

    @Override
    public void close() {
        removeAll();
        renderManager.close();
    }


    public RenderManager getRenderManager() {
        return renderManager;
    }
}
