package CollectionOthers.com.jiada.others.hashtable;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用properties读取配置文件
 * 资源配置文件
 * load(InputStram inStream)
	load(Reader reader)
		load(InputStream in)
 * @author jiadaye
 *
 */
public class Demo3 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
	//	pro.load(new FileReader("e:/other/db.properties"));
		pro.load(new FileReader("src/db.properties"));
//		pro.load(new FileReader("src/com/jiada/others/hashtable/db.properties"));
		
		System.out.println(pro.getProperty("user", "bjxst"));
	}
}
