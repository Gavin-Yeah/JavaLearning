package Reflection.com.jiada.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 测试java.lang.Class对象的获取方式
 * 
 * @author jiadaye
 *
 */
public class demo2 {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		String path = "com.jiada.test.bean.User";
		try {
			Class<?> clz = Class.forName(path);
			//get class name
			System.out.println(clz.getName());//get package and class name
			System.out.println(clz.getSimpleName());//get class name
			
			//get field name
			Field[] f= clz.getFields();
			System.out.println(f.length);//only get public fields
			Field[] f2=clz.getDeclaredFields();
			System.out.println(f2.length);//get all fields
			Field f3= clz.getDeclaredField("uname");
			for(Field temp: f2) {
				System.out.println(temp);
			}
			//get method name
			Method[] m= clz.getDeclaredMethods();
			Method m2= clz.getDeclaredMethod("getUname", null);
			Method m3= clz.getDeclaredMethod("setUname", String.class);//if the method has parameters, have to denote the para
			for(Method me:m) {
				System.out.println("method:"+me);
			}
			//get constructure name
			Constructor[] c=clz.getDeclaredConstructors();
			for(Constructor con:c) {
				System.out.println(con);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
