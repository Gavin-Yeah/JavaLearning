package Thread.a1.src.com.jiada.cooperation;



/**
 * 协作模型：生产者消费者实现方式一：管程法
 * 借助缓冲区
 * @author jiadaye
 *
 */
public class CoTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynContainer container = new SynContainer();
		new Producer(container).start();
		new Consumer(container).start();
	}

}
//生产者
class Producer extends Thread{
	SynContainer container;
	public Producer(SynContainer container) {
		super();
		this.container = container;
	}
	public void run() {
	for(int i=0;i<104;i++) {
		System.out.println("生产-》"+i+"个馒头");
		container.push(new SteamedBun(i));
	}
		
	}
}
//消费者
class Consumer extends Thread{
	SynContainer container;
	public Consumer(SynContainer container) {
		super();
		this.container = container;
	}
	public void run() {
		for(int i=0;i<104;i++) {
			System.out.println("消费-》"+container.pop().id+"个馒头");
		
		}
	}
}
//缓存区
class SynContainer{
	SteamedBun[] buns= new SteamedBun[10];
	int count=0;
	//存
	public synchronized void push(SteamedBun bun) {
		//不能生产
		if(count==buns.length) {
			try {
				this.wait(); //线程阻塞 消费者通知生产解除
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		buns[count]=bun;
		count++;
		//存在数据，可以通知消费了
		this.notifyAll();
	}
	//取
	public synchronized SteamedBun pop() {
		//何时消费 容器中是否有数据
		//没有数据只能等待
		if(count==0) {
			try {
				this.wait();//线程阻塞 生产者通知解除消费
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//存在可消费
		count--;
		SteamedBun bun = buns[count];
		this.notifyAll();//存在空间 可以唤醒对方生产
		return bun;
	}
}
//馒头
class SteamedBun{
	int id;

	public SteamedBun(int id) {
		super();
		this.id = id;
	}
	
}