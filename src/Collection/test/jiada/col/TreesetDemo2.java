package Collection.test.jiada.col;

import java.util.TreeSet;

public class TreesetDemo2 {
	public static void main(String[] args) {
		Worker w1= new Worker("拉丝回收员",10000);
		Worker w2= new Worker("coach",20000);
		Worker w3= new Worker("teacher",40000);
		Worker w4= new Worker("拉丝回收员",10000);
		
		
		TreeSet<Worker> employee= new TreeSet<Worker>();
		employee.add(w1);
		employee.add(w2);
		employee.add(w3);
		employee.add(w4);
		System.out.println(employee);
		
	}
}
