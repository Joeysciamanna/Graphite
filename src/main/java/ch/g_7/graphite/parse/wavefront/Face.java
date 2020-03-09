package ch.g_7.graphite.parse.wavefront;

import ch.g_7.graphite.base.material.Material;

public class Face {
    
	private IndexGroup[] indexGroups = new IndexGroup[3];
    private Material material;
    
    public Face(String i1, String i2, String i3, Material material) {
        parseIndexGroup(i1, 0);
        parseIndexGroup(i2, 1);
        parseIndexGroup(i3, 2);
        this.material = material;
    }

    private void parseIndexGroup(String indexGroup, int storeIndex) {
       String[] tokens = indexGroup.split("/");
       indexGroups[storeIndex] = new IndexGroup(Integer.valueOf(tokens[0]) - 1,
    		   									Integer.valueOf(tokens[1].isBlank() ? "0" : tokens[1]) - 1,
    		   									Integer.valueOf(tokens[2].isBlank() ? "0" : tokens[2]) - 1);
    }

    public IndexGroup[] getIndexGroups() {
        return indexGroups;
    }

    public static class IndexGroup {
    	private int position, textCoord, normal;

    	public IndexGroup(int position, int textCoord, int normal) {
    		this.position = position;
    		this.textCoord = textCoord;
    		this.normal = normal;
    	}

        public int getNormal() {
            return normal;
        }

        public int getPosition() {
            return position;
        }

        public int getTextCoord() {
            return textCoord;
        }
    }

}




