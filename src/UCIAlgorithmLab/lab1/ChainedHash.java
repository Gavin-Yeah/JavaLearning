package UCIAlgorithmLab.lab1;

import java.util.LinkedList;

public class ChainedHash extends Hash{
	private final int size;
	private int count=0;
	private LinkedList<Entry> [] arr; 

	public ChainedHash() {
	this(10000);//the hashitable size is 100000;
	}

	
	public ChainedHash(int size) {
		if(size!=11) {
		this.size = size;
		}
		else {
			this.size=1000;
			System.out.println("the size cannot be 11 because of hash function, it is changed to 1000");
			
		}
		arr = new LinkedList [this.size]; 
	}
	public void set(Integer key,Integer value) {  //Scan through the collection. If pair with key k is found, replace it. Else, add the pair (k,v) to the collection.
		
		Entry e = new Entry(key, value);
		int a = hashCode(key);
		
	if(arr[a]==null) {
		LinkedList<Entry> list =new LinkedList<Entry>();
		arr[a]=list;
		list.add(e);
		count++;
	}else {
		LinkedList<Entry> list= arr[a];
		for(int i=0;i<list.size();i++) {
			Entry e2 = (Entry) list.get(i);
			if(e2.key==key) {
				e2.value=value;  
				return;
			}
		}
		arr[a].add(e);
		count++;
	}
	}
	public Integer search(Integer key) {//Scan through the collection, looking for pair with key k.
		int a= hashCode(key);
		if(arr[a]!=null) {
			LinkedList<Entry> list = arr[a];
			for(int i=0;i<list.size();i++) {
				Entry e = (Entry) list.get(i);
				if(e.key==key) {
					return e.value; 
				}
			}
		}
		return null;
	}
	public boolean delete(Integer key) {    //Scan through the collection. If pair with key k is found, remove it.
		int a=hashCode(key);
		if(arr[a]!=null) {
			LinkedList<Entry> list = arr[a];
			for(int i=0;i<list.size();i++) {
				Entry e = (Entry) list.get(i);
				if(e.key==key) {
					list.remove(e);
					count--;
					return true;
				}
			}
		}
		return false;
	}
	
	private int hashCode(Integer num) {
		if(num<0) {    //if the key is negative, turn it into positive num to get the index
			num=-num;
		}
		return num*11%size;
		
	}
	
	
	

}
class Entry{
	int key;
	int value;
	public Entry(Integer key, Integer value) {
		this.key = key;
		this.value = value;
	}
}
