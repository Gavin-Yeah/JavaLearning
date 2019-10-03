package xml.src.com.jiada.xml;

import java.io.Serializable;

public class Num implements Serializable{
	public Num() {
		super();
		// TODO Auto-generated constructor stub
	}

	// format the code command+shift+f
	private String id;
	private int num;
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Num(String id, int num, String type) {
		super();
		this.id = id;
		this.num = num;
		this.type = type;
	}
}
