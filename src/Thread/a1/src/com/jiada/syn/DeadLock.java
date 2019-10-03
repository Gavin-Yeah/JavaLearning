package Thread.a1.src.com.jiada.syn;
/**
 * 死锁:过多的同步可能造成相互不释放资源
 * 从而相互等待。一般发生于同步中持有多个对象的锁
 * 
 * 避免：不要在同一个代码块中同时持有多个对象的锁
 * @author jiadaye
 *
 */

public class DeadLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Makeup g1=new Makeup(1, "LA");
Makeup g2=new Makeup(0, "SS");
g1.start();
g2.start();
	}

}
class Lipstick{
	
}
class Mirror{
	
}
class Makeup extends Thread{
	int choice;
	String girl;
	static Lipstick lipstick= new Lipstick();
	static Mirror mirror= new Mirror();
	public Makeup(int choice, String girl) {
		super();
		this.choice = choice;
		this.girl = girl;
	}
public void makeup() throws InterruptedException {
	if(choice==0) {
		synchronized(lipstick) {
			System.out.println(this.girl+"获得口红");
			//一秒后想拥有镜子的锁
			Thread.sleep(1000);
		/*	synchronized(mirror) {
				System.out.println(this.girl+"获得mirror");
				
			}*/	
			}
			
		synchronized(mirror) {
			System.out.println(this.girl+"获得mirror");
			
		}	
		
	}else {
		synchronized(mirror) {
			System.out.println(this.girl+"获得mirror");
			//2秒后想拥有lipstick的锁
			Thread.sleep(2000);
		/*	synchronized(lipstick) {
				System.out.println(this.girl+"获得口红");
			
				}*/	
		}
		synchronized(lipstick) {
			System.out.println(this.girl+"获得口红");
			
		}
		
	}
}
//相互持有对方的对象锁--》可能造成死锁
	public void run() {
		try {
			makeup();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}