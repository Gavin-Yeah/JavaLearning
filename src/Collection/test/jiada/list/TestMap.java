package Collection.test.jiada.list;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map map= new HashMap();
		map.put("jiada", new friend("gavin"));
		friend a= new friend("hedi");
		map.put("Tony", a);
		friend f= (friend) map.get("jiada");
		map.remove("jiada");
		System.out.println(f.name);
		System.out.println(map.containsKey("Tony"));
		
		map.containsValue("hedi");
		map.clear();
	}
}
class friend {
	String name;
	friend(String name){
		this.name=name;
	}
}
