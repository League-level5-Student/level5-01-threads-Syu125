package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker extends Thread implements Runnable,  Task{
	ConcurrentLinkedQueue<Task>taskQueue;
	
	public Worker(ConcurrentLinkedQueue<Task> taskQueue){
		this.taskQueue = taskQueue;
	}
	public Worker(){

	}
	@Override
	public void run() {
		while(!taskQueue.isEmpty()){
			taskQueue.remove().perform();
		}
		
	}

	@Override
	public void perform() {
		
	}


}
