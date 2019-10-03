package Generic.com.jiada.gen01;
/**
 * 泛型父类，子类为富二代
 * 1.保留父类泛型--》子类为泛型
 * 2.不保留父类泛型--》子类按需实现
 * 3.子类重写方法的类型--》随父类而定
 * 4。子类中使用父类的属性--》随父类而定
 * 5.子类新增方法--》随子类而定
 * 4。子类中使用自己的的属性--》随子类而定
 * @author jiadaye
 *
 */
public abstract class Father<T1,T2>{
	T1 age;
	public abstract void test(T2 name);
}
//保留
//1）全部保留 -->泛型子类
class C1<T1,T2> extends Father<T1,T2>{

	@Override
	public void test(T2 name) {
		// TODO Auto-generated method stub
		
	}
	
}
//2）部分保留 
class C2<T2,A,B> extends Father<Integer,T2>{//子类必须泛型比父类多
	
	public void test1(A name) {
		// TODO Auto-generated method stub
		
	} 
	@Override
	public void test(T2 name) {
		// TODO Auto-generated method stub
		
	}   
	
}
//不保留-->按需实现
//1）具体类型
class C3 extends Father<Integer,String>{

	@Override
	public void test(String name) {
		// TODO Auto-generated method stub
//		this.age;integer类型
	}
	
}
//2）没有类型（擦除） object
class C4<A,B> extends Father{

	@Override
	public void test(Object name) {
		// TODO Auto-generated method stub
//		this.age;object 类型
	}
	
}