package ch.g_7.graphite.rendering;

import ch.g_7.graphite.node.IViewModel;
import ch.g_7.graphite.node.INode;

import java.util.ArrayList;
import java.util.List;

public class RenderableList<T extends IViewModel> {

    private final List<INode<?,T>> viewModels;

    public RenderableList() {
        this.viewModels = new ArrayList<>();
    }

    public void sort(){

    }

    public void add(INode<?,T> viewModel){
        viewModels.add(viewModel);
    }

    public void remove(INode<?,T> viewModel){
        viewModels.remove(viewModel);
    }

    public List<INode<?,T>> getViewModels() {
        return viewModels;
    }
}
