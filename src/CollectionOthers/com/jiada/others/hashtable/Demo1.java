package CollectionOthers.com.jiada.others.hashtable;

import java.util.Properties;

/**
 * Properties 资源配置文件的读写
 * 1. key 与 value 只能是字符串
 * 2.存储与读取
 * setProperty(String key, String value)
 * getProperty(String key, String defaultValue)
 * @author jiadaye
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		//创建对象
		Properties pro = new Properties();
		//存储
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
	//	pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pwd", "tiger");
		//读取
		String url = pro.getProperty("url", "test");
		System.out.println(url);
	}
}
