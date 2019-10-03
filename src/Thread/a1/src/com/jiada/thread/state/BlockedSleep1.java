package Thread.a1.src.com.jiada.thread.state;
/**
 * 共享资源.并发
 * sleep 模拟网络延迟，放大了发生问题的可能性
 * @author jiadaye
 *
 */
public class BlockedSleep1{
	
}
class Web12306 implements Runnable{
	//是票数
	private int ticketNums=99;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(ticketNums<0) {
				break;
			}
			//模拟网络延时
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
		}
	}
/*	public static void main(String[] args) {
		BlockedSleep1 web = new BlockedSleep1();
		System.out.println(Thread.currentThread().getName());
		new Thread(web,"码畜").start();
		new Thread(web,"码农").start();
		new Thread(web,"码蝗").start();
		
		
	}
	*/
}
