package IO.com.jiada.io.charIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 写出文件
 * @author jiadaye
 *
 */
public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建源
		File dest = new File("/Users/jiadaye/workspace/b.txt");
		Writer wr = null;
				try {
					//追加
					wr=new FileWriter(dest,true);
					//写出
					String msg="abcde/r/nfghijk/r/n";
					wr.write(msg);
					wr.append("dddddssdw");
					wr.flush();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if(null!=wr) {
						try {
							wr.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
	}

}
