package CollectionSort.com.jiada.sort.innertype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo3 {
public static void main(String[] args) {
	Date [] arg= new Date[3];
	arg[0]=new Date();
	arg[1]=new Date(System.currentTimeMillis()-1000*60*60);
	arg[2]=new Date(System.currentTimeMillis()+60*60*1000);
	
	
	Utils.sort(arg);
	String []arg2= {"a","abc","def","abcd","abc"};	
	Utils.sort(arg2);		
	
	
	System.out.println("__-------------------");
	
	List<String>a=new ArrayList<>();
	a.add("a");
	a.add("abcd");
	a.add("abc");
	a.add("def");
	a.add("abc");
	Utils.sort(a);
	System.out.println(a);
	
	
	
	
	
	System.out.println("__-------------------comparator");
	arg2= new String[]{"a","abc","def","abcd","abc"};
	Utils.sort(arg2,new StringComp());
	
	
	
	System.out.println("__-------------------comparator");
	a=new ArrayList<>();
	a.add("a");
	a.add("abcd");
	a.add("abc");
	a.add("def");
	a.add("abc");
	Utils.sort(a,new StringComp());
	System.out.println(a);
}
}

