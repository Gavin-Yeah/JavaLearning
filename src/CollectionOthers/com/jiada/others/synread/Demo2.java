package CollectionOthers.com.jiada.others.synread;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 只读设置
 * emptyXxx() 空的不可变的集合
 * 1.emptyMap()
 * 	emptySet()
 * 	emptyList()
 * singletonXxx()  一个元素不可变的集合
 * singleton(T o)
 * singletonList(T o)
 * singletonMap(K key, V value)
 * unmodifiableXxx()  不可变容器
 * unmodifiableList(List<? extends T>list)
 * unmodifiableSet(Set<? extends T> s)
 * unmodifiableMap(Map<? extends K, ? extends V> m)
 * @author jiadaye
 *
 */
public class Demo2 {
public static void main(String[] args) {
	Map<String, String>map =new HashMap<>();
	map.put("test", "test");
	map.put("bjsxt", "bjsxt");
	//只读
	Map<String, String>map2 = Collections.unmodifiableMap(map);
	//map2.put("a", "a"); //不能操作
	System.out.println(map2.size());
	
	//一个元素的容器
	List<String>list = Collections.singletonList(new String());
	list.add("test");
	list.add("bjsxt");
}
public static Set<String> oper(Set<String> set){
	if(null==set) {
		return Collections.EMPTY_SET;//外部获取避免NullPointerException
		
	}
	//操作
	return set;
}
}
