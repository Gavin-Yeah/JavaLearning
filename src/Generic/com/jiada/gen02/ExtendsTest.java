package Generic.com.jiada.gen02;
/**
 * extends：泛型的上限<= 即子类及自身
 * 1.一般用于限制操作
 * 2.不能使用在添加数据上面，一般用于读取操作
 * 3。 规则
 * 	List<Fruit>-->List<?extends Fruit>
 * 	List<Apple>-->List<?extends Fruit>
 * 	List<? extends Apple>-->List<?extends Fruit>
 * 	不能用于
 * 1. List<?> == List<? extends Object>
 */
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
		list.add(null);
	}
}
// generic class
class Test<T extends Fruit>{
	
}
