package Collection.test.jiada.list;

import java.util.Stack;



class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private Integer front=null;
    /** Initialize your data structure here. */
    public MyQueue() {
         s1 = new Stack<>();
         s2 = new Stack<>();
        
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
       if(s1.isEmpty()) front=x;
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
           
        }
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        //  if(s2.empty()){
        //     while(!s1.empty()){
        //         s2.push(s1.pop());
        //     }   
        // }
        //  return s2.peek();
    	System.out.println(s2.size());
        if(!s2.isEmpty()) return s2.peek();
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    public static void main(String[] args) {
		MyQueue q= new MyQueue();
		q.push(1);
		q.push(2);
		System.out.println(q.peek());
		System.out.println(q.pop());
		System.out.println(q.empty());
	}
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */