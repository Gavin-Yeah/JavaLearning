package NetStudy.com.jiada.udp;
/**
 * 加入多线程，实现双向交流 模拟在线咨询
 * @author jiadaye
 *
 */
public class TalkStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new TalkSend(7777, "localhost", 9999)).start();
		new Thread(new TalkReceive(8888,"老师")).start();//接收
	}

}
