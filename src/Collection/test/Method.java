package Collection.test;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * �Ƿ������ж��巺�ͷ���
 * ���壺�ڷ�������ǰ��<��ĸ>
 * @author jiada119
 *
 */
public class Method {
public static <T> void test(T t) {
	System.out.println(t);
}
public static<T extends List> void  test(T t) {
	System.out.println(t);
	t.add("aaa");
}
//�ͷ���Դ
public static<T extends Closeable> void test(T...a) {
	for(T temp:a) {
		if(null!=temp) {
			try {
				temp.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
	public static void main(String[] args) throws FileNotFoundException {
		test("fff");
		test(new FileInputStream("a.txt"));
	}
}
