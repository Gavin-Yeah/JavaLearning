package UCIAlgorithmLab.lab1;

public class CuckooHash extends Hash{
	private final int size; //table size
	private int count=0;  //number of elements
	Integer [][]values=new Integer[2][];//value array [hash #][value index]
	Integer [][]keys=new Integer[2][];//key array [hash #][key index]
	public CuckooHash(int size){
		if(size%11!=0&&size%17!=0) {  //because the prime number is 11 and 17, the size cannot be 11 or 17
			this.size = size;
			}
			else {
				this.size=10000;
				System.out.println("the size cannot be 11 or 17 because of hash function, it is changed to 1000");
				
			}
	     values[0]=new Integer[this.size];
	      keys[0]= new Integer[this.size];
	      values[1]= new Integer[this.size];
	      keys[1]= new Integer[this.size];
	  }
	  public CuckooHash() {
		this(10000);
	}
	  private int hash(int t, int num) {
		
		  if(num<0) {    //if the key is negative, turn it into positive num to get the index
				num=-num;
			}	
		  if(t==0)return num*11%(size-1);   //hash function 0
			else return num*17%(size-1);//hash function 1
	
		}
	
	  public Integer search(Integer key) {
		int index[]= new int[2];
		 index[0]=hash(0,key);
		 index[1]=hash(1,key);
	
		if(keys[0][index[0]]!=null&&keys[0][index[0]].equals(key)) {
		
			return values[0][index[0]];
		}else if(keys[1][index[1]]!=null&&keys[1][index[1]].equals(key)) {
		
			return values[1][index[1]];
		}
		return null;		  
	  }
	  public boolean delete(Integer key) {
		  int index0=hash(0,key);
			int index1=hash(1,key);
			if(keys[0][index0]!=null&&keys[0][index0].equals(key)) {
				 values[0][index0]=null;
				 keys[0][index0]=null;
				 count--;
				 return true;
			}else if(keys[1][index1]!=null&&keys[1][index1].equals(key)) {
				 values[1][index1]=null;
				 keys[1][index1]=null;
				 count--;
				 return true;
			}
			return false;		  
	  }
	 public void set(Integer key, Integer value) {
		 if(size==count) {
			   System.out.println("the table is full");
			   return;
		   }
		 Integer index[]= new Integer[2];
		 index[0]=hash(0,key);
		 index[1]=hash(1,key);

		 int t=0;
		 if(keys[t][index[t]]==null) {
			keys[t][index[t]]=key;
			values[t][index[t]]=value;
			 count++;
			return;
		 }else if(keys[0][index[0]]!=null&&(keys[0][index[0]].equals(key))) {
			 values[t][index[t]]=value;
			 return;
		 } else if(keys[1][index[1]]!=null&&(keys[1][index[1]].equals(key))) {
			 values[1][index[1]]=value;
			 return;
		 }
		 int num=0;
		
		 count++;
		 while(keys[t][index[t]]!=null) {
			 Integer [][]origKey=keys;
			 Integer [][]origVal=values;
			 if(num==size*2) {  //the loop number is more than limit
				System.err.println("enter loop");
				keys=origKey;
				values=origVal;
				count--; //decrement the element number because insertion error
				 return;
			 }
			 
			 Integer tempKey=keys[t][index[t]];
			 Integer tempVal=values[t][index[t]];
			 keys[t][index[t]]=key;
			 values[t][index[t]]=value;
		
			 t=1-t;
			key=tempKey;
			value=tempVal;
			index[t]=hash(t, key);
			num++;	
		 }
		//after there is an available place for the new key
		 keys[t][index[t]]=key; 
		 values[t][index[t]]=value;
		
	 }

}
