package CollectionSort.com.jiada.sort.innertype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 使用Collections对容器的比较
 * 1.public static <T>void sort (List<T>list, Comparator<? super T>c)
 * 2.public static <T extends Comparable<? super T>void sort (List<T>list)
 * @author jiadaye
 *
 */
public class Demo5 {
public static void main(String[] args) {
	List<String>a=new ArrayList<>();
	a.add("a");
	a.add("abcd");
	a.add("abc");
	a.add("def");
	a.add("abc");
	Collections.sort(a,new StringComp());
	System.out.println(a);
	a=new ArrayList<>();
	a.add("a");
	a.add("abcd");
	a.add("abc");
	a.add("def");
	a.add("abc");
	Collections.sort(axw);
	System.out.println(a);
}
}
