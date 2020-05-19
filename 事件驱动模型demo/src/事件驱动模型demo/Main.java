package �¼�����ģ��demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import �¼�����ģ��demo.�¼�����.Granary;
import �¼�����ģ��demo.�¼�Դ.MyEvent;
import �¼�����ģ��demo.��ע��.FOCUS;
import �¼�����ģ��demo.������.Worker;
import �¼�����ģ��demo.������.WorkerPool;
import �¼�����ģ��demo.�쳣.NullFocusPointException;
import �¼�����ģ��demo.������.MyListener;
import �¼�����ģ��demo.����ģʽ.Context;
/**
 * 
 * @author xuxiao
 * ����Ϊ��Ŀ��ע���¼���demo��Ҳ��ʵ��ִ�еĵ�һ��
 */
public class Main {
	/*
	 * ���ͻ���ѡ����Ӧ�Ĳֿ�͹�ע�㣬��ִ��ʱ�������������ע���¼�
	 * ע����ɺ�ͨ����ʱ�����̳߳�ִ�ж�ʱ������Ӳ������ָ��
	 */
	public static void main(String[] args) throws NullFocusPointException {
		//��ע����Ũ�ȣ�ʪ��Ϊ����ʵ���ɿͻ��˵�ѡ����ȡ��
		String[]str = {FOCUS.CONCENTRATION.getFocus(),FOCUS.HUMIDITY.getFocus()};
		//����ͻ���ѡ��1�Ųֿ⣨ʵ���ɿͻ��˵�ѡ����ȡ��
		Granary granary = new Granary(str,"һ�Ųֿ�",1);
		granary.registerListener(new MyListener() {	
			//��granary.excute����ʱ��ִ�����г���
			public void excute(MyEvent event) {
				Worker work = null;				
				Granary resource = event.getResource();//��òֿ����
				Integer id = resource.getId();//��òֿ�id
				String[] focus = resource.getFocus();//��øòֿ��ע�����
				//����focus��װ��Ӧ�Ĳ���ģʽ(head��body�Ļ�ȡ��ҵ���߼��У�demo�в�չʾ)
				Context context = new Context("head", "head");
				//���ݲֿ�id+��ע���WorkerPool�л�ȡ�����û���򴴽���Ӧ���������߳�
				for (String f : focus) {
					//�����ж�WorkerPool�д治����.keyδ�ֿ�id+��ע�¼�ƴ���ַ���
					work = WorkerPool.getPool(id+f);
					//���û�У��򴴽�һ����Ӧ��worker������workerPool
					if(work==null) {
						work=new Worker(context,id,f);
						WorkerPool.setWorker(id+f,work);
					}else {
						//�ַ�����,������ִ��
						work.submit(context);
					}
				}
			}
		});
		//ע����ɺ�ִ�ж�ʱ�������ע���й�ע�㷢��ָ��
		ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
		Runnable runnable = new Runnable() {		
			public void run() {
				//����WorkerPool��ȡ������ע����¼�
				//����ע���¼���װָ�����client.write����
				//ҵ�����...
			}
		};
		//��ʱ����20����һ��
		service.scheduleAtFixedRate(runnable, 0, 20, TimeUnit.MINUTES);
	}
	

}
