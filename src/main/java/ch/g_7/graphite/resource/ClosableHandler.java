package ch.g_7.graphite.resource;

import ch.g_7.util.common.Closeable;

import java.util.ArrayList;
import java.util.List;


public class ClosableHandler {

    private final static List<ClosableHandler> CLOSABLE_HANDLERS = new ArrayList<>();
    private static ClosableHandler active = enable("DEFAULT");

    private List<Closeable> closeables;
    private String name;

    private ClosableHandler(String name) {
        this.name = name;
        this.closeables = new ArrayList<>();
    }

    public void free(){
        for (Closeable closeable : closeables) {
            closeable.close();
        }
        closeables.clear();
    }

    public void add(Closeable closeable){
        closeables.add(closeable);
    }




    public static ClosableHandler get(String name){
        for (ClosableHandler closableHandler : CLOSABLE_HANDLERS) {
            if(closableHandler.name.equals(name)){
                return closableHandler;
            }
        }
        throw new IllegalArgumentException("No ClosableHandler wit name ["+name+"]");
    }

    public static ClosableHandler getActive(){
        return active;
    }

    public static ClosableHandler enable(String name){
        for (ClosableHandler closableHandler : CLOSABLE_HANDLERS) {
            if(closableHandler.name.equals(name)){
                return active = closableHandler;
            }
        }
        return active = new ClosableHandler(name);
    }

}
