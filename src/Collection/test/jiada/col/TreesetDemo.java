package Collection.test.jiada.col;

import java.util.HashSet;
import java.util.TreeSet;

public class TreesetDemo {
public static void main(String[] args) {
	Person p1=new Person("ss",100);
	Person p2=new Person("dss",10);
	Person p3=new Person("dsdds",1444);
	Person p4=new Person("dddss",140);
	//依次存放到treeset，使用排序业务类(匿名内部类)
	TreeSet<Person> persons= new TreeSet<Person>(new java.util.Comparator<Person>() {
HashSet<Person> a =new HashSet<Person>();
		@Override
		public int compare(Person o1, Person o2) {
			// TODO Auto-generated method stub
			return o1.getHandsome()-o2.getHandsome();
		}
		
	});
	//treeset在添加过程中排序
	//不要在treeset中修改数据，否则可能重复
	persons.add(p1);
	persons.add(p2);
	persons.add(p3);
	persons.add(p4);
	System.out.println(persons);
	//改变数据
//	p3.setHandsome(-100);
	System.out.println(persons);
}
}
