package CollectionOthers.com.jiada.others.synread;
/**
 *  使用Collections管理同步 容器
 *  SynchronizedList()
 *  SynchronizedMap()
 *  SynchronizedSet()
 * @author jiadaye
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo1 {
	public static void main(String[] args) {
		List<String> list =new ArrayList<>();
		list.add("a");
		list.add("b");
		//list可以同步
		List <String> synList = Collections.synchronizedList(list);
		System.out.println("线程安全的list");
	}
	
	
}
