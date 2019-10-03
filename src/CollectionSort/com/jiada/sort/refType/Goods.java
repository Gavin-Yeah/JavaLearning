package CollectionSort.com.jiada.sort.refType;

public class Goods {
	private String name;
	private double price;
	private int fav;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getFav() {
		return fav;
	}
	public void setFav(int fav) {
		this.fav = fav;
	}
	public Goods(String name, double price, int fav) {
		super();
		this.name = name;
		this.price = price;
		this.fav = fav;
	}
	@Override
	public String toString() {
		return "Goods [name=" + name + ", price=" + price + ", fav=" + fav + "]";
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
