package CollectionOthers.com.jiada.others.en;

import java.util.StringTokenizer;

/**
 * Enumeration子类
 * StringTokenizer:String split() 字符串分割
 * 不支持正则表达式
 * StringTokenizer(String st, String delim)
 * @author jiadaye
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		String emailStr ="jiada@qq.com;ced@163.com;ccc@google.com";
		StringTokenizer token = new StringTokenizer(emailStr,";");
		//遍历获取
		while(token.hasMoreElements()) {
			System.out.println(token.nextElement());
		}
		
	}
}
