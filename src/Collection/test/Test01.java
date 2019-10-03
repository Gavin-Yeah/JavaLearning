package Collection.test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Test01 {
	public static void main(String[] args) throws ParseException {
		//һ������һ�м�¼
		Employee e1 = new Employee(0301, "����", 3000, "��Ŀ��", "2007-10");
		Employee e2 = new Employee(0302, "��ʿ��", 3000, "��ѧ��", "2006-10");
		Employee e3 = new Employee(0303, "����", 3550, "��ѧ��", "2006-10");
		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		printEmName(list);
	}
	public static void printEmName(List <Employee> list) {
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i).getName());
		}
	}

}
