package 事件驱动模型demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import 事件驱动模型demo.事件对象.Granary;
import 事件驱动模型demo.事件源.MyEvent;
import 事件驱动模型demo.关注点.FOCUS;
import 事件驱动模型demo.处理器.Worker;
import 事件驱动模型demo.处理器.WorkerPool;
import 事件驱动模型demo.异常.NullFocusPointException;
import 事件驱动模型demo.监听器.MyListener;
import 事件驱动模型demo.策略模式.Context;
/**
 * 
 * @author xuxiao
 * 以下为项目中注册事件的demo，也是实际执行的第一步
 */
public class Main {
	/*
	 * 当客户端选择相应的仓库和关注点，并执行时，首先完成如下注册事件
	 * 注册完成后，通过定时任务线程池执行定时任务，向硬件发送指令
	 */
	public static void main(String[] args) throws NullFocusPointException {
		//关注点以浓度，湿度为例（实际由客户端的选择框获取）
		String[]str = {FOCUS.CONCENTRATION.getFocus(),FOCUS.HUMIDITY.getFocus()};
		//假设客户端选择1号仓库（实际由客户端的选择框获取）
		Granary granary = new Granary(str,"一号仓库",1);
		granary.registerListener(new MyListener() {	
			//当granary.excute发生时，执行下列程序
			public void excute(MyEvent event) {
				Worker work = null;				
				Granary resource = event.getResource();//获得仓库对象
				Integer id = resource.getId();//获得仓库id
				String[] focus = resource.getFocus();//获得该仓库关注点对象
				//根据focus封装相应的策略模式(head和body的获取在业务逻辑中，demo中不展示)
				Context context = new Context("head", "head");
				//根据仓库id+关注点从WorkerPool中获取，如果没有则创建相应到处理器线程
				for (String f : focus) {
					//首先判断WorkerPool中存不存在.key未仓库id+关注事件拼接字符串
					work = WorkerPool.getPool(id+f);
					//如果没有，则创建一个相应的worker，加入workerPool
					if(work==null) {
						work=new Worker(context,id,f);
						WorkerPool.setWorker(id+f,work);
					}else {
						//分发任务,处理器执行
						work.submit(context);
					}
				}
			}
		});
		//注册完成后，执行定时任务，向关注仓中关注点发送指令
		ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
		Runnable runnable = new Runnable() {		
			public void run() {
				//遍历WorkerPool，取出所有注册的事件
				//根据注册事件封装指令，调用client.write（）
				//业务代码...
			}
		};
		//定时任务20分钟一次
		service.scheduleAtFixedRate(runnable, 0, 20, TimeUnit.MINUTES);
	}
	

}
