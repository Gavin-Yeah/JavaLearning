package Thread.a1.src.com.jiada.syn;
/**
 * 线程不安全：取钱
 * @author jiadaye
 *
 */
public class UnsafeTest2 {
public static void main(String[] args) {
	Account account= new Account(100, "可悲的你");
	Drawing you=new Drawing(account, 80, "可悲的你");
	Drawing wife=new Drawing(account, 90, "happy her");
	you.start();
	wife.start();
}


}

//模拟取款
class Drawing extends Thread{
	Account account;
	int drawingMoney;
	int pocketTotal;
	
	public Drawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	public void run() {
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