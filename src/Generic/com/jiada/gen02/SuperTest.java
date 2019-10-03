package Generic.com.jiada.gen02;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型的下线 >=即父类及自身
 * 一般用于下限操作
 * 能够用于add，不能添加父对象
 * 	List<Fruit>-->List<? super Apple>
 * 	List<Apple>-->List<? super Apple>
 * 不能存放
 * 	List<？super FujiApple>-->List<? super Apple>
 * 	
 * @author jiadaye
 *
 */
public class SuperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Apple> list1 = new ArrayList<Apple>();
		test(list1);
		List<Fruit> list2 = new ArrayList<Fruit>();
		test(list2);
		List<? super Apple> list3 = new ArrayList<Apple>();
		test(list3);
		List<? super Fruit> list4 = new ArrayList<Object>();
		test(list4);
		List<? super FujiApple> list5 = new ArrayList<Object>();
	//	test(list5);
	}
	public static void test(List<? super Apple>list) {
		list.add(new Apple());
	//	list.add(new Fruit());
	}
}
