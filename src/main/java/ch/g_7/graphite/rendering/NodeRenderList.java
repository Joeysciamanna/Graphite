package ch.g_7.graphite.rendering;

import ch.g_7.graphite.node.IViewModel;
import ch.g_7.graphite.node.INode;
import ch.g_7.graphite.node.Renderable;

import java.util.ArrayList;
import java.util.List;

public class NodeRenderList<T extends INode<?, ?>> {

    private final List<T> viewModels;

    public NodeRenderList() {
        this.viewModels = new ArrayList<>();
    }


    public void add(T viewModel){
        viewModels.add(viewModel);
    }

    public void remove(T viewModel){
        viewModels.remove(viewModel);
    }

    public void clear(){
        viewModels.clear();
    }

    public boolean isEmpty(){
        return viewModels.isEmpty();
    }

    public List<T> getViewModels() {
        return viewModels;
    }
}
