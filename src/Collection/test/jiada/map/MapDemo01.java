package Collection.test.jiada.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 统计 单词 出现次数
 * this is a cat and that is a mouse and where is the food?
 * 思路
 * 1 分割字符串
 * 2 分拣存储
 * 3 按要求查看 单词出现的次数
 * 
 * @author jiadaye
 *
 */
/**
 * @author jiadaye
 *
 */
public class MapDemo01 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//分割字符串
		String  [] array ="this is a cat and that is a mouse and where is the food?".split(" ");
		//分拣存储
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		for(String key:array) {
			//System.out.println(key);
/*			if(!map.containsKey(key)) {//查看是否存在该单词
				map.put(key, 1);
			}else {
				map.replace(key, map.get(key)+1);
			}
			*/
			Integer value=map.get(key);
			if(null==value) {
				map.put(key, 1);
			}else {
				map.put(key, value+1);
			}
			
		}
		//查看每个单词出现次数
		Set<String>keyset =map.keySet();
		//获取对象
		Iterator<String> it = keyset.iterator();
		while(it.hasNext()) {
			String key = it.next();
			Integer value=map.get(key);
			System.out.println(key+"-->"+value);
			
		}
	}
}
