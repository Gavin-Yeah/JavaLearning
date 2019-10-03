package Thread.a1.src.com.jiada.thread.create;
/**
 * lambda推导
 * @author jiadaye
 *
 */
public class LambdaTest4 {

	public static void main(String[] args) {
		new Thread(()-> {
			System.out.println("一边学习");
		}).start();
		new Thread(()-> System.out.println("一边泪流满面")).start();
	}
	
}

