package IO.com.jiada.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 封装输入
 * @author jiadaye
 *
 */
public class Bufferedin {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream is = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println("请输入：");
		String msg = br.readLine();
		System.out.println(msg);
	
	}

}
