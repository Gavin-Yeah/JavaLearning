package CollectionSort.com.jiada.sort.innertype;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 排序
 * @author jiadaye
 *
 */
public class Utils {
	
	
/**
 * list泛型comparator	
 */

	public static <T extends Comparable<T>> void sort(List<T>list, Comparator <T>com) {
		Object [] arg= list.toArray();
		sort(arg,com);
		for(int i =0; i<list.size();i++) {
			list.set(i, (T)arg[i]);
		}
	}
	
	
	
	/**
	 * 数组排序降序 +Comparator
	 */
		public static  void sort(Object []arg,Comparator com) {
			boolean sorted=true;
			//3rd version
			for(int j=0;j<arg.length-1;j++) {
				sorted=true;
					for(int i=0;i<arg.length-1-j;i++) {
						
						if(com.compare(arg[i], arg[i+1])<0) {
							Object temp=arg[i];
							arg[i]=arg[i+1];
							arg[i+1]=temp;
							sorted=false;
						}	
					}
				
					
					if(sorted) {
						break;
					}
					
					
		}
			System.out.println(Arrays.toString(arg));
		}
	
	
	
	
	
/**
 * 数组排序降序
 */
	public static <T extends Comparable<T>> void sort(T []arg) {
		boolean sorted=true;
		//3rd version
		for(int j=0;j<arg.length-1;j++) {
			sorted=true;
				for(int i=0;i<arg.length-1-j;i++) {
					
					if(((Comparable)arg[i]).compareTo(arg[i+1])<0) {
						T temp=arg[i];
						arg[i]=arg[i+1];
						arg[i+1]=temp;
						sorted=false;
					}	
				}
			
				System.out.println(Arrays.toString(arg));
				if(sorted) {
					break;
				}
				
				
	}
	}
	/**
	 * 容器排序降序
	 */
		public static <T extends Comparable<T>> void sort(List <T>list) {
		Object [] arg= list.toArray();
		sort(arg);
		for(int i =0; i<list.size();i++) {
			list.set(i, (T)arg[i]);
		}
			
		
		}
		/**
		 * 数组排序降序
		 */
			public static  void sort(Object []arg) {
				boolean sorted=true;
				//3rd version
				for(int j=0;j<arg.length-1;j++) {
					sorted=true;
						for(int i=0;i<arg.length-1-j;i++) {
							
							if(((Comparable)arg[i]).compareTo(arg[i+1])<0) {
								Object temp=arg[i];
								arg[i]=arg[i+1];
								arg[i+1]=temp;
								sorted=false;
							}	
						}
					
						
						if(sorted) {
							break;
						}
						
						
			}
				System.out.println(Arrays.toString(arg));
			}
	
}
