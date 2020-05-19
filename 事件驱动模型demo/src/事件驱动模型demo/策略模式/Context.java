package �¼�����ģ��demo.����ģʽ;

/**
 * ִ�в�����
 * @author xuxiao
 *
 */
public class Context implements Runnable{
	   private Strategy strategy;	   
	   private String head;
	   private String body;
	   
	   public Context(String head, String body) {
		super();
		this.head = head;
		this.body = body;
	}
	public void SetStrategy(Strategy strategy){
	      this.strategy = strategy;
	   }
	   public void executeStrategy(String s1, String s2){
	      strategy.doOperation(s1,s2);
	   }
	public void run() {
		executeStrategy(head,body);
		
	}
}
