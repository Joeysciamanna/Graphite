package ch.g_7.graphite.base.texture;

import ch.g_7.graphite.resource.IResourceKey;

public class ImageKey implements IResourceKey {
	
	public final static String NAME = "IMAGE";
	
	private String path;
	
	public ImageKey(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
	
	@Override
	public String getResourceName() {
		return NAME;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof ImageKey ? ((ImageKey)obj).path.equals(path) : false;
	}
}
