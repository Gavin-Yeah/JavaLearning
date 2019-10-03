package Thread.a1.src.com.jiada.thread.state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep 模拟倒计时
 * @author jiadaye
 *
 */
public class BlockedSleep3 {
	public static void main(String[] args) {
		//倒计时
		Date endTime=new Date(System.currentTimeMillis()+1000*10);
		long end=endTime.getTime();
		while(true) {
			try {
				System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
				Thread.sleep(1000);
				endTime= new Date(endTime.getTime()-1000);
			
				if(end-10000>endTime.getTime()) {
					break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
public static void test() throws InterruptedException {
	//倒数10个数，1秒1个
	int num=10;
	while(true) {
		Thread.sleep(1000);
		System.out.println(num--);
	}
}
}
