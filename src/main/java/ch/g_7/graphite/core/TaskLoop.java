package ch.g_7.graphite.core;

import ch.g_7.graphite.node.Updatable;
import ch.g_7.util.loop.Loop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TaskLoop extends Loop {

    private List<Updatable> updatables;
    private Queue<Runnable> tasks;

    public TaskLoop() {
        this.updatables = new ArrayList<>();
        this.tasks = new LinkedList<>();
    }

    @Override
    protected synchronized void run(float deltaMillis) {
        for (Updatable updatable : updatables) {
			updatable.update(deltaMillis);
		}
        while (!tasks.isEmpty()) {
            tasks.poll().run();
        }
    }

    public synchronized void addUpdatable(Updatable updatable){
        this.updatables.add(updatable);
    }

    public synchronized void addTask(Runnable runnable){
        this.tasks.add(runnable);
    }
}
