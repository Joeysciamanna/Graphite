package ch.g_7.graphite.util;

import java.util.HashMap;
import java.util.Map;

public final class ResourceHandler {

	private final static Map<Object, Counter> resources = new HashMap<>();;

	private ResourceHandler() {}

	public static boolean shallInitialize(Object object) {
		if (resources.containsKey(object)) {
			resources.get(object).increase();
			return false;
		} else {
			resources.put(object, new Counter().increase());
			return true;
		}

	}

	public static boolean shallClose(Object object) {
		if (!resources.containsKey(object)) {
			throw new IllegalStateException("Resource " + object + " was never registerd/initialized");
		} else {
			if (resources.get(object).decrease().getValue() == 0) {
				resources.remove(object);
				return true;
			}
			return false;
		}
	}

	public static boolean hasOpenedResources() {
		return !resources.isEmpty();
	}

	public static void printResources() {
		resources.forEach((r, c) -> {
			System.out.println(c.getValue() + "x\t" + r.getClass().getSimpleName());
		});
	}
	
	@Deprecated
	public static void closeAll() {
		resources.forEach((r, c) -> {
			if (resources instanceof AutoCloseable) {
				try {
					((AutoCloseable) resources).close();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
	}

}
