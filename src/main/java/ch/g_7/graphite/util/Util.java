package ch.g_7.graphite.util;

import java.util.function.Function;

public class Util {

    @SafeVarargs
	public static <T> boolean isEqual(T self, Object o, Function<T,Object>... extractors) {
    	if(self == o) return true;
    	if(!self.getClass().equals(o.getClass())) return false;
    	
    	@SuppressWarnings("unchecked")
		T obj = (T) o;
    	for (Function<T, Object> extractor : extractors) {
			if(!extractor.apply(self).equals(extractor.apply(obj))) return false;
		}
    	return true;
    }
}
