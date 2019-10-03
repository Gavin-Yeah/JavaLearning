package Thread.a1.src.com.jiada.others;
/**
 * 指令重排：代码执行顺序与预期不一致
 * 目的：提高性能
 * @author jiadaye
 *
 */
	public class HappenBefore {
		//变量1
		private static int a= 0;
		//变量2
		private static boolean flag=false;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			a=0;
			flag=false;
			//线程一 读取数据
			Thread t= new Thread(()-> {
				a=1;
				flag=true;
			});
			//线程二 更改数据
			Thread t2= new Thread(()-> {
			if(flag) {
				a=1;
			}
			if(a==0) {
				System.out.println("happen before a->"+a);
			}
			});
			t2.start();
			t.start();
			t2.join();
			t.join();		
		}

	}

}
