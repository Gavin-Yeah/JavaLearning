package Thread.a1.src.com.jiada.thread.create;
/**
 * Lambda 表达式简化线程（用一次）的使用
 * @author jiadaye
 *
 */
public class LambdaThread {
	//静态内部类
	static class Test implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<20;i++) {
				System.out.println("一边coding");
			}
		}
		
	}
	
	public static void main(String[] args) {
	/*
		//创建实现类对象
		StartRun sr=new StartRun();
		//创建代理类对象
		Thread t = new Thread(sr);
		//启动 
		t.start();
		*/
		
		//局部内部类
		class Test2 implements Runnable{
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<20;i++) {
					System.out.println("一边coding");
				}
			}
			
		}
		new Thread(new Test2()).start();
		
		//new Thread(new Test()).start();
		
		
		//匿名内部类 必须借助接口或者父类
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<20;i++) {
					System.out.println("一边coding");
				}
			}
			
		}).start();
		
		
		
		//JDK8 简化lambda表达式
		new Thread(()->{
			for(int i=0;i<20;i++) {
				System.out.println("一边coding");
			}
		}
		).start();
	}

	

}
