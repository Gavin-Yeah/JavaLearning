package IO.com.jiada.io.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File src = new File("/Users/jiadaye/workspace/a.txt");
		//InputStream is = new FileInputStream("E:/xp/test/a.txt");
		//InputStream is = new FileInputStream(src);
		InputStream is = null;//提升作用域
		 try {
			is = new FileInputStream(src);
			byte[] car = new byte[10];//缓冲数组
			int len=0;//接受实际读取大小
			//循环读取
			try {
				while(-1!=(len=is.read(car))) {
					String info= new String(car,0,len);
					System.out.println(info);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("读取文件失败");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件不存在");
		}finally {
			//释放资源
			if(null!=is) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("关闭文件输入流失败");
				}
			}
		}
		
	}

}
