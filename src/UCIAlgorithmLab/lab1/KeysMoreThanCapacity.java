package UCIAlgorithmLab.lab1;

public class KeysMoreThanCapacity {
	public static void main(String[] args) {
	
		

	
	LinearHash lh= new LinearHash(50);
	
	System.out.println("LinearHash size: 50");
	test(lh);
	LinearHash lh2= new LinearHash(60);
	System.out.println("LinearHash size: 60");
	test(lh2);
	System.out.println("---------------------------");
	ChainedHash ch= new ChainedHash(50);
	
	System.out.println("ChainedHash size: 50");
	test(ch);
ChainedHash ch2= new ChainedHash(60);
	
	System.out.println("ChainedHash size: 60");
	test(ch2);

	
	System.out.println("---------------------------");
	CuckooHash cuh= new CuckooHash(50);
	
	
	System.out.println("CuckooHash size: 50");
	test(cuh);
CuckooHash cuh2= new CuckooHash(60);
	
	
	System.out.println("CuckooHash size: 60");
	test(cuh2);
	System.out.println("---------------------------");
	DoubleHash dh= new DoubleHash(50);
	
	System.out.println("DoubleHash size: 50");
	test(dh);
DoubleHash dh2= new DoubleHash(60);
	
	System.out.println("DoubleHash size: 60");
	test(dh2);
	
	
}
public static void test(Hash table) {

	long startTime=System.nanoTime(); 
	for(int i=1;i<=60;i++) {
		table.set(i, i);
		
	}
	long setTime= System.nanoTime()-startTime;
  
System.out.println("set time is "+ setTime+"ns");

}
}
