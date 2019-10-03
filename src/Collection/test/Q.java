package Collection.test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack= new Stack<>();
		
		Queue<Integer> a = new LinkedList<>();
		
		
		Deque<Integer> b=new LinkedList<>();
		b.addFirst(1);
		b.addLast(2);
		b.removeFirst();
		b.removeLast();
		
	}

}
