package Thread.a1.src.com.jiada.thread.state;
/**
 * volatile用于保证数据的同步，也就是可见性
 * @author jiadaye
 *
 */
public class VolatileTest {
	public volatile static int num= 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(()->{
			while(num==0) {
				
			}
		}).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num=1;
	}

}
