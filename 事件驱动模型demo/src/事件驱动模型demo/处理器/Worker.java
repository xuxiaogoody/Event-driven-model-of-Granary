package �¼�����ģ��demo.������;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author xuxiao
 *����ִ���������
 */
public class Worker implements Runnable{
	private Integer granaryID;
	private String foucs;
	final Thread thread;
	Runnable firstTask;
	private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
	public Worker(Runnable firstTask,Integer granaryID, String foucs) {
		this.firstTask = firstTask;
		this.granaryID = granaryID;
		this.foucs = foucs;
		thread = new Thread(this);
	}	
	/*
	 * ��ȡ��Worker�߳�����ص�����id
	 */
	public Integer getGranaryID() {
		return granaryID;
	}
	/*
	 * ��ȡ��Worker�߳�����ص����ֹ�ע��
	 */
	public String getFoucs() {
		return foucs;
	}

	public void run() {
		runWorker(this);		
	}
    
	private void runWorker(Worker w) {
		Runnable task = w.firstTask;
		w.firstTask = null;
		while (task != null || (task = getTask()) != null) {
			task.run();
		}

	}
	private Runnable getTask() {
		try {
			return queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean submit(Runnable r) {
		return queue.add(r);
	}
	

}
