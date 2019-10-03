package Collection.test.jiada.list;

import java.util.LinkedList;

public class SxtMap002 {
	LinkedList [] arr = new LinkedList [999];
	int size;
	public void put(Object key,Object value) {
		SxtEntry e = new SxtEntry(key, value);
		
		int a = key.hashCode()%arr.length;
		
	if(arr[a]==null) {
		LinkedList list =new LinkedList();
		arr[a]=list;
		list.add(e);
	}else {
		LinkedList list= arr[a];
		for(int i=0;i<list.size();i++) {
			SxtEntry e2 = (SxtEntry) list.get(i);
			if(e2.key.equals(key)) {
				e2.value=value;  //��ֱֵ�Ӹ���
				return;
			}
		}
		arr[a].add(e);
	}
	}
	public Object get(Object key) {
		int a= key.hashCode()%arr.length;
		if(arr[a]!=null) {
			LinkedList list = arr[a];
			for(int i=0;i<list.size();i++) {
				SxtEntry e = (SxtEntry) list.get(i);
				if(e.key.equals(key)) {
					return e.value; 
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		SxtMap001 m = new SxtMap001();
	//	m.put("jieliun", new friend("gavin"));
		m.put("jielun", new friend("jay"));
		m.put("jielun", new friend("day"));
	   friend f=  (friend) m.get("jielun");
	   System.out.println(f.name);

	}
}
