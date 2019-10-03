package Annotation.com.jiada.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解的信息，模拟处理注解信息的流程
 * 
 * @author jiadaye
 *
 */
public class demo03 {

	/**
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		try {
			Class clz= Class.forName("com.jiada.annotation.Student");
			//获得类的所有注解
			Annotation[] annotations=clz.getAnnotations();
			for(Annotation a:annotations) {
				System.out.println(a);
			}
			//获得类的指定的注解
			Table t=(Table)clz.getAnnotation(Table.class);
			System.out.println(t.value());
			//获得烈的属性的注解
			Field f = clz.getDeclaredField("studentName");
			SxtField sxtField= f.getAnnotation(SxtField.class);
			System.out.println(sxtField.columnName()+"--"+sxtField.length());
			//根据获得的表明，字段的信息，拼出ddl语句，使用jdbc执行这个sql，在数据库中生成相关的表
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
