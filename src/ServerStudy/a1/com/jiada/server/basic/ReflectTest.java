package ServerStudy.a1.com.jiada.server.basic;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射：把java类中的各种结构（方法，属性，构造器，类名）映射成一个个的java对象
 * 1。获取Class对象
 * 三种方式：Class.forName("完整路径")
 * 2.可以动态创建对象
 * 
 * 
 * @author jiadaye
 *
 */
public class ReflectTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		//三种方式
		//1.对象。getClass()
		Iphone iphone= new Iphone();
		Class clz=iphone.getClass();
		//2.类。class
		clz=Iphone.class;
		//3. Class.forName("包名.类名")
		clz=Class.forName("com.jiada.server.basic.Iphone");
		
		//创建对象
		Iphone iphone2=(Iphone)clz.newInstance();
		iphone2=(Iphone)clz.getConstructor().newInstance();
		System.out.println(iphone2);
	}

}
class Iphone{
	public Iphone() {
		
	}
}
