package UCIAlgorithmLab.lab2;

import java.util.Random;


public class Treap extends Tree{
	private class node {
	        private Random randomObj = new Random();
	        int value;
	        node left; // Left child.
	        node right; // Right child.
	        double priority; // Priority.
	 
	        // Constructors.
	        node(int value) {
	        	   this.value= value;
	        	   left=nullNode;
	        	   right=nullNode;
		            priority = randomObj.nextDouble();  
	        }  
	        node() {
	        	   left=nullNode;
	        	   right=nullNode;
		            priority = randomObj.nextDouble();  
	        }  
	    }
	 private node root;
	 private node nullNode;
	 public Treap() {
		 nullNode = new node();
	     nullNode.left = nullNode.right = nullNode;
	     nullNode.priority = Integer.MAX_VALUE;
	     root=nullNode;
	}

	public void insert(int value) {
	        root = insert(value, root);
	    }

	  private node insert(int value, node t) {
	        if (t == nullNode) {
	            return new node(value);
	        }
	 
	        
	        if (value<t.value) {
	            t.left = insert(value, t.left);
	            if (t.left.priority < t.priority) {
	                t = rotateWithLeftChild(t);
	            }
	        } else if (t.left.priority > t.priority) {
	            t.right = insert(value, t.right);
	            if (t.right.priority < t.priority) {
	                t = rotateWithRightChild(t);
	            }
	        }
	        return t;
	    }
	  

	  public boolean search(int value) {  
		  return search(root, value);
		 }
		 
		 private boolean search(node node, int value) {
		  //terminate when the node is null and return false
		  if (node == nullNode) {
		   return false;
		  }
		  //when equal, reture true
		  if (node.value==value)
		   return true;
		  //when smaller, search left child
		  else if (value<node.value) {
		   return search(node.left, value);
		  }
		  //else search righr child
		  else {
		   return search(node.right, value);
		  }
		 }
		 
		 
		  public void delete(int value) {
		        root = delete(value, root);
		    }
		  private node delete(int value, node t) {
		        if (t != nullNode) {
		         
		            if (value < t.value) {
		                t.left = delete(value, t.left);
		            } else if (value > t.value) {
		                t.right = delete(value, t.right);
		            } else {
		                // Match found.
		                if (t.left.priority < t.right.priority) {
		                    t = rotateWithLeftChild(t);
		                } else {
		                    t = rotateWithRightChild(t);
		                }
		 
		                // Continue on down.
		                if (t != nullNode) {
		                    t = nullNode;
		                } else { // At a leaf.
		                    t.left = nullNode;
		                }

		                
		            }
		        }
		        return t;
		    }

	
	  
	  
	  
	  /**
	     * Rotate binary tree node with left child.
	     */
	    private node rotateWithLeftChild(node k2) {
	        node k1 = k2.left;
	        k2.left = k1.right;
	        k1.right = k2;
	        return k1;
	    }
	 
	    /**
	     * Rotate binary tree node with right child.
	     */
	    private node rotateWithRightChild(node k1) {
	        node k2 = k1.right;
	        k1.right = k2.left;
	        k2.left = k1;
	        return k2;
	    }



}
