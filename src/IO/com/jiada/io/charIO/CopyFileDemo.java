package IO.com.jiada.io.charIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CopyFileDemo {
public static void main(String[] args) {
		File src = new File("/Users/jiadaye/workspace/a.txt");
		File dest = new File("/Users/jiadaye/workspace/b.txt");
		Reader reader = null;
		Writer wr = null;
		try {
			reader = new FileReader(src);
			wr = new FileWriter(dest);
			char[] flush = new char[1024];
			int len = 0;
			try {
				while (-1 != (len = reader.read(flush))) {
					wr.write(flush, 0, len);

				}
				wr.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("文件读取失败");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("源文件不存在");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if (null != wr) {
				try {
					wr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (null != reader) {
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
