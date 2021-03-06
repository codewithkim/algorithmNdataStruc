// https://www.acmicpc.net/problem/11650

package backjun.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TwoDSort_11650 {
	
	static int N;
	static TreeMap<Integer, ArrayList<Integer>> arr =  new TreeMap<Integer, ArrayList<Integer>>();
	
	public static void main(String[] args) {
		getIn();
		arr.comparator();
		
		Iterator<Integer> keys = arr.keySet().iterator();
		while(keys.hasNext()) {
			var key = keys.next();
			var value = arr.get(key);

			value.stream()
				.sorted(Comparator.naturalOrder())
				.forEach(i -> System.out.println(key +" "+ i));
		}
	}
	
	public static void getIn() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int k, v;
		for(int i=0; i<N; i++) {
			k = sc.nextInt();
			v = sc.nextInt();
			if(arr.containsKey(k)) {
				arr.get(k).add(v);
			}else {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(v);
				arr.put(k, temp);
			}
		}
		sc.close();
	}

}
