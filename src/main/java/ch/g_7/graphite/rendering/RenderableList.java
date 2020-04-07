package ch.g_7.graphite.rendering;

import ch.g_7.graphite.node.IViewModel;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.Renderable;

import java.util.ArrayList;
import java.util.List;

public class RenderableList<T extends IViewModel> {

    private final List<Renderable< T>> viewModels;

    public RenderableList() {
        this.viewModels = new ArrayList<>();
    }

    public void sort(){

    }

    public void add(Renderable<T> viewModel){
        viewModels.add(viewModel);
    }

    public void remove(Renderable<T> viewModel){
        viewModels.remove(viewModel);
    }

    public void clear(){
        viewModels.clear();
    }

    public List<Renderable<T>> getViewModels() {
        return viewModels;
    }
}
