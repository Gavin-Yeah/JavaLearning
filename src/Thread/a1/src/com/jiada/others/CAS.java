package Thread.a1.src.com.jiada.others;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * CAS:比较并交换
 * @author jiadaye
 *
 */
public class CAS {
	//库存
	private static AtomicInteger stock =new AtomicInteger(5);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<=5;i++) {
			new Thread(()-> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Integer left=stock.decrementAndGet();
				if(left<0) {
					System.out.println("抢完了。。。");
					return;
				}
				System.out.println(Thread.currentThread().getName()+"抢到一个--》还剩"+left);
			
			}).start();;
		}
	}

}
