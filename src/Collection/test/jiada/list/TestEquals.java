package Collection.test.jiada.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestEquals {
public static void main(String[] args) {
	List list= new ArrayList();
	String s1= new String("aaa");
	String s2= new String("aaa");
	list.add(s1);
	list.add(s2);
	System.out.println(list.size());
	
	Map map = new HashMap();
	//�������ظ�
	map.put(s1, "aaaa");
	map.put(s2,"bbbb");
	System.out.println(map.get("aaa"));
}
}
