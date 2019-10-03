package Thread.a1.src.com.jiada.thread.state;
/**
 * sleep 模拟休息
 * @author jiadaye
 *
 */
public class BlockedSleep2{
	public static void main(String[] args) {
		Racer racer= new Racer();
		new Thread(racer,"tortoise").start();
		new Thread(racer,"rabbit").start();
	}
}
 class Racer implements Runnable {
	private String winner;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int step=1;step<=100;step++) {
			//模拟休息
			if(Thread.currentThread().getName().equals("rabbit")&&step%10==0) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"-->"+step);
			//比赛是否结束
			boolean flag = gameOver(step);
			if(flag) {
				break;
			}
		}
	}
	private boolean gameOver(int step) {
		if(winner!=null) {
			return true;
		}else {
			if(step==100) {
				winner=Thread.currentThread().getName();
				System.out.println("winner-->" +winner);
				return true;
			}
		}
		return false;
	}

}