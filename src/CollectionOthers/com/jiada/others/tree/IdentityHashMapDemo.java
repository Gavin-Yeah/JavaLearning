package CollectionOthers.com.jiada.others.tree;

import java.util.IdentityHashMap;

/**
 * IdentityHashMap 键比较地址去重
 * @author jiadaye
 *
 */
public class IdentityHashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IdentityHashMap<String, String> map = new IdentityHashMap<>();
		//常量池中的“a”
		map.put("a", "a1");
		map.put("a", "a2");
		System.out.println(map.size());
		map.put(new String("a"), "a3");
		map.put(new String("a"), "a4");
		System.out.println(map.size());
	}

}
