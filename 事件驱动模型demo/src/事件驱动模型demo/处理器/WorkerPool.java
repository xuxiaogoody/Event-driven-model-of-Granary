package �¼�����ģ��demo.������;

import java.util.HashMap;

/**
 * 
 * @author xuxiao
 * �洢�ѽ��빤����Worker��
 * �������������٣�ע���¼���Ҫ�ȴӸó��г���ȡ����Ӧ��Worker
 * ȡ�����򴴽������������
 *
 */
public class WorkerPool {
	private static HashMap<String,Worker> pool = new HashMap<String,Worker>();
    //ȡ��
	public static Worker getPool(String key) {
		return pool.getOrDefault(key, null);
	}
     //���
	public static void setWorker(String key,Worker value) {
		pool.put(key, value);
	}
	

}
