package Thread.a1.src.com.jiada.syn;
/**
 * 线程安全 在并发时保证数据的正确性，效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块
 * @author jiadaye
 *
 */


public class SynTest1 {
	public static void main(String[] args) {
		safeWeb12306 web = new safeWeb12306();
	
		System.out.println(Thread.currentThread().getName());
		new Thread(web,"码畜").start();
		new Thread(web,"码农").start();
		new Thread(web,"码蝗").start();
		
		
	}
}
class safeWeb12306 implements Runnable{
	//是票数
	private int ticketNums=10;
	private boolean flag=true;
	@Override
	public void run() {
		while(flag) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test();
		}}
	//线程安全 同步 锁的是对象资源this
	public synchronized void test() {
		
			if(ticketNums<=0) {
			flag=false;
			return;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
		
	}

	
}