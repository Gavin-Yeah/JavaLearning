package CollectionOthers.com.jiada.others.commons;

import java.util.function.Predicate;




/**
 * 函数式编程之predicate 断言
 * 对封装条件或判别式 if。else替代
 * 1.
 * @author jiadaye
 *
 */
public class Demo1 {
public static void main(String[] args) {
	System.out.println("-----------相等判断---------");
	Predicate a = new Predicate<Integer>() {
		int a= 0;
		@Override
		public boolean test(Integer t) {
			// TODO Auto-generated method stub
			return false;
		}
		
	};
}
}
