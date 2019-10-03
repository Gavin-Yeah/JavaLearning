package Collection.test;
/**
 * ���ͽӿ�
 * ���Ͳ���ʹ����ȫ�ֱ�����
 * @author jiada119
 *
 * @param <T>
 */
public interface Comparator<T> {
	//ȫ�ֱ���
	/*public static final*/ int MAX_VALUE=1024;
	//�����ĳ��󷽷�
	/*public abstract*/ T compare(T t);
}
class  InteC1<A> implements Comparator{

	@Override
	public Object compare(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	}
class  InteC2<A> implements Comparator<Integer>{

	@Override
	public Integer compare(Integer t) {
		// TODO Auto-generated method stub
		return null;
	}

	
	}

	
class  InteC3<T,A> implements Comparator<T>{

	@Override
	public T compare(T t) {
		// TODO Auto-generated method stub
		return t;
	}}

