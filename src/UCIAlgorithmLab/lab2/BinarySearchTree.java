package UCIAlgorithmLab.lab2;

public class BinarySearchTree extends Tree {
	private node root;

	
public BinarySearchTree() {
		root=null;
		
	}

private class node{
	node left;
	node right;
	int value;
	public node(int value) {
		this.value = value;
		left=null;
		right=null;
	}
	
}





public void insert(int num) { //add an element into the tree, using an internal private function
	root=insert(root,num);
	
}

	private node insert(node node, int num) {
//when the node is null, return the new node as the insertion element
		if (node == null) {
			return new node(num);
		}
//if the insertion node value is less tham this node value, search the left child
		if (num < node.value) {
			node.left = insert(node.left, num);
		}
		//if the insertion node value is bigger than this node value, search the right child
		else if (num > node.value) {
			node.right = insert(node.right, num);
		}
		return node;
	}


	public boolean search(int value) {  
		  return search(root, value);
		 }
		 
		 private boolean search(node node, int value) {
		  //terminate when the node is null and return false
		  if (node == null) {
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



public void delete(int num) {
	root=delete(root,num);
	
}
 
 private node delete(node node, int value) {
  //termination condition
  if (node == null) {
	  System.out.println("deletion failure");
   return null;
  }
  //the input value is smaller than the node value, search the left child
  if (value<node.value) {
   node.left = delete(node.left, value);
   return node;
  }
  //the input value is bigger than the node value, search the right child
  else if (value>node.value) {
   node.right = delete(node.right, value);
   return node;
  }
  //the node equals to the deletion node
  else {
   // the left child of deletion node is null
   if (node.left == null) {
    node rightNode = node.right;
    node.right = null;
    return rightNode;
   }

   // the right child is null
   if (node.right == null) {
    node leftNode = node.left;
    node.left = null;
    return leftNode;
   }
   //the left and right child is not null
   node successor = new node(minimum(node.right).value);

   successor.right = deleteMin(node.right);
   successor.left = node.left;

   node.left = node.right = null;

   return successor;
  }
 }

  private node deleteMin(node node) {
	   if (node.left == null) {
	    node rightNode = node.right;
	    node.right = null;
	    return rightNode;
	   }
	   node.left = deleteMin(node.left);
	   return node;
	  }
  private node minimum(node node) {
		if (root==null)
			throw new IllegalArgumentException("Tree is empty");
		if (node.left == null)
			return node;
		return minimum(node.left);
	}


}
