package Collection.test;
/**
 * �Զ��巺�����ʹ�ã�������ʱָ�����������
 * ���͵Ĳ�������Object ����ͬ��Object
 * @author jiada119
 *
 */
public class MyStuApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStudent<Integer> stu = new MyStudent<Integer>();
		//stu.setJavase("����");
		//��ȫ�����ͼ��
		stu.setJavase(80);
		Integer score = stu.getJavase();
		MyStudent stu2 = new MyStudent();
		stu2.setJavase(100);// 100 -> int -> Integer -> Object
		//���Ͳ��� û��ָ������ ����Object
		MyStudent <Object>stu3 = new MyStudent<Object>();
		test1(stu3);
		test1(stu2);
		test(stu2);
	}
	public static void test(MyStudent<Integer> stu) {
		
	}
public static void test1(MyStudent stu) {
		
	}

}
}
