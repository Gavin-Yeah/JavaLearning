package Thread.a1.src.com.jiada.cooperation;



/**
 * 协作模型：生产者消费者实现方式二：信号灯法
 * 借助标志位
 * @author jiadaye
 *
 */
public class CoTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV tv= new TV();
		
		new Player(tv).start();
		new Watcher(tv).start();
	}

}
//生产者 演员
class Player extends Thread{
	TV tv;
	public Player(TV tv) {
		super();
		this.tv=tv;
	}
	public void run() {
	for(int i=0;i<20;i++) {
		if(i%2==0) {
			this.tv.play("奇葩说");
		}
		else {
			this.tv.play("太污了");
		}
		
	}
		
	}
}
//消费者 观众
class Watcher extends Thread{
	TV tv;
	public Watcher(TV tv) {
		super();
		this.tv=tv;
	}
	public void run() {
		for(int i=0;i<20;i++) {
		tv.watch();
		}
	}
}
//SOURCE TV
class TV{
	String voice;
	boolean flag=true;//
	//t表示演员表演 观众等待
	//f表示观众观看 演员等待
	//表演
	public synchronized void play(String voice){
		//演员等待
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.voice=voice;
		System.out.println("表演了"+voice);
		//唤醒
		this.notifyAll();
		this.flag=!this.flag;
	}
	//观看
	public synchronized void watch()  {
		//观众等待
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("听到了"+voice);
		//唤醒
				this.notifyAll();
				this.flag=!this.flag;
		
	}
	
}
