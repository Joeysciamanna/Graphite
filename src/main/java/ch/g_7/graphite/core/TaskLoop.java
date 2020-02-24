package ch.g_7.graphite.core;

import ch.g_7.util.loop.Loop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TaskLoop extends Loop {

    private List<Runnable> runnables;
    private Queue<Runnable> tasks;

    public TaskLoop() {
        this.runnables = new ArrayList<>();
        this.tasks = new LinkedList<>();
    }

    @Override
    protected void run(float v) {
        for (Runnable runnable : runnables) {
            runnable.run();
        }
        while (!tasks.isEmpty()) {
            tasks.poll().run();
        }
    }

    public synchronized void addRunnable(Runnable runnable){
        this.runnables.add(runnable);
    }

    public synchronized void addTask(Runnable runnable){
        this.tasks.add(runnable);
    }
}
