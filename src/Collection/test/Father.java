package Collection.test;
/**
 * ���͸���
 * ��������Ϊ�����������Ϳɱȸ���ࣩ
 * ������д�����游�����
 * ���ุ�������游�����
 * @author jiada119
 *
 */
public abstract class Father<T1,T2> {
	T1 age;
	public void test(T2 name) {
		// TODO Auto-generated method stub
		
	}
	
}

//����  ��������
//1.ȫ������ 
class c1<T1,T2> extends Father<T1,T2>{
	public void test(T2 name) {};
	T1 age;
}
//2.���ֱ���
class c4 <T2,T3,A,B> extends Father<Integer,T2>{
	@Override
	public void test(T2 name) {};
	Integer age;
}
//������ ����ִ��
//1.��������
class c3 extends Father<Integer,String>{
	@Override
	public void test(String name) {};

}
//2.û������ ���� ������Object
class c2 extends Father{
	Object age;
	@Override
	public void test(Object name) {};

}
public