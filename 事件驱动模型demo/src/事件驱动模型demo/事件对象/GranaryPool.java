package �¼�����ģ��demo.�¼�����;

import java.util.HashMap;
/**
 * 
 * @author xuxiao
 * ��ע�ֿ�أ�Ӳ��������Ϣ�������ҵ���Ӧ�Ĳֿ��࣬��ִ����Ӧ�ķ���
 *
 */
public class GranaryPool {
    private static HashMap<String,Granary> pool = new HashMap<String,Granary>();
    public static void set(String key,Granary value) {
    	pool.put(key, value);
    }
    public static Granary getGranary(String key) {
    	return pool.getOrDefault(key, null);
    }

}
