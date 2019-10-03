package Thread.a1.src.com.jiada.thread.create;
/**
 * lambda推导
 * @author jiadaye
 *
 */
public class LambdaTest3 {

	public static void main(String[] args) {
		
		IInterest interest= (int a,int b)->{
			// TODO Auto-generated method stub
			System.out.println("I like lambda1"+a+b);
			return a+b;
		};
	
		
		interest.lambda(100,200);

		// 简化
		interest = (a,b) -> {
			// TODO Auto-generated method stub
			System.out.println("I like lambda1" + a);
			return a+b;
		};
		interest.lambda(50,100);
		
		
		/*括号不能省略
		interest = a,b -> {
			// TODO Auto-generated method stub
			System.out.println("I like lambda1" + a);
			return a+b;
		};
		love.lambda(5，10);
		*/
		// 简化 仅一行代码时
		interest= (a,b) ->  a+b;
		System.out.println(interest.lambda(10, 20));
	
	}
	
}
interface IInterest{
	int lambda(int a, int b);
}
class Interest implements IInterest{

	@Override
	public int lambda(int a,int b) {
		// TODO Auto-generated method stub
		System.out.println("I like lambda1"+a+b);
		return a+b;
	}
	
}