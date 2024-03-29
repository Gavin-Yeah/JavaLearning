package Thread.a1.src.com.jiada.others;
/**
 * ThreadLocal:每个线程的存储本地，局部区域
 * get/set/initialValue
 * @author jiadaye
 *
 */
public class ThreadLocalTest1 {
	//private static ThreadLocal<Integer> threadLocal =new ThreadLocal<>();
	//更改初始化值
	/*private static ThreadLocal<Integer> threadLocal =new ThreadLocal<>() {
		protected Integer initialValue() {return 200;};
	};
	*/
	private static ThreadLocal<Integer> threadLocal =ThreadLocal.withInitial(()->200);
	public static void main(String[] args) {
		// 获取值
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		//设置值
		threadLocal.set(99);
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		new Thread(new MyRun()).start();
		new Thread(new MyRun()).start();
	}

	public static class MyRun implements Runnable{

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
			threadLocal.set((int)(Math.random()*99));
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		}
		
	}

}
