package leetcode.easy;
//https://leetcode.com/problems/two-sum/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

        System.out.print(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));  //1,2
//        System.out.print(Arrays.toString(twoSum(new int[]{3, 2, 3}, 6)));  //0,2
//        System.out.print(Arrays.toString(twoSum(new int[]{-1,-2,-3,-4,-5}, -8))); //2,4
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i< nums.length; i++) {
            int cur = nums[i];
            int x= target - cur;
            if (map.containsKey(x) && map.get(x) != i) {
                return new int[]{i, map.get(x)};
            }
        }

        return null;
    }

    public static int[] twoSum_1(int[] nums, int target) {
        int result[] = new int[2];

        loop1: for (int i = 0; i< nums.length; i++) {
            int first = nums[i];

            for (int j = i+1; j < nums.length; j++) {
                if (first + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break loop1;
                }
            }
        }

        return result;
    }
}
