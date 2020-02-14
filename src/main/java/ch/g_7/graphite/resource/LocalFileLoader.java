package ch.g_7.graphite.resource;


import java.io.File;


public class LocalFileLoader implements IFileLoader {

    @Override
    public File loadFile(String path) {
        return new File(getClass().getResource("/" + path).getFile());
    }
}
