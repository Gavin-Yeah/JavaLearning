package IO.com.jiada.io.buffered;
import java.io.BufferedReader;
import java.io.BufferedWriter;
/**
 * 字符缓冲流 +新增方法 不能多态
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class BufferedCharDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File src = new File("/Users/jiadaye/workspace/a.txt");
		File dest = new File("/Users/jiadaye/workspace/b.txt");
		BufferedReader reader = null;
		BufferedWriter wr = null;
		try {
			reader = new BufferedReader(new FileReader(src));
			wr=new BufferedWriter(new FileWriter(dest));
		//	char [] flush = new char[10];
		//	int len=0;
			//新增方法
			String line=null;
			while(null!=(line=reader.readLine())) {
				wr.write(line);
			//	wr.append("\r\n");
				wr.newLine();//换行符号
			}
		/*	try {
				while(-1!=(len=reader.read(flush))) {
					wr.write(flush, 0, len);
					
				}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("文件读取失败");
			}
			*/
			wr.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("源文件不存在");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if(null!=wr) {
				try {
					wr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
