package leetcode.med;

import org.junit.jupiter.api.Test;

import java.util.*;

public class SubarraySumEqualsK {

    @Test
    public void testMain() {
        System.out.println(subarraySum(new int[]{1}, 0));  //0
        System.out.println(subarraySum(new int[]{-1, -1, 1}, 0));  //1
        System.out.println(subarraySum(new int[]{1,1,1}, 2));  //2
        System.out.println(subarraySum(new int[]{1,2,3}, 3));  //2
        System.out.println(subarraySum(new int[]{1}, 1));  //1
        System.out.println(subarraySum(new int[]{1}, 0));  //1
        System.out.println(subarraySum(new int[]{1,2,3,4,5,6}, 100));  //0
        System.out.println(subarraySum(new int[]{0,0,0,1}, 1));  //4
    }

    public int subarraySum(int[] nums, int k) {
        int result = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) result += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return result;
    }
}
