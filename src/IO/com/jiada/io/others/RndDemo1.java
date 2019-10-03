package IO.com.jiada.io.others;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * 文件的分割思路
 * 1.分割的块数 size n块
 * 2.每一块的大小 blockSize
 * 最后 总的文件大小 （n-1）*blockSize
 * @author jiadaye
 *
 */
public class RndDemo1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile rnd = new RandomAccessFile("/Users/jiadaye/workspace/a.txt", "r");
		rnd.seek(10);
		//自定义缓冲大小
		byte[] flush =new byte[1024];
		//接收长度
		int len=0;
		while(-1!=(len=rnd.read(flush))) {
			if(len>=20) {
			System.out.println(new String(flush,0,20));
			break;
			}else {
				System.out.println(new String(flush,0,len));
			}
		}
		
		
		rnd.close();
	}

}
