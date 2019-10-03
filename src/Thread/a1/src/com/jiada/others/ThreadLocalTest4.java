package Thread.a1.src.com.jiada.others;
/**
 * InheritableThreadLocal 继承上下文 环境的数据，拷贝一份给子线程
 * @author jiadaye
 *
 */
public class ThreadLocalTest4 {
	//private static ThreadLocal<Integer> threadLocal =new ThreadLocal<>();
	//更改初始化值
	/*private static ThreadLocal<Integer> threadLocal =new ThreadLocal<>() {
		protected Integer initialValue() {return 200;};
	};
	*/
	private static ThreadLocal<Integer> threadLocal =new InheritableThreadLocal<>();
	public static void main(String[] args) {
		threadLocal.set(2);
		System.out.println(Thread.currentThread().getName()+"还剩下-->"+threadLocal.get());
		
		new Thread(()-> {
			System.out.println(Thread.currentThread().getName()+"还剩下-->"+threadLocal.get());
		}).start();

	
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
