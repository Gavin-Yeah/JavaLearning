package Thread.a1.src.com.jiada.thread.create;
/**
 * lambda推导
 * @author jiadaye
 *
 */
public class LambdaTest1 {
	static class Like2 implements ILike{

		@Override
		public void lambda() {
			// TODO Auto-generated method stub
			System.out.println("I like lambda2");
		}
		
	}
	public static void main(String[] args) {
		
		
	
		
		ILike like = new Like();

		like.lambda();
		like = new Like2();

		like.lambda();
		like = new ILike() {
			@Override
			public void lambda() {
				// TODO Auto-generated method stub
				System.out.println("I like lambda3");
			}
		};

		like.lambda();
		//lambda
		like = ()->{
			System.out.println("I like lambda4");
		};

		like.lambda();
		//方法内部类
		class Like3 implements ILike{

			@Override
			public void lambda() {
				// TODO Auto-generated method stub
				System.out.println("I like lambda5");
			}
			
		}
		like=new Like3();
		
		
		like.lambda();
	}
	
}
interface ILike{
	void lambda();
}
class Like implements ILike{

	@Override
	public void lambda() {
		// TODO Auto-generated method stub
		System.out.println("I like lambda1");
	}
	
}