package CollectionOthers.com.jiada.others.tree;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * WeakHashMap 键为弱类型，gc运行立即回收
 * 
 * @author jiadaye
 *
 */
public class WeakHashMapDemo {
	public static void main(String[] args) {
		WeakHashMap<String, String> map = new WeakHashMap<>();
		//测试数据
		//常量池对象，不会回收
		map.put("abc", "a");
		map.put("d", "test");
		//gc运行 已被回收
		map.put(new String("bjxst"), "c");
		map.put(new String("dsf"), "d");
		//同时回收
		System.gc();
		System.runFinalization();
		System.out.println(map.size());
	}
}
