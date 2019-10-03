package Thread.a1.src.com.jiada.thread.state;
/**
 * yield 礼让线程，直接进入就绪状态，不是进入阻塞状态
 * @author jiadaye
 *
 */
public class YieldDemo2 {
public static void main(String[] args) {
	new Thread(()->{
		for(int i=0;i<100;i++) {
			System.out.println("lambda.."+i);
		}
	}).start();
	for(int i=0;i<100;i++) {
		if(i%20==0) {
			Thread.yield();//main礼让
		}
		System.out.println("main.."+i);
	}
}
}
