package CollectionSort.com.jiada.sort.innertype;

public class Demo1 {
public static void main(String[] args) {
	Integer a;
	Character b;
	String c="abc";//如果其中一个是另一个起始开始的子串，返回长度之差
	String d="acd";//否则返回第一个不相等的unicode码之差
	String e="abcdefg";
	System.out.println(c.compareTo(d)); //当长度相等'b'-'c'=-1
	System.out.println(c.compareTo(e)); //c.length-e.length=-4
	java.util.Date f;//根据日期的整数长度比较
}
}
