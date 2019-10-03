package Thread.a1.src.com.jiada.syn;
/**
 * 线程安全 在并发时保证数据的正确性，效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块
 * @author jiadaye
 *
 */
public class SynTest2 {
public static void main(String[] args) {
	Account account= new Account(100, "可悲的你");
	SafeDrawing you=new SafeDrawing(account, 80, "可悲的你");
	SafeDrawing wife=new SafeDrawing(account, 90, "happy her");
	you.start();
	wife.start();
}


}

//模拟取款
class SafeDrawing extends Thread{
	Account account;
	int drawingMoney;
	int pocketTotal;
	
	public SafeDrawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
public void run() {
	test();
}
//目标不对 锁定失败 这里不是锁this 应该锁account
	public synchronized void test() {
		if(account.deposit-drawingMoney<0) {
			return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		account.deposit-=drawingMoney;
		pocketTotal+=drawingMoney;
		System.out.println(this.getName()+"--> account balance is"+account.deposit);
		System.out.println(this.getName()+"--> total withdrawl is"+pocketTotal);
		
	}
}