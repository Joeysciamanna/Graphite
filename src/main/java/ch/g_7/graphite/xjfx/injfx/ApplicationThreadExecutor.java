package ch.g_7.graphite.xjfx.injfx;


import java.util.ArrayList;
import java.util.List;

/**
 * The executor for executing tasks in application thread.
 *
 * @author JavaSaBr
 */
public class ApplicationThreadExecutor {

    private static final ApplicationThreadExecutor INSTANCE = new ApplicationThreadExecutor();

    public static ApplicationThreadExecutor getInstance() {
        return INSTANCE;
    }

    /**
     * The list of waiting tasks.
     */
    private final List<Runnable> waitTasks;

    /**
     * The list of tasks to execute.
     */
    private final List<Runnable> execute;

    private ApplicationThreadExecutor() {
        this.waitTasks = new ArrayList<>();
        this.execute = new ArrayList<>();
    }

    /**
     * Add the task to execute.
     *
     * @param task the new task.
     */
    public void addToExecute(Runnable task) {
        waitTasks.add(task);
    }

    /**
     * Execute the waiting tasks.
     */
    public void execute() {
        if (waitTasks.isEmpty()) {
            return;
        }
        execute.addAll(waitTasks);
        try {
            execute.forEach(Runnable::run);
        } finally {
            execute.clear();
        }
    }
}
