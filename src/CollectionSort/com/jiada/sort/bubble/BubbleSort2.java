package CollectionSort.com.jiada.sort.bubble;

import java.util.Arrays;

public class BubbleSort2 {
	public static void main(String[] args) {
		int [] arg = {4,9,8,7,6,5};
		bubbleSort(arg);
		System.out.println("----------------");
		arg=new int[] {5,9,1,2,3,4};
		bubbleSortFinal(arg);
	}
	public static void bubbleSort(int arg[]) {
		//2nd version
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
	public static void bubbleSortFinal(int arg[]) {
		boolean sorted=true;
		//3rd version
		for(int j=0;j<arg.length-1;j++) {
			sorted=true;
				for(int i=0;i<arg.length-1-j;i++) {
					
					if(arg[i]>arg[i+1]) {
						int temp=arg[i];
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
}
