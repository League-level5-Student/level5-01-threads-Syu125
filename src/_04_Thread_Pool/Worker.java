package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker extends Thread implements Runnable,  Task{
	ConcurrentLinkedQueue<Task>taskQueue;
	public Worker(){

	}
	public Worker(ConcurrentLinkedQueue<Task> taskQueue){
		this.taskQueue = taskQueue;
	}
	@Override
	public void run() {
		System.out.println(taskQueue.isEmpty());
		while(!taskQueue.isEmpty()){
			taskQueue.remove().perform();
		}
		
	}

	@Override
	public void perform() {
		
	}


}
