package Collection.test;
/**
 * <> --> ������д��ĸ�������ܼ���֪��
 * T Type
 * K V Key Value
 * E Element
 *
 * @author jiada119
 *ָ�������Ͳ����ǻ�������
 *���Ͳ���ʹ���ھ�̬������ 
 */
public class MyStudent<T> {
	//�ɼ�
	private T javase;
	// private static T test; // ���Ͳ���ʹ���ھ�̬������ 
	public MyStudent() {
		
	}
	public MyStudent(T javase) {
		this.javase=javase;
	}
	public T getJavase() {
		return javase;
	}
	public void setJavase(T javase) {
		this.javase=javase;
	}
}
