/**
 * 
 */
package study;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author hjd
 * @date 2016年8月7日
 */
public class CollectTest {
	
	
	public static <T extends Comparable<T>> T max(Collection<T> c){
		if(c.isEmpty()) throw new NoSuchElementException();
		Iterator<T> iterator = c.iterator();
		T largest = iterator.next();
		while(iterator.hasNext()){
			T next = iterator.next();
			if(largest.compareTo(next) <0 )
				largest = next;
		}
		return largest;
	}

	public static void main(String[] args){
//		String[] arr = new String[]{"12","b","54"};
		List<String> list = new ArrayList<>();
		list.add("ds");
		list.add("1222");
		System.out.println(max(list));
	}
}
