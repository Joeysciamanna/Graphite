package ch.g_7.graphite.resource;

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
		return obj instanceof NamedKey ? ((NamedKey)obj).name.equals(name) : false;
	}
}
