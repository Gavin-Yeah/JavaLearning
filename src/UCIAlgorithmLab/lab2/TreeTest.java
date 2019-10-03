package UCIAlgorithmLab.lab2;

public class TreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Treap treap= new Treap();
		AVLTree avl= new AVLTree();
		BinarySearchTree bst=new BinarySearchTree();
		SkipList sl=new SkipList();
		int []num=new int[2000];//500 1000 1500 2000
		for(int i=0;i<2000;i++) {//500 1000 1500 2000
			num[i]=i;
		//	num[i]=(int)(Math.random()*100000);
			
		}
		
		
		SequentialAddTest(bst,num);
		SequentialSearchTest(bst,num);
		SequentialDeleteTest(bst,num);
		
		SequentialAddTest(avl,num);
		SequentialSearchTest(avl,num);
		SequentialDeleteTest(avl,num);
		
		SequentialAddTest(sl,num);
		SequentialSearchTest(sl,num);
		SequentialDeleteTest(sl,num);
		
		SequentialAddTest(treap,num);
		SequentialSearchTest(treap,num);
		SequentialDeleteTest(treap,num);
		
	}
public static void SequentialAddTest(Tree tree,int[] num) {
	long insertTime;
	long startTime=System.nanoTime(); 
	for(int i=0;i<num.length;i++) {
		tree.insert(num[i]);
		
	}
	insertTime= System.nanoTime()-startTime;
	System.out.println(tree.getClass()+" insert time is"+insertTime);
}
public static void SequentialSearchTest(Tree tree,int[] num) {
	long insertTime;
	long startTime=System.nanoTime(); 
	for(int i=0;i<num.length;i++) {
		tree.search(num[i]);
		
	}
	insertTime= System.nanoTime()-startTime;
	System.out.println(tree.getClass()+" search time is"+insertTime);
}
public static void SequentialDeleteTest(Tree tree,int[] num) {
	long insertTime;
	long startTime=System.nanoTime(); 
	for(int i=0;i<num.length;i++) {
		tree.delete(num[i]);
		
	}
	insertTime= System.nanoTime()-startTime;
	System.out.println(tree.getClass()+" delete time is"+insertTime);
}
}
