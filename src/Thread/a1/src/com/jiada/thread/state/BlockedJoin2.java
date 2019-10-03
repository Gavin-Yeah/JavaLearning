package Thread.a1.src.com.jiada.thread.state;
/**
 * join:合并线程，插队线程
 * @author jiadaye
 *
 */
public class BlockedJoin2 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("爸爸和儿子买酒的故事");
		new Thread(new Father()).start();
	}

}
class Father extends Thread{
	public void run() {
		System.out.println("想喝酒，发现没了");
		System.out.println("让儿子去买五粮液");
		Thread t = new Thread(new Son());
		t.start();
		try {
			t.join();//father被阻塞
			System.out.println("老爸接过酒，把零钱给了儿子");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("孩子走丢了，老爸去找孩子");
		}
		
	}
}
class Son extends Thread{
	public void run() {
		System.out.println("接过老爸的钱出去了。。。");
		System.out.println("路边有个游戏厅，玩了10s");
		for(int i=0;i<10;i++) {
			System.out.println(i+"S过去了");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("赶集去买酒");
		System.out.println("手拿一瓶五粮液回家了");
	}
}