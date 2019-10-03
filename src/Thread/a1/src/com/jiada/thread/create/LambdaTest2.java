package Thread.a1.src.com.jiada.thread.create;
/**
 * lambda推导
 * @author jiadaye
 *
 */
public class LambdaTest2 {

	public static void main(String[] args) {
		
		
	
		ILove love = (int a) -> {
			// TODO Auto-generated method stub
			System.out.println("I like lambda1" + a);
		};
		love.lambda(100);

		// 简化
		love = (a) -> {
			// TODO Auto-generated method stub
			System.out.println("I like lambda1" + a);
		};
		love.lambda(50);
		// 简化
		love = a -> {
			// TODO Auto-generated method stub
			System.out.println("I like lambda1" + a);
		};
		love.lambda(5);
		// 简化 仅一行代码时
		love = a -> System.out.println("I like lambda1" + a);
		love.lambda(0);
	}
	
}
interface ILove{
	void lambda(int a);
}
class Love implements ILove{

	@Override
	public void lambda(int a) {
		// TODO Auto-generated method stub
		System.out.println("I like lambda1"+a);
	}
	
}