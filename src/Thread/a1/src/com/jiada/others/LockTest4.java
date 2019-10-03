package Thread.a1.src.com.jiada.others;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 不可重入锁：锁不能延续使用+计数器
 * @author jiadaye
 *
 */
public class LockTest4 {
	ReentrantLock lock =new ReentrantLock();
	public void a() throws InterruptedException {
		lock.lock();
		System.out.println(lock.getHoldCount());
		doSomething();
		lock.unlock();
		System.out.println(lock.getHoldCount());
	}//不可重入
	public void doSomething() throws InterruptedException {
		lock.lock();
		System.out.println(lock.getHoldCount());
		lock.unlock();
		System.out.println(lock.getHoldCount());
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		LockTest4 test= new LockTest4();
		test.a();
	//	test.doSomething();
		Thread.sleep(1000);
		System.out.println(test.lock.getHoldCount());
	}

}
