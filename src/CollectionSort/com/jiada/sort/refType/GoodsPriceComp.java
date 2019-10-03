package CollectionSort.com.jiada.sort.refType;
/**
 * 按价格排序 降序
 * @author jiadaye
 *
 */
public class GoodsPriceComp implements java.util.Comparator<Goods>{

	@Override
	public int compare(Goods o1, Goods o2) {
		// TODO Auto-generated method stub
		return -(o1.getPrice()-o2.getPrice()>0?1: o1.getPrice()-o2.getPrice()==0?0:-1);
	}

}
