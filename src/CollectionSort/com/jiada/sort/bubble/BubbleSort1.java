package CollectionSort.com.jiada.sort.bubble;

import java.util.Arrays;

public class BubbleSort1 {
	public static void main(String[] args) {
		int [] arg = {9,8,7,6,5};
		bubbleSort(arg);
		
	}
	public static void bubbleSort(int arg[]) {
		//1st time
		for(int j=0;j<arg.length-1;j++) {
				for(int i=0;i<arg.length-1;i++) {
					
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
