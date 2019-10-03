package Collection.test.jiada.list;

import java.util.Date;

public class SxtArrayList /*implements List*/ {
	
	private Object[] elementData;
	
	private int size;
	public SxtArrayList() {
	this(10);	
	}
	public SxtArrayList(int initialCapacity) {
		if(initialCapacity<0) {
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
		elementData =new Object [initialCapacity];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	private void rangeCheck(int index) {
		if(index<0||index>=size) {
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
	
	public Object get(int index) {
		rangeCheck(index);
		return elementData[index];
	}
	public void remove(Object obj) {
		for(int i=0;i<size;i++) {
			if(get(i).equals(obj)) {  //���õ�equal ����������==
				remove(i);
			break;
			}
		}
	}
	
	public void remove(int index) {
		rangeCheck(index);
		int numMoved = size-index-1;
		if(numMoved>0) {
			System.arraycopy(elementData, index+1, elementData, index, numMoved);
			elementData[--size]=null; //let gc do it work.
		}
	}
	private void ensureCapacity() {
		//��������
		if(size==elementData.length) {
			Object[] newArray= new Object[size*2];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
	}
	public void add(Object obj) {
		ensureCapacity();
		elementData[size++]=obj;
		
	}
	
	public Object set(int index, Object obj) {
		rangeCheck(index);
		Object old = elementData[index];
		elementData[index]=obj;
		return old;
	}
	
	public void add(int index, Object obj) {
		rangeCheck(index);
		ensureCapacity();
		System.arraycopy(elementData, index, elementData, index+1, size-index);
		elementData[index]=obj;
		size++;
	}
	public static void main(String[] args) {
		SxtArrayList list = new SxtArrayList();
		list.add("aaa");



		list.add(123);
		list.add(new Date());
		list.add(new dog());
		for(int i=0;i<list.size;i++)
			System.out.println(list.get(i));
		System.out.println(list.size());
		list.remove("aaa");
		for(int i=0;i<list.size;i++)
		System.out.println(list.get(i));
	}
	
}
