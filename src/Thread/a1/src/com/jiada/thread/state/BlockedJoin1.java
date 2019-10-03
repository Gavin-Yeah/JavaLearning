package Thread.a1.src.com.jiada.thread.state;
/**
 * join:合并线程，插队线程
 * @author jiadaye
 *
 */
public class BlockedJoin1 {

	public static void main(String[] args) throws InterruptedException {
		Thread t=new Thread(()->{
			for(int i=0;i<100;i++) {
				System.out.println("lambda.."+i);
			}
		});
		t.start();
		for(int i=0;i<100;i++) {
			if(i==20) {
				t.join();//插队， main被阻塞
			}
			System.out.println("main.."+i);
		}

	}

}
