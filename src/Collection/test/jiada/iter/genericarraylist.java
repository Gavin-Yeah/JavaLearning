package Collection.test.jiada.iter;

import java.util.Arrays;
import java.util.Iterator;

/**
 * objective: undeeastand the principle of iterator
 * iterator: for traverse
 * 
 * @author jiadaye
 *
 */
public class genericarraylist<E> implements Iterable<E>{

//array stores data
		private Object [] elem= new Object[5];
//		length
	private int size = 0;
	public void add(String ele) {
		if(this.size==elem.length) {
			Arrays.copyOf(elem, elem.length+5);
		}
		elem[size]=ele;//数组中加入元素
		size++;
	}
	public int size() {
		return this.size;
	}

	public Iterator iterator() {
//		class defined in the method
		return new Iterator() {
			//counter
			private int cursor=-1;
//			determine whether hasnext
			public boolean hasNext() {
				return cursor+1<size;
			}
//			get the next
			public E next() {
				
				cursor++;
				return  (E) elem[cursor];
			}
			
			
//			delete next
			public void remove() {
//				move elements  of the array
				System.arraycopy(elem, cursor+1, elem, cursor, size-(cursor+1));
				size--;
//				back off
				this.cursor--;
			}
		};
	}
	public static void main(String[] args) {
		genericarraylist list = new genericarraylist();
		list.add("a");
		list.add("b");
		for(Object str: list) {
			System.out.println(str);
		}
		/*if(list.hasNext()) {
		System.out.println(list.next());
		list.remove();
		}
		if(list.hasNext()) {
			System.out.println(list.next());
			list.remove();
			}
		if(list.hasNext()) {
				System.out.println(list.next());
				list.remove();
			}
		System.out.println(list.size());
		*/
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

}
