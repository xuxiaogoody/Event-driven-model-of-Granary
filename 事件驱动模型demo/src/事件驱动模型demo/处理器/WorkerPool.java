package 事件驱动模型demo.处理器;

import java.util.HashMap;

/**
 * 
 * @author xuxiao
 * 存储已进入工作的Worker池
 * 当有新任务来临，注册事件需要先从该池中尝试取出相应的Worker
 * 取不到则创建，并加入池中
 *
 */
public class WorkerPool {
	private static HashMap<String,Worker> pool = new HashMap<String,Worker>();
    //取出
	public static Worker getPool(String key) {
		return pool.getOrDefault(key, null);
	}
     //入池
	public static void setWorker(String key,Worker value) {
		pool.put(key, value);
	}
	

}
