package UCIAlgorithmLab.lab1;

public class DoubleHash extends Hash{
	private final int size;
	private int count=0;
	private Integer [] keys;
	private Integer [] values;
	public DoubleHash(int size) {
		if(size!=11) {
			this.size = size;
			}
			else {
				this.size=10000;
				System.out.println("the size cannot be 11 because of hash function, it is changed to 1000");
				
			}
		keys=new Integer [size];
		values= new Integer [size];
	}

	public DoubleHash() {
		this(10000);//the tolerant hashitable size is 10000;
	}
	   public void set(Integer key, Integer value) { 
		   if(size==this.count) {
			   System.out.println("the table is full");
			   return;
		   }
	        int index = hashCode(key);
	        int num=0;
	        while (keys[index] != null && !key.equals(keys[index])) {//when it collides
	            index=(index+hashCode2(key))%size;  
	            num++;
	            if(num>this.size) {
	            	System.out.println("Set the Key "+key+" failure");
	            	return;
	            }
	        }
	        if (keys[index] == null) {
	            keys[index] = key;
	            values[index] = value;
	            count++;
	            return;
	        }
	        values[index] = value;
	    }
	
	   public Integer search(Integer key) {
	        int index = hashCode(key);
	        int count=0;
	        while (keys[index]!=null && !key.equals(keys[index])) {
	            index  =(index+hashCode2(key))%size;
	            count++;
	            if(count>this.size) {
	            	System.out.println("there is no such a key"+key);
	            	return null;
	            }
	        }
	        return values[index]; // if the value exists, retuen value;else return -1
	    }
	   public boolean delete(Integer key) {
		   int index = hashCode(key);
		   int count=0;
		   while (keys[index]!=null && !key.equals(keys[index])) {
	            index  =(index+hashCode2(key))%size;
			   count++;
	            if(count==this.count) {
	            	System.out.println("there is no such a key");
	            	return false;
	            }
	        }
		   if(keys[index]!=null && key.equals(keys[index])) {
			   keys[index]=null;
			   values[index]=null;
			   count--;
			   return true;
		   }
		   
		   return false;
		   
	   }
	   
	   
		private int hashCode(int num) {
			if(num<0) {    //if the key is negative, turn it into positive num to get the index
				num=-num;
			}
			return num*17%(this.size);
			
		}
		private int hashCode2(int num) {
			if(num<0) {    //if the key is negative, turn it into positive num to get the index
				num=-num;
			}
			return num*11%(this.size);
			
		}
}
