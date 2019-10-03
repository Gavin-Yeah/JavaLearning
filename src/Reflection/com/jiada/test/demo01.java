package Reflection.com.jiada.test;

import java.util.LinkedList;
import java.util.List;

/**
 * 测试java.lang.Class对象的获取方式
 * 
 * @author jiadaye
 *
 */
public class demo01 {
	public static void main(String[] args) {
		String path = "com.jiada.test.bean.User";
		try {
			Class<?> clz = Class.forName(path);
			//对象是表示或封装一些数据。一个类被加载后，jvm会创建一个对应类的Class对象，类的整个结构信息会放到对应的Class对象中。
			//这个Class对象就像一面镜子一样，通过这面镜子我可以看到对应的全部信息
			System.out.println(clz.hashCode());
			Class clz2 = Class.forName(path);//一个类只对应一个对象
			System.out.println(clz2.hashCode());
			
			//其他获取方式
			Class strClz = String.class;
			Class strClz2=path.getClass();
			System.out.println(strClz==strClz2);
			
			Class intClz= int.class;
			int[][] a = new int[10][20];
			int[] arr2= new int[30];
			double [] arr1= new double[20];
			//数组的类型跟维度和类型有关
			System.out.println(arr2.getClass().hashCode());
			System.out.println(a.getClass().hashCode());
			System.out.println(arr1.getClass().hashCode());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
