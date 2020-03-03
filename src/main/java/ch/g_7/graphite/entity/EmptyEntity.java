package ch.g_7.graphite.entity;

import ch.g_7.graphite.base.transformation.ITransformation;
import ch.g_7.graphite.base.view_model.IViewModel;

import java.util.List;

public class EmptyEntity implements IEntity {


    @Override
    public IViewModel getViewModel() {
        return null;
    }

    @Override
    public ITransformation getTransformation() {
        return null;
    }

    @Override
    public void update(float deltaMillis) {

    }

    @Override
    public void close() { }

    @Override
    public List<IEntity> getChildren() {
        return null;
    }

    public void add(IEntity entity){

    }

}
