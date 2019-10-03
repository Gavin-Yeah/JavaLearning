package Thread.a1.src.com.jiada.syn;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 * 线程安全：操作并发容器
 * @author jiadaye
 *
 */
public class SynContainer {

	public static void main(String[] args)  throws InterruptedException{
		// TODO Auto-generated method stub
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		for(int i=0;i<1000;i++) {
			new Thread(()->{
				list.add(Thread.currentThread().getName());
			}).start();
			}
		Thread.sleep(1000);
		System.out.println(list.size());
		}
	}


