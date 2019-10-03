package CollectionSort.com.jiada.sort.innertype;

import java.util.Arrays;

public class Demo2 {
public static void main(String[] args) {
	String []arg= {"a","abc","def","abcd","abc"};
	
	boolean sorted=true;
	//3rd version
	for(int j=0;j<arg.length-1;j++) {
		sorted=true;
			for(int i=0;i<arg.length-1-j;i++) {
				
				if(((Comparable)arg[i]).compareTo(arg[i+1])<0) {
					String temp=arg[i];
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




public static void bubbleSort(int arg[]) {
	//1st time
	for(int j=0;j<arg.length-1;j++) {
			for(int i=0;i<arg.length-1-j;i++) {
				
				if(arg[i]>arg[i+1]) {
					int temp=arg[i];
					arg[i]=arg[i+1];
					arg[i+1]=temp;
				}	
			}
			System.out.println(Arrays.toString(arg));
			
}
}
}
