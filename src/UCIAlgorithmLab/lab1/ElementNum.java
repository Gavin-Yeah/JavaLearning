package UCIAlgorithmLab.lab1;

/**
 * because the java machine mechanics, for each insertion number, it should be run one by one.
 * @author jiadaye
 *
 */
public class ElementNum {

	public static void main(String[] args) {
		int [] key = new int[3000];
		for(int i=0;i<3000;i++) {
			key[i]=(int)(Math.random()*10000);
		}
		
		
		
		LinearHash lh1= new LinearHash(3000);
		LinearHash lh2= new LinearHash(3000);
		LinearHash lh3= new LinearHash(3000);
		LinearHash lh4= new LinearHash(3000);
	
//		System.out.println("LinearHash ElementNum: 1000");
//		element(lh1,1000,key);
//		System.out.println("LinearHash ElementNum:1500");
//		element(lh2,1500,key);
//		System.out.println("LinearHash ElementNum:2000");
//		element(lh3,2000,key);
		System.out.println("LinearHash ElementNum: 2500");
		element(lh4,2500,key);
	
		
		System.out.println("---------------------------");
		ChainedHash ch1= new ChainedHash(3000);
		ChainedHash ch2= new ChainedHash(3000);
		ChainedHash ch3= new ChainedHash(3000);
		ChainedHash ch4= new ChainedHash(3000);
		ChainedHash ch5= new ChainedHash(3000);
//		System.out.println("ChainedHash ElementNum: 1000");
//		element(ch1,1000,key);
//		System.out.println("ChainedHash ElementNum: 1500");
//		element(ch2,1500,key);
//		System.out.println("ChainedHash ElementNum: 2000");
//		element(ch3,2000,key);
		System.out.println("ChainedHash ElementNum: 2500");
		element(ch4,2500,key);
		
		System.out.println("---------------------------");
		CuckooHash cuh1= new CuckooHash(3000);
		CuckooHash cuh2= new CuckooHash(3000);
		CuckooHash cuh3= new CuckooHash(3000);
		CuckooHash cuh4= new CuckooHash(3000);
		
//		System.out.println("CuckooHash ElementNum: 1000");
//		element(cuh1,1000,key);
//		System.out.println("CuckooHash ElementNum: 1500");
//		element(cuh2,1500,key);
//		System.out.println("CuckooHash ElementNum: 2000");
//		element(cuh3,2000,key);
		System.out.println("CuckooHash ElementNum: 2500");
		element(cuh4,2500,key);
		
		DoubleHash dh1= new DoubleHash(3000);
		DoubleHash dh4= new DoubleHash(3000);
		DoubleHash dh2= new DoubleHash(3000);
		DoubleHash dh3= new DoubleHash(3000);


		System.out.println("---------------------------");
//		System.out.println("DoubleHash ElementNum: 1000");
//		element(dh1,1000,key);
//		System.out.println("DoubleHash ElementNum:1500");
//		element(dh2,1500,key);
//		System.out.println("DoubleHash ElementNum:2000");
//		element(dh3,2000,key);
		System.out.println("DoubleHash ElementNum: 2500");
		element(dh4,2500,key);

	
	}
	public static void element(Hash table, int num,int key[]) {
		
		long startTime=System.nanoTime(); 
		for(int i=0;i<num;i++) {
			table.set(i, key[i]);
			
		}
		long setTime= System.nanoTime()-startTime;
	    startTime=System.nanoTime();
		for(int i=0;i<num;i++) {
	  table.search(key[i]);		
		}
		long searchTime=System.nanoTime()-startTime;
		 startTime=System.nanoTime();
	for(int i=0;i<num;i++) {
		table.delete(key[i]);
	}
	long deleteTime=System.nanoTime()-startTime;
	
	System.out.println("set time is "+ setTime+"ns");
	System.out.println("search time is "+ searchTime+"ns");
	System.out.println("deletion time is "+ deleteTime+"ns");
	}
	

}
