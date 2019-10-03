package Thread.a1.src.com.jiada.thread.state;
/**
 * 线程的优先级 1-10
 * 1.NORM_PRIORITY 5 default
 * 2.MIN_PRIORITY 1
 * 3.MAX_PRIORITY 10
 * 概率 不代表绝对的顺序
 * @author jiadaye
 *
 */
public class PriorityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());//5
		MyPriority mp= new MyPriority();
		Thread t1=new Thread(mp,"nike");
		Thread t2=new Thread(mp,"adidas");
		Thread t4=new Thread(mp,"puma");
		Thread t3=new Thread(mp,"converse");
		Thread t5=new Thread(mp,"fila");
		Thread t6=new Thread(mp,"huili");
		Thread t7=new Thread(mp);
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t4.setPriority(Thread.MIN_PRIORITY);
		t5.setPriority(7);
		t6.setPriority(Thread.MIN_PRIORITY);
		t7.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
	}

}
class MyPriority implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread.yield();
		System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());//5
		
	}
	
}
