package ch.g_7.graphite.entity;

import ch.g_7.graphite.node.INodeIdentifier;
import ch.g_7.graphite.rendering.BasicViewModel;

public class EmptyEntity extends Entity<BasicViewModel> {

	public EmptyEntity(INodeIdentifier<?> id, BasicViewModel viewModel) {
		super(id, viewModel);
	}
}
