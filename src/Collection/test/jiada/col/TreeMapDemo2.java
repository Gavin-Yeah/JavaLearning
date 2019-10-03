package Collection.test.jiada.col;

import java.util.TreeMap;

public class TreeMapDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Worker w1= new Worker("拉丝回收员",10000);
		Worker w2= new Worker("coach",20000);
		Worker w3= new Worker("teacher",40000);
		Worker w4= new Worker("拉丝回收员",10000);

		TreeMap<Worker,String> employee= new TreeMap<Worker,String>();
		employee.put(w1,"a");
		employee.put(w2,"a");
		employee.put(w3,"f");
		employee.put(w4,"d");
		System.out.println(employee.keySet());
	}

}
