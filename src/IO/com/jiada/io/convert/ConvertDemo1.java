package IO.com.jiada.io.convert;

import java.io.UnsupportedEncodingException;

public class ConvertDemo1 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String str="中国";
		//编码char-》byte
		byte[] data =str.getBytes();
		//字节数不完整
		System.out.println(new String(data,0,3));
		
	}
	/**
	 * 编码与解码必须统一
	 * @throws UnsupportedEncodingException 
	 */
	public static void test1() throws UnsupportedEncodingException {
		//解码byte -》char
		String str="中国";
		//编码char-》byte
		byte[] data =str.getBytes();
		//编码与解码字符集统一
		System.out.println(new String(data));
		data = str.getBytes("gbk");//设定编码字符集
		//不统一出现乱码
		System.out.println(new String(data));
		
		byte[]data2= "中国".getBytes("utf-8");
		//解码
		str=new String(data2,"utf-8");
		System.out.println(str);
	}

}
