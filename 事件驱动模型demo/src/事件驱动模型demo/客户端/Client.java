package �¼�����ģ��demo.�ͻ���;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import �¼�����ģ��demo.�¼�����.Granary;
import �¼�����ģ��demo.�¼�����.GranaryPool;

public class Client {
	Socket socket;
	InputStream inputStream;
	OutputStream outputStream;
	//socket����...
	
	/**
	 * ͨ��һ���߳�ִ��read��ѭ��
	 */
	public void read() {
		byte[] b = new byte[1024];
		while(true) {
			try {
				int len = inputStream.read();
				String r = new String(b,0,len);
				//�ַ���תjson��װ��bean�������Ϣ����Ϣͷ�е�id+focus��demo�;���rΪ��
				Granary granary = GranaryPool.getGranary(r);
				if(granary==null) {
					System.out.println("��������");//Ӳ����������
				}else {
					granary.excute(r);//�������ݣ������ص�,���̿�ʼ
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void write(String order) {
		//ͨ����ʱ����ִ�ж�ʱ���ע�㷢��ָ��
		//ҵ����벻������
	}

}
