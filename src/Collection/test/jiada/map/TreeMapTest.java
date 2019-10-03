package Collection.test.jiada.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Map<Integer,Integer>map=new TreeMap<Integer,Integer>();
LinkedList<Integer> list= new LinkedList<>();

map.put(3, 2);
map.put(2, 6);
map.put(5, 1);
	Iterator<Entry<Integer,Integer>> it= map.entrySet().iterator();
while(it.hasNext()) {
	System.out.println(it.next().getKey());
}
	;
	}
	

}
class MapValueComparator implements Comparator<Entry<Integer,Integer>> {

    @Override
    public int compare(Entry<Integer,Integer> me1, Entry<Integer,Integer> me2) {

        return me1.getValue().compareTo(me2.getValue());
    }
}

