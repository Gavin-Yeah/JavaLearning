package Collection.test.jiada.list;

import java.util.HashMap;

public class SxtHashSet {
	HashMap map;
	private static final Object PRESENT = new Object();
	public SxtHashSet() {
		map = new HashMap();
	}
	public void add(Object obj) {
		map.put(obj, PRESENT);  //SET ���ظ�����������MAP�����ֵ����Ĳ����ظ�
	
	}

	public void remove(Object obj) {
		map.remove(obj);
		
	}
	public int size() {
		return map.size();
	}
	public static void main(String[] args) {
		SxtHashSet set = new SxtHashSet();
		String a;
		set.add("aaa");
		set.add(new String("aaa"));
		System.out.println(set.size());
	}
	}
	
	
