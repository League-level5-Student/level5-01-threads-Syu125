package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool extends Worker{
    Thread[] threads;
    ConcurrentLinkedQueue<Task> taskQueue;
    
    public ThreadPool(int totalThreads) {
        threads = new Thread[totalThreads];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Worker(taskQueue);
        }
        taskQueue = new ConcurrentLinkedQueue<Task>();
    }

    public void addTask(Task task) {
        taskQueue.add(task);
    }

    public void start() {
        for (Thread thread : threads) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
    }

}
