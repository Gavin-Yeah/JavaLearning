package UCIAlgorithmLab.lab2;

import java.util.Random;

public class SkipList extends Tree{
	private class node {
		int value;
		node up, down, left, right; 
		static final int HEAD_value = Integer.MIN_VALUE; // negative infinity
		static final int TAIL_value = Integer.MAX_VALUE; // infinity

		node(int num) {
			value = num;
		}
	}

	private node head, tail;
	private int listLevel;
	private Random random;// for random probability
	private static final double PROBABILITY = 0.5;// the boudry to level up

	public SkipList() {
		random = new Random();
		head = new node(node.HEAD_value);
		tail = new node(node.TAIL_value);
		horizontalLink(head, tail);
		listLevel = 0;
	}

	    //find the bottom node before the value node 
	    
	    private node findNode(int value){
	        node p=head;
	        while(true){
	            while (p.right.value!=node.TAIL_value&&p.right.value<=value) {
	                p=p.right;
	            }
	            if (p.down!=null) {
	                p=p.down;
	            }else {
	                break;
	            }
	 
	        }
	        return p;
	    }
	   
	    public boolean search(int num){
	        node p=findNode(num);
	        if (p.value==num) {
	            return true;
	        }else {
	     
	            return false;
	        }
	    }

	   
	 
	    public void insert(int value){
	        node p=findNode(value);
	        if (value==p.value) {
	        	System.out.println("the value exists: "+value);
	            return;
	        }
	        node q=new node(value);
	        backLink(p, q);
	        int currentLevel=0;
	     
	        while (random.nextDouble()<PROBABILITY) {
	            //if the level is higher than the listLevel
	            if (currentLevel>=listLevel) {
	                listLevel++;
	                node p1=new node(node.HEAD_value);
	                node p2=new node(node.TAIL_value);
	                horizontalLink(p1, p2);
	                vertiacallLink(p1, head);
	                vertiacallLink(p2, tail);
	                head=p1;
	                tail=p2;
	            }
	            //find the upper neighbor
	            while (p.up==null) {
	                p=p.left;
	            }
	            p=p.up;
	 
	            node e=new node(value);//new node with value
	            backLink(p, e);//insert the node after the p
	            vertiacallLink(e, q);
	            q=e;
	            currentLevel++;
	        }
	    }
	    public void delete(int value) {
	    	node p=findNode(value);
	    	 if (value!=p.value) {
		         System.out.println("there is no value "+value);  
	    		 return;
		        }
	    	 unlink(p);
	    	 
	    }
	    //insert node2 after node1
	    private void backLink(node node1,node node2){
	        node2.left=node1;
	        node2.right=node1.right;
	        node1.right.left=node2;
	        node1.right=node2;
	    }
	   
	    private void horizontalLink(node node1,node node2){
	        node1.right=node2;
	        node2.left=node1;
	    }
	   
	    private void vertiacallLink(node node1,node node2){
	        node1.down=node2;
	        node2.up=node1;
	    }
	    private void unlink(node node){
	    	 node.left.right=node.right;
		      node.right.left=node.left;
	    	if(node.up==null)return;
	        unlink(node.up);
	        node=null;
	    }


}
