package Thread.a1.src.com.jiada.syn;
/**
 * 线程安全 在并发时保证数据的正确性，效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块
 * @author jiadaye
 *
 */


public class SynBlockTest3 {
	public static void main(String[] args) {
		SynWeb12306 web = new SynWeb12306();
	
		System.out.println(Thread.currentThread().getName());
		new Thread(web,"码畜").start();
		new Thread(web,"码农").start();
		new Thread(web,"码蝗").start();
		
		
	}
}
class SynWeb12306 implements Runnable{
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
			test2();
		}}
	//同步块 范围太大--》效率低下
	public void test2() {
			synchronized (this) {
				
			
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
	
	
	//线程不安全 ticketNums对象在变
		public void test3() {
				synchronized ((Integer)ticketNums) {
					
				
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
		//线程不安全 范围太小锁不住
		public void test4() {
				synchronized ((Integer)ticketNums) {
					
				
				if(ticketNums<=0) {
				flag=false;
				return;
				}
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
				
		}
		//尽可能锁定合理的范围（不是指代码，指数据的完整性）
		//double chekcing
		public void test5() {
			if(ticketNums<=0) {//考虑的是没有票的情况
				flag=false;
				return;
				}
			synchronized (this) {
				if(ticketNums<=0) {//考虑的是最后一张票
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
	//线程安全 同步 锁的是对象资源this
	public synchronized void test1() {
		
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