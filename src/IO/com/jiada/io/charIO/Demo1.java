package IO.com.jiada.io.charIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 纯文本读取
 * @author jiadaye
 *
 */
public class Demo1 {
public static void main(String[] args) {
	File src = new File("/Users/jiadaye/workspace/a.txt");
	Reader reader = null;
	try {
		reader = new FileReader(src);
		char [] flush = new char[10];
		int len=0;
		try {
			while(-1!=(len=reader.read(flush))) {
				//字符数组转成字符串
				String str = new String(flush,0,len);
				System.out.println(str);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件读取失败");
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("源文件不存在");
	} finally {
		if(null!=reader) {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
	}
	
}
}
