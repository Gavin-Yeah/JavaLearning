package Collection.test.jiada.list;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
public static void main(String[] args) {
	Set set = new HashSet();
	set.add("aaa");
	set.add("bbb");
	set.add(new String("aaa"));
	System.out.println(set.size());
	System.out.println(set.contains("aaa"));
	set.remove("aaa");

	
}
}
