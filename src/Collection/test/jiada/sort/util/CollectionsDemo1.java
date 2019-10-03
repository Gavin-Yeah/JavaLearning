package Collection.test.jiada.sort.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1.binarySearch(List<? extends Comparable<? super T>> list, T key) 需要容器有序
 * 2.sort(List<?> list)
 *   sort(List<?> list, Comparator<? super T> c)
 * 3.reverse(List<?> list)
 * 4.shuffle(List<?> list)
 * 5.swap(List<?> kist, int i , int j)
 * @author jiadaye
 *
 */
public class CollectionsDemo1 {
	public static void main(String[] args) {
		List<Integer> list= new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println("after"+list);
		//模拟斗地主
		List<Integer>cards = new ArrayList<>();
		for(int i=0;i<54;i++) {
			cards.add(i);
		}
		Collections.shuffle(cards);
		List<Integer>p1=new ArrayList<>();
		List<Integer>p2=new ArrayList<>();
		List<Integer>p3=new ArrayList<>();
		List<Integer>last=new ArrayList<>();
		for(int i=0;i<51;i+=3) {
			p1.add(cards.get(i));
			p2.add(cards.get(i+1));
			p3.add(cards.get(i+2));
			
		}
		last.add(cards.get(51));
		last.add(cards.get(52));
		last.add(cards.get(53));
		
		System.out.println("1st "+p1);
		System.out.println("2nd "+p2);
		System.out.println("3rd "+p3);
		System.out.println("last "+last);
		
	}
}
