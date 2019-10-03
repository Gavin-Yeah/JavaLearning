package Annotation.com.jiada.annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo01 /*extends Object*/{
	@Override
	public String toString() {
		return null;
		
	}
	public static void main(String[] args) {
		Date date= new Date();
		date.parse("dd");
		test01();
	}
	@Deprecated
	public static void test01() {
		System.out.println("test01");
	}
	public static void test02() {
		@SuppressWarnings("all")
		List list=new ArrayList();
		
		List list2=new ArrayList();
		
	}
}
