package Reflection.com.jiada.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.jiada.test.bean.User;

/**
 * by reflection operate API dynamically: constructors, methods, and fields.
 * @author jiadaye
 *
 */
public class demo3 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		// TODO Auto-generated method stub
		String path = "com.jiada.test.bean.User";
		Class<User> clz = (Class<User>) Class.forName(path);
		//operate constructor
		Constructor c= clz.getDeclaredConstructor(int.class,int.class,String.class);
		User u=(User) clz.newInstance();//constructor without parameter
		User a= (User) c.newInstance(1001,18,"jack");
		System.out.println(u);
		System.out.println();
		System.out.println(a.getUname());
		
		User u3= clz.newInstance();
		//u3.setUname(uname);
		Method m= clz.getDeclaredMethod("setUname", String.class);
		m.invoke(u3, "mm");
		
		User u4= clz.newInstance();
		Field f=clz.getDeclaredField("uname");
		f.setAccessible(true);
		f.set(u4, "g4");
		System.out.println(u4.getUname());
	}

}
