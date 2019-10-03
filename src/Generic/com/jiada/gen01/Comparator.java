package Generic.com.jiada.gen01;
/**
 * 泛型接口与泛型类同理
 * @author jiadaye
 *
 */
public interface Comparator <T>{
	//全局变量
	public static final int MAX_VALUE=100;
	//公共抽象方法
	public abstract void test(T t);
}
class InterC1<A> implements Comparator{

	@Override
	public void test(Object t) {
		// TODO Auto-generated method stub
		
	}
	
}
class InterC2<A> implements Comparator<Integer>{

	@Override
	public void test(Integer t) {
		// TODO Auto-generated method stub
		
	}
	
}
class InterC3<T,A> implements Comparator<Integer>{

	@Override
	public void test(Integer t) {
		// TODO Auto-generated method stub
		
	}
	
}
