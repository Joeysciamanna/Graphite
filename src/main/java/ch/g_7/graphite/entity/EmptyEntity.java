package ch.g_7.graphite.entity;

import ch.g_7.graphite.node.IEntityIdentifier;
import ch.g_7.graphite.rendering.BasicViewModel;

public class EmptyEntity extends GameObject<BasicViewModel> {

	public EmptyEntity(IEntityIdentifier<?> id, BasicViewModel viewModel) {
		super(id, viewModel);
	}
}
