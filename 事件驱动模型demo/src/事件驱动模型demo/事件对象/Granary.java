package 事件驱动模型demo.事件对象;

import 事件驱动模型demo.事件源.MyEvent;
import 事件驱动模型demo.异常.NullFocusPointException;
import 事件驱动模型demo.监听器.MyListener;
/**
 * 
 * @author xuxiao
 *仓库模型，包括仓库名，仓库id，指令头，关注点数组
 */
public class Granary {
	private MyListener listener;
	private String[] focus;//包括气体浓度，湿度，温度，虫害等
	private  String name;
	private  Integer id;
	private  final static String head="指令头";//指令头
		
	public Granary(String[] focus, String name, Integer id) throws NullFocusPointException {
		this.name = name;
		this.id = id;
		if(focus.length==0)
			throw new NullFocusPointException();
		this.focus = focus;
	}
	//获得关注点
	public String[] getFocus() {
		return focus;
	}	
	public Integer getId() {
		return id;
	}
	public void excute(String body) {
		//给硬件发送指令
		//拼接仓库名+仓库id+head+body
		//...
		String order = name+id+head+body;
		System.out.println(order);
		//当excute被调用时，回调方法就会被调用
		listener.excute(new MyEvent(this));
	}
	public void registerListener(MyListener listener) {
		this.listener = listener;
	}

}
