package CollectionOthers.com.jiada.others.en;

import java.util.Enumeration;
import java.util.Vector;

/**
 * enumeration 的使用
 * 1. 判断hasMoreElements()
 * 2. 获取nextElement()
 * 
 * @author jiadaye
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		Vector<String> vector =new Vector<>();
		vector.add("javase");
		vector.add("html");
		vector.add("oracle");
		
		//遍历vector
		Enumeration<String> en =vector.elements();
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
}
}
