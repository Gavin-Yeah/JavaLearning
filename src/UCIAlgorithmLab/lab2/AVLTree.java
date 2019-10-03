package UCIAlgorithmLab.lab2;

public class AVLTree extends Tree{
	private class node {//the private internal class node

		 public int value; 
		 public node left, right;
		 public int height;
		
		 public node(int value) {
		 this.value = value;
		 left = null;
		 right = null;
		 height = 1;
		 }
		}
	 private node root; 
	 public AVLTree() { //constructor
	  root = null;  
	 }
	 
	
	 private int getHeight(node node) {
	  if (node == null)
	   return 0;
	  return node.height;
	 } 
	
	 private int getBalanceFactor(node node) {
	 if (node == null)
	 return 0;
	 return getHeight(node.left) - getHeight(node.right);
	 }
	
	 //get the minimum child of the node
	 private node minimum(node node) {
	  if (node.left == null)
	   return node;
	  return minimum(node.left);
	 }
	 
	
	 private node rightRotate(node y) {
	  node x = y.left;
	  node z = x.right;

	  x.right = y;
	  y.left = z;

	  y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
	  x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

	  return x;
	 }

	 private node leftRotate(node y) {
	  node x = y.right;
	  node z = x.left;

	  x.left = y;
	  y.right = z;

	  y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
	  x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

	  return x;
	 }
	 //insert an element
	 public void insert(int value) {
	  root = insert(root, value);
	 }
	 //after insertion, balance the tree and compute the balance factor
	 private node insert(node node, int value) {
	  if (node == null) {
	  return new node(value);
	  }
	  if (value<node.value)
	  node.left = insert(node.left, value);
	  else if (value>node.value)
	  node.right = insert(node.right, value);
	  else
	  node.value = value;
	  //the height equals to the max node height +1
	  node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
	  int balanceFactor = getBalanceFactor(node);

	  
	  if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0)
	  return rightRotate(node);


	  if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0)
	  return leftRotate(node);


	  if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
	  node.left = leftRotate(node.left);
	  return rightRotate(node);
	  }

	  if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
	  node.right = rightRotate(node.right);
	  return leftRotate(node);
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
	 


	 public void delete(int value) {
	  root = delete(root, value);
	 
	 }
	 
	 private node delete(node node, int value) {
	  if (node == null)
	  return null;
	  node retNode;
	  if (value<node.value) {
	  node.left = delete(node.left, value);
	  retNode = node;
	  } else if (value>node.value) {
	  node.right = delete(node.right, value);
	  retNode = node;
	  } else {
	  if (node.left == null) {
	   node rightNode = node.right;
	   node.right = null;
	   retNode = rightNode;
	  } else if (node.right == null) {
	   node leftNode = node.left;
	   node.left = null;
	   retNode = leftNode;
	  } else {
	  node successor = minimum(node.right);
	  successor.right = delete(node.right, successor.value);
	  successor.left = node.left;
	  node.left = node.right = null;
	  retNode = successor;
	  }
	  }
	  
	  if(retNode == null)
	  return null;
	  
	  retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
	  int balanceFactor = getBalanceFactor(retNode);

	  // balance the tree
	 
	  if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0)
	  return rightRotate(retNode);

	  if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0)
	  return leftRotate(retNode);

	
	  if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
	  retNode.left = leftRotate(retNode.left);
	  return rightRotate(retNode);
	  }


	  if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
	  retNode.right = rightRotate(retNode.right);
	  return leftRotate(retNode);
	  }

	  return retNode;
	 }
	 
	 
	 

	 }


	