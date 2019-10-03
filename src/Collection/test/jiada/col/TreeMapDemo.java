package Collection.test.jiada.col;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String[] args) {
		Person p1=new Person("ss",100);
		Person p2=new Person("dss",10);
		Person p3=new Person("dsdds",1444);
		Person p4=new Person("dddss",140);
		TreeMap<Person,String> map = new TreeMap<Person,String>(new java.util.Comparator<Person>() {
			HashSet<Person> a =new HashSet<Person>();
			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getHandsome()-o2.getHandsome();
			}
			
		});
		map.put(p1, "a");
		map.put(p2, "a");
		map.put(p3, "a");
		map.put(p4, "a");
		Set <Person> persons=map.keySet();
		System.out.println(persons);
		
		
	}
}
