package Thread.a1.src.com.jiada.thread.create;
/**
 * 创建线程二：
 * 1.创建：实现Runnable +重写run
 * 2，启动：创建实现类现象+	Thread类对象 +start()
 * 
 * 
 * 推荐:避免单线程的局限性，优先使用接口
 * 方便共享资源
 * @author jiadaye
 *
 */
public class StartRun implements Runnable{

	public static void main(String[] args) {
	/*
		//创建实现类对象
		StartRun sr=new StartRun();
		//创建代理类对象
		Thread t = new Thread(sr);
		//启动 
		t.start();
		*/
		
		new Thread(new StartRun()).start();
		for(int i=0;i<20;i++) {
			System.out.println("一边coding");
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++) {
			System.out.println("一边听歌");
		}
	}

}
