package 事件驱动模型demo.监听器;

import 事件驱动模型demo.事件源.MyEvent;
/**
 * 
 * @author xuxiao
 * 监听器接口
 *
 */
public interface MyListener {
	
	public void excute(MyEvent event);

}
