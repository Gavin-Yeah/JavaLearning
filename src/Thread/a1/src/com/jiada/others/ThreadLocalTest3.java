package Thread.a1.src.com.jiada.others;
/**
 * ThreadLocal:每个线程自身的数据，更改不会影响其他线程
 * get/set/initialValue
 * @author jiadaye
 *
 */
public class ThreadLocalTest3 {
	//private static ThreadLocal<Integer> threadLocal =new ThreadLocal<>();
	//更改初始化值
	/*private static ThreadLocal<Integer> threadLocal =new ThreadLocal<>() {
		protected Integer initialValue() {return 200;};
	};
	*/
	private static ThreadLocal<Integer> threadLocal =ThreadLocal.withInitial(()->1);
	public static void main(String[] args) {
	for(int i=0;i<5;i++) {
		new Thread(new MyRun()).start();
	}
	}

	public static class MyRun implements Runnable{

		@Override
		public void run() {
			Integer left=threadLocal.get();
			System.out.println(Thread.currentThread().getName()+"得到了-->"+left);
			threadLocal.set(left-1);
			System.out.println(Thread.currentThread().getName()+"还剩下-->"+threadLocal.get());
		}
		
	}

}
