package Thread.a1.src.com.jiada.syn;

import java.util.ArrayList;
import java.util.List;

/**
 *线程不安全 操作容器
 * @author jiadaye
 *
 */
public class UnsafeTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		for(int i=0;i<1000;i++) {
			new Thread(()->{
				list.add(Thread.currentThread().getName());
			}).start();
			}
		System.out.println(list.size());
		}
	

}
