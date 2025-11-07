package leetcode.med;
// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

import org.junit.jupiter.api.Test;

public class KthLargestElementInArray {
    @Test
    public void testMain() {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));  // 5
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));    // 4

    }

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length-1, k-1);
    }

    private int quickSort(int[] nums, int s, int e, int k) {
        int p = partition(nums, s, e);
        if (p == k) return nums[p];
        else if (p > k) return quickSort(nums, s, p - 1, k);
        else return quickSort(nums, p + 1, e, k);
    }

    private int partition(int[] nums, int s, int e) {
        int p = s-1;
        for (int i = s; i < e; i++) {
            if (nums[e] < nums[i]) {
                swap(nums, i, ++p);
            }
        }
        swap(nums, e, ++p);
        return p;
    }

    private void swap(int[] nums, int s, int e) {
        int t = nums[s];
        nums[s] = nums[e];
        nums[e] = t;
    }

}
