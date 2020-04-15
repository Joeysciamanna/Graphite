package ch.g_7.graphite.entity;

import ch.g_7.graphite.node.IEntityId;
import ch.g_7.graphite.rendering.BasicViewModel;

public class EmptyEntity extends GameObject<BasicViewModel> {

	public EmptyEntity(IEntityId id, BasicViewModel viewModel) {
		super(id, viewModel);
	}
}
