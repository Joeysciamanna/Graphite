package ch.g_7.graphite.resource;

import ch.g_7.util.helper.Util;

public abstract class NamedKey implements IResourceKey {

	private String name;
	
	public NamedKey(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		return Util.isEqual(this, obj, NamedKey::getName, NamedKey::getResourceName);
	}
}
