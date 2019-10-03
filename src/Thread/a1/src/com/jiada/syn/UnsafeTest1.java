package Thread.a1.src.com.jiada.syn;
/**
 * 线程不安全 有负数 相同的数
 * @author jiadaye
 *
 */


public class UnsafeTest1 {
	public static void main(String[] args) {
		UnsafeWeb12306 web = new UnsafeWeb12306();
	
		System.out.println(Thread.currentThread().getName());
		new Thread(web,"码畜").start();
		new Thread(web,"码农").start();
		new Thread(web,"码蝗").start();
		
		
	}
}
class UnsafeWeb12306 implements Runnable{
	//是票数
	private int ticketNums=10;
	private boolean flag=true;
	@Override
	public void run() {
		while(flag) {
			test();
		}}
	public void test() {
		
			if(ticketNums<0) {
			flag=false;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
		
	}

	
}