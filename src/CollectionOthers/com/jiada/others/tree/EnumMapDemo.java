package CollectionOthers.com.jiada.others.tree;

import java.util.EnumMap;

/**
 * EnumMap 要求键为枚举
 * @author jiadaye
 *
 */
public class EnumMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnumMap<Season, String> map =new EnumMap<>(Season.class);
		//存放值
		map.put(Season.SPRING, "春困");
		map.put(Season.SUMMER, "夏无力");
		map.put(Season.FALL, "秋乏");
		map.put(Season.WINTER, "冬眠");
		System.out.println(map.size());
		
	}

}
enum Season{
	SPRING,SUMMER,FALL,WINTER
}