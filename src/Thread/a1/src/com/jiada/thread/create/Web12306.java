package Thread.a1.src.com.jiada.thread.create;
/**
 * 共享资源.并发
 *
 * @author jiadaye
 *
 */
public class Web12306 implements Runnable{
	//是票数
	private int ticketNums=99;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(ticketNums<0) {
				break;
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
	public static void main(String[] args) {
		Web12306 web = new Web12306();
		System.out.println(Thread.currentThread().getName());
		new Thread(web,"码畜").start();
		new Thread(web,"码农").start();
		new Thread(web,"码蝗").start();
		
		
	}
	
}
