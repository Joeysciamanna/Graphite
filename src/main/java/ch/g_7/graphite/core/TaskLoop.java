package ch.g_7.graphite.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ch.g_7.graphite.node.Updatable;
import ch.g_7.util.loop.Loop;

public class TaskLoop extends Loop {

    private List<Updatable> updatables;
    private Queue<Updatable> tasks;

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
            tasks.poll().update(deltaMillis);
        }
    }

    public synchronized void addUpdatable(Updatable updatable){
        this.updatables.add(updatable);
    }

    public synchronized void addTask(Updatable runnable){
        this.tasks.add(runnable);
    }
}
