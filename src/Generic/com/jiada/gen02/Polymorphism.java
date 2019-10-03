package Generic.com.jiada.gen02;

import java.util.ArrayList;
import java.util.List;

public class Polymorphism {
	public static void main(String[] args) {
		//poly
		Fruit f = new Apple();
		//genericity does not have poly
	//	List<Fruit> = new ArrayList<Apple>();
		List<? extends Fruit> l = new ArrayList<>();
	// no generic array
//		Fruit<String> arr = new Fruit<String> [10];
//		JDK1.7 simplification
		List<Fruit> list2 = new ArrayList<>();
		
	}
}
