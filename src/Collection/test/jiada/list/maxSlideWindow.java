package Collection.test.jiada.list;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class maxSlideWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] k= maxSlidingWindow(new int[] {1,3,1,2,0,5},3);
		for(int a:k) {
			System.out.println(a);
		
		}
			List<Integer> l=new ArrayList<>();	
			l.add(5);
			l.add(2);
			l.add(3);
			l.sort((Integer a, Integer b)-> a-b);
			System.out.println(l);
		
	}
	  public static int[] maxSlidingWindow(int[] nums, int k) { 
	        if(nums.length==0) return new int[0];
	         Deque<Integer> window= new LinkedList<>(); 
	        int []res= new int[nums.length-k+1];  
	      for(int i=0;i<nums.length;i++){
	          if(i>=k&&window.peek()<=i-k){
	              window.poll();
	          }
	          while(!window.isEmpty()&&nums[window.peekLast()]<=nums[i]){
	              window.pollLast();
	          }
	          window.offer(i);
	          if(i>=k-1){
	              res[i-k+1]=nums[window.peek()];
	          }
	      }
	        return res;
	    }
}
