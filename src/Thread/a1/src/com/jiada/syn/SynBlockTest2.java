package Thread.a1.src.com.jiada.syn;

import java.util.ArrayList;
import java.util.List;

/**
 *线程安全 操作容器
 * @author jiadaye
 *
 */
public class SynBlockTest2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		for(int i=0;i<100000;i++) {
			new Thread(()->{
				synchronized (list) {
					list.add(Thread.currentThread().getName());
				}
				
			}).start();
			}
		//延时
		//Thread.sleep(1000);
		System.out.println(list.size());
		}
	

}
