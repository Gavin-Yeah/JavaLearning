package Collection.test.jiada.list;

public class SxtLinkedList {
	Node first;
	Node last;
	private int size;
	
	public void add(Object obj) {
	Node n = new Node();
	if(first == null) {

		n.setPrevious(null);
		n.setNext(null);
		n.setObj(obj);
		first=n;
		last=n;
	}
	else {
		n.setPrevious(last);
		n.setNext(null);
		n.setObj(obj);
		last.setNext(n);
		last=n;
	}
	size++;
}
	
	public Object get(int index) {
		rangeCheck(index);
		Node temp=node(index);
		
		if(temp!=null) {
		return temp.obj;
		}
		return null;
		
	}
	public void remove(int index) {
		rangeCheck(index);
		Node temp=node(index);
		if(temp!=null) {
		Node up=temp.previous;
		Node down=temp.next;
		up.next=down;
		down.previous=up;
		size--;
		}
	}
	

	public Node node(int index){
		Node temp = null;
		if(first!=null){
			if (index < (size >> 1)) {
				temp = first;
				for(int i=0;i<index;i++){
					temp = temp.next;
				}
			}else{
				temp = last;
	            for (int i = size - 1; i > index; i--){
	            	temp = temp.previous;
	            }
			}
			
		}
//		LinkedList l;
		return temp;
	}
	
	private void rangeCheck(int index) {
		if(index<0||index>=size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	public int size() {
		return size;
	}
	
	public void add(int index,Object obj){
		Node temp = node(index);
		
		Node newNode = new Node();
		newNode.obj = obj;
		
		if(temp!=null){
			Node up = temp.previous;
			up.next = newNode;
			newNode.previous = up;
			
			newNode.next = temp;
			temp.previous = newNode;
			
			size++;
		}
	}
	
	
	public static void main(String[] args) {
	SxtLinkedList list = new SxtLinkedList();
	list.add("aaa");
	list.add("bbb");
	list.add("ccc");
	list.add("ddd");
//	list.remove(1);
	Object a= list.node(1);
	System.out.println(list.get(1));
	}
}



