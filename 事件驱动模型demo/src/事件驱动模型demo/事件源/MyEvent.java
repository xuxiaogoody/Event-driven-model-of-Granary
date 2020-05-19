package 事件驱动模型demo.事件源;

import 事件驱动模型demo.事件对象.Granary;

public class MyEvent {
	public Granary granary;

	public MyEvent(Granary granary) {
		super();
		this.granary = granary;
	}
	
	public Granary getResource() {
		return granary;
	}

}
