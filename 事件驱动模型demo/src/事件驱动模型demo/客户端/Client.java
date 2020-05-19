package 事件驱动模型demo.客户端;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import 事件驱动模型demo.事件对象.Granary;
import 事件驱动模型demo.事件对象.GranaryPool;

public class Client {
	Socket socket;
	InputStream inputStream;
	OutputStream outputStream;
	//socket连接...
	
	/**
	 * 通过一个线程执行read死循环
	 */
	public void read() {
		byte[] b = new byte[1024];
		while(true) {
			try {
				int len = inputStream.read();
				String r = new String(b,0,len);
				//字符串转json封装成bean，获得消息中消息头中的id+focus，demo就就以r为例
				Granary granary = GranaryPool.getGranary(r);
				if(granary==null) {
					System.out.println("丢弃数据");//硬件处理有误
				}else {
					granary.excute(r);//处理数据，触发回调,流程开始
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void write(String order) {
		//通过定时任务执行定时向关注点发送指令
		//业务代码不在叙述
	}

}
