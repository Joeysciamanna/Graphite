package ch.g_7.javaengine2d.texture;

import java.util.HashMap;
import java.util.Map;

public final class TexturePool {

	private static Map<String, Integer> textures = new HashMap<>();

	
	public static Integer get(String fullPath) {
		return textures.get(fullPath);

	}

	public static void set(String fullPath, int id) {
		textures.put(fullPath, id);
	}
	
}
