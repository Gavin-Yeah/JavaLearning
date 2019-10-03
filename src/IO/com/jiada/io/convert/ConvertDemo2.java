package IO.com.jiada.io.convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * 转换流：字节转为字符
 * 1.输出流：OutputStreamWriter 编码
 * 2.输入流InputStreamReader 解码
 * @author jiadaye
 *
 */
public class ConvertDemo2 {
	public static void main(String[] args) throws IOException {
		//指定字符集
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
				new FileInputStream(new File("/Users/jiadaye/workspace/Demo2.java")),"utf-8"));
		//写出文件
		BufferedWriter bw=new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(new File("/Users/jiadaye/workspace/Demo3.java"))));
		String info=null;
		while(null!=(info=br.readLine())) {
			bw.write(info);
			bw.newLine();
		
		}
		bw.flush();
		br.close();
	}
}
