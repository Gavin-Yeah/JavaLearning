package UCIAlgorithmLab.lab1;

public class LinearHash extends Hash{
	private final int size;
	private Integer [] keys;
	private Integer [] values;
	private int count=0;
	public LinearHash(int size) {
		if(size!=11) {
			this.size = size;
			}
			else {
				this.size=10000;
				System.out.println("the size cannot be 11 because of hash function, it is changed to 1000");
				
			}
		keys=new Integer [this.size];
		values= new Integer [this.size];
	}

	public LinearHash() {
		this(10000);//the hashitable size is 100000;
	}
	   public void set(Integer key, Integer value) { 
		   if(size==count) {
			   System.out.println("the table is full");
			   return;
		   }
	        int index = hashCode(key);
	        while (keys[index] != null && !key.equals(keys[index])) {
	            index = (index + 1) % size;
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
	        int num=0;
	        while (keys[index]!=null && !key.equals(keys[index])) {
	            index = (index + 1) % size;
	            num++;
	            if(num>2*this.size) {
	            	System.out.println("there is no such a key"+key);
	            	return null;
	            }
	        }
	        return values[index]; // if the value exists, retuen value;else return null
	    }
	   public boolean delete(Integer key) {
		   int index = hashCode(key);
		   int num=0;
		   while (keys[index]!=null && !key.equals(keys[index])) {
	            index = (index + 1) % size;
	            num++;
	            if(num==2*this.count) {
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
			return num*11%size;
			
		}
}
