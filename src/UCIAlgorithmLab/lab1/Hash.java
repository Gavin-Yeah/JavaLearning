package UCIAlgorithmLab.lab1;

public abstract class Hash{
	int size;
	int count;
	public abstract boolean delete(Integer key);
	public abstract void set(Integer key, Integer value);
	public abstract Integer search(Integer key);
}