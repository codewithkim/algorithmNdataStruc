package leetcode.med;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    @Test
    public void testMain() {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2))); //1,2
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));  //1
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,2,1,2,1,2,3,1,3,2}, 2))); //1,2
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        // corner case: if there is only one number in nums, we need the bucket has index 1.
        List<Integer>[] bucket = new List[nums.length+1];
        for(int n:map.keySet()){
            int freq = map.get(n);
            if(bucket[freq]==null)
                bucket[freq] = new LinkedList<>();
            bucket[freq].add(n);
        }

        int[] res = new int[k];
        int idx = 0;
        for(int i=bucket.length-1; i>0 && k>0 && idx < k; --i){
            if(bucket[i]!=null){
                for (int cur: bucket[i]) {
                    if (idx < k)
                        res[idx++] = cur;
                }
            }
        }

        return res;
    }

    public int[] topKFrequent_treeMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for(int num : map.keySet()){
            int freq = map.get(num);
            if(!freqMap.containsKey(freq))  freqMap.put(freq, new LinkedList<>());
            freqMap.get(freq).add(num);
        }

        int[] res = new int[k];
        int idx = 0;
        while(idx<k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            for (int cur : entry.getValue()) {
                res[idx++] = cur;
            }
        }
        return res;
    }

    public int[] topKFrequent_maxHeap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }

        int[] res = new int[k];
        int idx = 0;
        while(idx<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res[idx++] = entry.getKey();
        }
        return res;
    }


//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Num> map = new HashMap<>();
//        for (int cur : nums) {
//            Num num = map.getOrDefault(cur, new Num());
//            num.val += 1;
//            map.put(cur, num);
//        }
//
//
//        int[] result = new int[k];
//
//        return result;
//    }
//
//    class Num implements Comparable<Num> {
//        public int key;
//        public int val;
//        public Num() {
//            val = 0;
//        }
//
//        @Override
//        public int compareTo(Num o) {
//            return o.val;
//        }
//    }


//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int cur : nums) {
//            map.put(cur, map.getOrDefault(cur, 0)+1);
//        }
//
//        Map<Integer, Integer> sortedMap = map.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey, Map.Entry::getValue,
//                        (m1, m2) -> m1,
//                        LinkedHashMap::new
//                ));
//
//        int repeat = 0;
//        int[] result = new int[k];
//        for (int num: sortedMap.keySet()){
//            result[repeat] = num;
//            if (++repeat >= k) break;
//        }
//        return result;
//    }
}
