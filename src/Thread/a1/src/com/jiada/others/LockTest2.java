package Thread.a1.src.com.jiada.others;
/**
 * 可重入锁：锁能延续使用
 * @author jiadaye
 *
 */
public class LockTest2 {
public void test() {
	synchronized(this) {
		while(true) {
			synchronized(this) {
				System.out.println("reentrantlock!");
			}try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LockTest2().test();
	}

}
