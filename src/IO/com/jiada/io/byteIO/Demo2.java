package IO.com.jiada.io.byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.建立联系 file 对象 目的地
		File dest =new File("/Users/jiadaye/workspace/b.txt");
		//2.选择流 文件输出流 OutputStream FileOutputStream
		OutputStream os = null;
		//以 追加 形式写出文件
		try {
			os = new FileOutputStream(dest,true);
			//operation
			String str ="jiada is really good";
			//字符串转字节数组
			byte[] data=str.getBytes();
			try {
				os.write(data,0,data.length);
				os.flush();//强制刷新出去
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("file write failure");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件未找到");
		}
		finally {
			if(null!=os) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("关闭输出流失败");
				}
			}
		}
		
	}

}
