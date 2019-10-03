package Generic.com.jiada.gen01;

import java.util.ArrayList;
import java.util.List;

public class ExtendsTest {
	public static void main(String[] args) {
//		extends is the upper bound
		Test<Fruit> t1 = new Test<Fruit>();
		Test<Apple> t2 = new Test<Apple>();
//		calling method
		List<? extends Fruit> list1 = new ArrayList<Fruit>();
		test(list1);
		List<Fruit> list2 = new ArrayList<Fruit>();
		test(list2);
		List<Apple> list3 = new ArrayList<Apple>();
		test(list3);
		List<? extends Apple> list4 = new ArrayList<FujiApple>();
		test(list4);
		List<?> list5 = new ArrayList<Fruit>();
//		test(list5); <?>=<?>extends Object
	}
	static class Test<T extends Fruit>{
		
	}

	public static void test(List<? extends Fruit> list) {
//		list.add(new Fruit())
//		list.add(new Apple());
		
	}
}
// generic class
class Test<T extends Fruit>{
	
}
