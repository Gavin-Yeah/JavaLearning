package CollectionOthers.com.jiada.others.hashtable;

import java.io.IOException;
import java.util.Properties;

/**
 * 使用相对路径读取配置文件
 * bin
 * @author jiadaye
 *
 */
public class Demo4 {
	public static void main(String[] args) throws IOException {
		Properties pro = new Properties();
		//类相对路径 / bin
		//pro.load(Demo4.class.getResourceAsStream("/com/jiada/others/hashtable/db.properties"));
		// "" 表示 bin
		pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/jiada/others/hashtable/db.properties"));
		System.out.println(pro.getProperty("user", "bjxst"));
	}
}
