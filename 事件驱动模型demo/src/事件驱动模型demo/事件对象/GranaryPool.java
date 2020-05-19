package 事件驱动模型demo.事件对象;

import java.util.HashMap;
/**
 * 
 * @author xuxiao
 * 关注仓库池，硬件返回消息从这里找到相应的仓库类，并执行相应的方法
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
