package Thread.a1.src.com.jiada.others;
/**
 * 不可重入锁：锁不能延续使用
 * @author jiadaye
 *
 */
public class LockTest1 {
	Lock lock =new Lock();
	public void a() throws InterruptedException {
		lock.lock();
		doSomething();
		lock.unlock();
	}//不可重入
	public void doSomething() throws InterruptedException {
		lock.lock();
		//。。。。。。。。
		lock.unlock();
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		LockTest1 test= new LockTest1();
		test.a();
		test.doSomething();
	
	}

}
class Lock{
	//是否占用
	private boolean isLocked=false;
	//使用锁
	public synchronized void lock() throws InterruptedException {
		while(isLocked) {
			System.out.println("等待");
			wait();
			System.out.println("等待后");
		}
		System.out.println("true");
		isLocked=true;
	}
	public synchronized void unlock() {
		isLocked=false;
		notify();
	}
}
