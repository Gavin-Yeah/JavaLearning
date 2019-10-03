package Thread.a1.src.com.jiada.thread.state;
/**
 * yield 礼让线程，直接进入就绪状态，不是进入阻塞状态
 * @author jiadaye
 *
 */
public class YieldDemo1 {
public static void main(String[] args) {
	MyYield my= new MyYield();
	new Thread(my,"a").start();
	new Thread(my,"b").start();
}
}
class MyYield implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"-->start");
		Thread.yield();//礼让
		System.out.println(Thread.currentThread().getName()+"-->end");
	}
	
}