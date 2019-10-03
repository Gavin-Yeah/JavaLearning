package CollectionSort.com.jiada.sort.innertype;
/**
 * 排序规则的业务类
 * @author jiadaye
 *
 */
public class StringComp implements java.util.Comparator<String>{
	/**
	 * 按长度比较
	 */
	@Override
	public int compare(String o1, String o2) {
		int len1=o1.length();
		int len2=o2.length();
		
		// TODO Auto-generated method stub
		return len1-len2;
	}

}
