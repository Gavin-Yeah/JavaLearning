package Thread.a1.src.com.jiada.syn;
/**
 * 线程安全 在并发时保证数据的正确性，效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块 目标更明确
 * @author jiadaye
 *
 */
public class SynBlockTest1 {
public static void main(String[] args) {
	Account account= new Account(1000, "可悲的你");
	SynDrawing you=new SynDrawing(account, 80, "可悲的你");
	SynDrawing wife=new SynDrawing(account, 90, "happy her");
	you.start();
	wife.start();
}


}

//模拟取款 线程安全
class SynDrawing extends Thread{
	Account account;
	int drawingMoney;
	int pocketTotal;
	
	public SynDrawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
public void run() {
	test();
}
//目标锁account
	public  void test() {
		//提高性能
		if(account.deposit<=0) {
			return;
		}
		synchronized(account) {
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
}