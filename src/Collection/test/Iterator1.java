package Collection.test;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Iterator1 {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		Set set = new HashSet();
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			String str = (String)iter.next();
			System.out.println(str);
		}
		for(Iterator iter2= set.iterator();iter2.hasNext();) {
			String str2 = (String) iter2.next();
			System.out.println(str2);
			iter2.remove();
			iter2.remove();
		}
}
}
