package �¼�����ģ��demo.�¼�����;

import �¼�����ģ��demo.�¼�Դ.MyEvent;
import �¼�����ģ��demo.�쳣.NullFocusPointException;
import �¼�����ģ��demo.������.MyListener;
/**
 * 
 * @author xuxiao
 *�ֿ�ģ�ͣ������ֿ������ֿ�id��ָ��ͷ����ע������
 */
public class Granary {
	private MyListener listener;
	private String[] focus;//��������Ũ�ȣ�ʪ�ȣ��¶ȣ��溦��
	private  String name;
	private  Integer id;
	private  final static String head="ָ��ͷ";//ָ��ͷ
		
	public Granary(String[] focus, String name, Integer id) throws NullFocusPointException {
		this.name = name;
		this.id = id;
		if(focus.length==0)
			throw new NullFocusPointException();
		this.focus = focus;
	}
	//��ù�ע��
	public String[] getFocus() {
		return focus;
	}	
	public Integer getId() {
		return id;
	}
	public void excute(String body) {
		//��Ӳ������ָ��
		//ƴ�Ӳֿ���+�ֿ�id+head+body
		//...
		String order = name+id+head+body;
		System.out.println(order);
		//��excute������ʱ���ص������ͻᱻ����
		listener.excute(new MyEvent(this));
	}
	public void registerListener(MyListener listener) {
		this.listener = listener;
	}

}
