package Thread.a1.src.com.jiada.thread.state;
/**
 * Other functions
 * isAlive() whether the thread is still alive
 * Thread.currentThread() current thread
 * 
 * getName(),setName()
 * @author jiadaye
 *
 */
public class InfoTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().isAlive());
		//set name real role ,proximity
		MyInfo info=new MyInfo("战斗机");
		Thread t =new Thread(info);
		t.setName("公鸡");
		t.start();
		Thread.sleep(1000);
		System.out.println(t.isAlive());
	}

}
class MyInfo implements Runnable{
	String name;
	public MyInfo(String name) {
		super();
		this.name = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"->"+name);
	}
	
}
