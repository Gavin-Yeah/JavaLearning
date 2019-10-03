package CollectionSort.com.jiada.sort.refType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsApp {
public static void main(String[] args) {
	List<Goods> list= new ArrayList<>();
	list.add(new Goods("xxx",39,122));
	list.add(new Goods("xxx",34,122));
	list.add(new Goods("xxx",233,12));
	list.add(new Goods("xxx",394,1));
	list.add(new Goods("xxx",39111,122));
	//排序前
	System.out.println(list);
	
	Collections.sort(list,new GoodsPriceComp());
	System.out.println(list);
	
}
}
