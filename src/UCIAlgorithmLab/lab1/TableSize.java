package UCIAlgorithmLab.lab1;

public class TableSize {

	public static void main(String[] args) {
		int [] key = new int[1000];
		for(int i=0;i<1000;i++) {
			key[i]=(int)(Math.random()*10000);
		}
		
		
		LinearHash lh1= new LinearHash(1000);
		LinearHash lh2= new LinearHash(2000);
		LinearHash lh3= new LinearHash(3000);
		LinearHash lh4= new LinearHash(1500);
		System.out.println("LinearHash size: 1000");
		tableSize(lh1,key);
		System.out.println("LinearHash size: 1500");
		tableSize(lh4,key);
		System.out.println("LinearHash size: 2000");
		tableSize(lh2,key);
		System.out.println("LinearHash size: 3000");
		tableSize(lh3,key);
		;
		
		System.out.println("---------------------------");
		ChainedHash ch1= new ChainedHash(1000);
		ChainedHash ch2= new ChainedHash(2000);
		ChainedHash ch3= new ChainedHash(3000);
		ChainedHash ch4= new ChainedHash(1500);
		System.out.println("ChainedHash size: 1000");
		tableSize(ch1,key);
		System.out.println("ChainedHash size: 1500");
		tableSize(ch4,key);
		System.out.println("ChainedHash size: 2000");
		tableSize(ch2,key);
		System.out.println("ChainedHash size: 3000");
		tableSize(ch3,key);
	
		
		System.out.println("---------------------------");
		CuckooHash cuh1= new CuckooHash(1000);
		CuckooHash cuh2= new CuckooHash(2000);
		CuckooHash cuh3= new CuckooHash(3000);
		CuckooHash cuh4= new CuckooHash(1500);
		System.out.println("CuckooHash size: 1000");
		tableSize(cuh1,key);
		System.out.println("CuckooHash size: 1500");
		tableSize(cuh4,key);
		
		System.out.println("CuckooHash size: 2000");
		tableSize(cuh2,key);
		System.out.println("CuckooHash size: 3000");
		tableSize(cuh3,key);
		
		DoubleHash dh1= new DoubleHash(1000);
		DoubleHash dh4= new DoubleHash(1500);
		DoubleHash dh2= new DoubleHash(2000);
		DoubleHash dh3= new DoubleHash(3000);
		
		
		System.out.println("DoubleHash size: 1000");
		tableSize(dh1,key);
		System.out.println("DoubleHash size: 1500");
		tableSize(dh4,key);
		System.out.println("DoubleHash size: 2000");
		tableSize(dh2,key);
		System.out.println("DoubleHash size: 3000");
		tableSize(dh3,key);
		
		
	}
	public static void tableSize(Hash table, int []key) {
	
		long startTime=System.nanoTime(); 
		for(int i=1;i<1000;i++) {
			table.set(i, key[i]);
			
		}
		long setTime= System.nanoTime()-startTime;
	    startTime=System.nanoTime();
		for(int i=1;i<1000;i++) {
	  table.search(key[i]);		
		}
		long searchTime=System.nanoTime()-startTime;
		 startTime=System.nanoTime();
	for(int i=1;i<1000;i++) {
		table.delete(key[i]);
	}
	long deleteTime=System.nanoTime()-startTime;
	
	System.out.println("set time is "+ setTime+"ns");
	System.out.println("search time is "+ searchTime+"ns");
	System.out.println("deletion time is "+ deleteTime+"ns");
	}
	

}
