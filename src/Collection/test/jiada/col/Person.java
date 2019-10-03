package Collection.test.jiada.col;

public class Person {
private final String name;
private final int handsome;
public Person(String name, int handsome) {
	super();
	this.name = name;
	this.handsome = handsome;
}
public Person() {
	name=null;
	handsome=0;
	
	// TODO Auto-generated constructor stub
}
public String getName() {
	return name;
}

public int getHandsome() {
	return handsome;
}

@Override
public String toString() {
	return "Person [name=" + name + ", handsome=" + handsome + "]";
}


}
