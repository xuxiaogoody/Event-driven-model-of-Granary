package 事件驱动模型demo.关注点;
/**
 * 
 * @author xuxiao
 *  关注点的枚举
 *
 */
public enum FOCUS {

	 CONCENTRATION (1,"气体浓度"),

	 HUMIDITY(2,"空气湿度"),

	 TEMPERATURE(3,"环境温度");
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
