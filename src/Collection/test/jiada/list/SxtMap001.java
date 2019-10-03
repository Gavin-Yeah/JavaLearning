package Collection.test.jiada.list;
/**
 * �Զ���ʵ��Map ����
 * @author jiada119
 *
 */
public class SxtMap001 {
	SxtEntry [] arr = new SxtEntry [990];
	int size;
		public void put(Object key,Object value) {
			//�����ֵ�ظ��Ĵ���
			for(int i=0;i<size;i++) {
				if(arr[i].key.equals(key)) {
					arr[i].value=value;
					return;
				}
			}
			
			SxtEntry e = new SxtEntry(key, value);
			arr[size++] = e;
		}
		public Object get(Object key) {
			for(int i=0;i<size;i++) {
				if(arr[i].key.equals(key)) {
					return arr[i].value;
				}
			}
			return null;
		}
		public boolean containKey(Object key) {
			for(int i=0;i<size;i++) {
				if(arr[i].key.equals(key)) {
					return true;
				}
			}
			return false;
		}
		public boolean containValue(Object value) {
			for(int i=0;i<size;i++) {
				if(arr[i].value.equals(value)) {
					return true;
				}
			}
			return false;
		}
		public static void main(String[] args) {
			SxtMap001 m = new SxtMap001();
			m.put("jiada", new friend("gavin"));
			m.put("jielun", new friend("jay"));
			m.put("jielun", new friend("day"));
		   friend f=  (friend) m.get("jielun");
		   System.out.println(f.name);
		}
}
class SxtEntry{
	Object key;
	Object value;
	public SxtEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
}
