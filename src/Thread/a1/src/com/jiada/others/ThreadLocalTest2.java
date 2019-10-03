package Thread.a1.src.com.jiada.others;
/**
 * ThreadLocal:分析上下文环境 起点
 * 1.构造器：哪里调用 就属于哪里 找线程体
 * 2.run方法：本线程自身的
 * get/set/initialValue
 * @author jiadaye
 *
 */
public class ThreadLocalTest2 {
	//private static ThreadLocal<Integer> threadLocal =new ThreadLocal<>();
	//更改初始化值
	/*private static ThreadLocal<Integer> threadLocal =new ThreadLocal<>() {
		protected Integer initialValue() {return 200;};
	};
	*/
	private static ThreadLocal<Integer> threadLocal =ThreadLocal.withInitial(()->1);
	public static void main(String[] args) {

		new Thread(new MyRun()).start();
	}
	

	public static class MyRun implements Runnable{
		public MyRun() {
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		}
		@Override
		public void run() {
			Integer left=threadLocal.get();
		
			System.out.println(Thread.currentThread().getName()+"还剩下-->"+threadLocal.get());
		}
		
	}

}
