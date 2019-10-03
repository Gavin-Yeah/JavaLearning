package Collection.test.jiada.iter;
/**
 * objective: undeeastand the principle of iterator
 * iterator: for traverse
 * @author jiadaye
 *
 */
public class simplelist {

//array stores data
		private String [] elem= {"a","b","c"};
//		length
	private int size = elem.length;
//counter
	private int cursor=-1;
//	determine whether hasnext
	public boolean hasNext() {
		return cursor+1<size;
	}
//	get the next
	public String next() {
		
		cursor++;
		return elem[cursor];
	}
	
	public int size() {
		return this.size;
	}
//	delete next
	public void remove() {
//		move elements  of the array
		System.arraycopy(elem, cursor+1, elem, cursor, this.size-(cursor+1));
		this.size--;
//		back off
		this.cursor--;
	}
	public static void main(String[] args) {
		simplelist list = new simplelist();
		if(list.hasNext()) {
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
	}

}
