package Generic.com.jiada.gen02;

import java.util.ArrayList;
import java.util.List;

/**
 * ? -->表示类型不确定，用于声明变量|形参上
 * 不能用在
 * 1）创建对象上
 * 2)创建泛型类 泛型接口 泛型方法
 * @author jiadaye
 *
 */
public class WildCardTest {
public static void main(String[] args) {
	//声明
	List<?> list= new ArrayList<Integer>();
	list = new ArrayList<String>();
	test(list);
	//编译错误 不能创建对象
	//list= new ArrayList<?>();
}
	public static void test(List<?> list) {
		
	}
/*	
 * 不能用在泛型方法上
 * public static<?> void test2(List<?> list) {
		
	}
	*/
	class test<T>{
		
	}
	/*
	 * 不能创建类
	class test2<?>{
		
	}
	*/
}
