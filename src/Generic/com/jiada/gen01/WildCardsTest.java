package Generic.com.jiada.gen01;
/**
 * 不能用在创建对象和泛型类，泛型接口
 * extends:upper bound of generisity <=
 * 
 * 
 */
import java.util.ArrayList;
import java.util.List;

import com.sun.jdi.event.ExceptionEvent;

public class WildCardsTest {
	public static void main(String[] args) {
//		声明
		List<?> list = new ArrayList<Integer>();
		list = new ArrayList<String>();
		list = new ArrayList<Object>();
		
		test(list);
		//编译错误
//		list = new ArrayList<?>();
ListNode a = new ListNode(1);
	}
	public static void test(List<?> list) {
	
		HashMap()
	}
	
}

/*class Test2<?>{
不能用在创建类和泛型方法
}*/