package Generic.com.jiada.gen02;
/**
 * super : the floor bound of the genericity
 * it can add data, cannot add parent object
 */
import java.util.ArrayList;
import java.util.List;

public class ExtendsTest2 {
	public static void main(String[] args) {
//		extends is the upper bound
		Test<Fruit> t1 = new Test<Fruit>();
		Test<Apple> t2 = new Test<Apple>();
//		calling method
		List<? super Fruit> list1 = new ArrayList<Fruit>();
		test(list1);
		List<Fruit> list2 = new ArrayList<Fruit>();
		test(list2);
		List<Apple> list3 = new ArrayList<Apple>();
		test(list3);
		List<? super Apple> list4 = new ArrayList<Fruit>();
		test(list4);
		List<? super FujiApple> list5 = new ArrayList<Fruit>();
//		test(list5); // <?>=<?>extends Object
	}
	static class Test<T extends Fruit>{
		
	}

	public static void test(List<? super Apple> list) {
//	list.add(new Fruit())
		list.add(new Apple());
		
	}
}

