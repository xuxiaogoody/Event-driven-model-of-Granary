package �¼�����ģ��demo.��ע��;
/**
 * 
 * @author xuxiao
 *  ��ע���ö��
 *
 */
public enum FOCUS {

	 CONCENTRATION (1,"����Ũ��"),

	 HUMIDITY(2,"����ʪ��"),

	 TEMPERATURE(3,"�����¶�");
	    private int seq;
	    private String foucs;
	    private FOCUS(int seq, String desc) {
	        this.seq = seq;
	        this.foucs = desc;
	    }
	    public int getSeq() {
	        return seq;
	    }
	    public String getFocus() {
	        return foucs;
	    }

}
