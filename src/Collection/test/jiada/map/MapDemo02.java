package Collection.test.jiada.map;

import java.util.HashMap;
import java.util.Map;

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
public class MapDemo02 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//分割字符串
		String  [] array ="this is a cat and that is a mouse and where is the food ?".split(" ");
		//分拣存储
		Map<String,Letter> map = new HashMap<String,Letter>();
		for(String key:array) {
			//第一次查看是否存在袋子
			/*if(!map.containsKey(key))
			map.put(key, new Letter(key));
			//获取袋子
			Letter value= map.get(key);
			value.setCount(value.getCount()+1);
		*/
			Letter value=map.get(key);
			if(null==value) {
				value=new Letter();
				map.put(key, value);
			}
			value.setCount(value.getCount()+1);
		}
			
		
		
		//查看每个单词出现次数
		for(String key:map.keySet()) {
			Letter value =map.get(key);
			System.out.println(key+"-->"+value.getCount());
		}
	}
}
