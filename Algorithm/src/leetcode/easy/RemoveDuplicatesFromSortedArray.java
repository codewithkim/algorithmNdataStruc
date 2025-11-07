package leetcode.easy;
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?source=submission-ac

import org.junit.jupiter.api.Test;

public class RemoveDuplicatesFromSortedArray {
    @Test
    public void testMain() {
        int[] nums = new int[]{1,1,2}; // Input array
        int[] expectedNums = new int[]{1,2}; // The expected answer with correct length
//        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4}; // Input array
//        int[] expectedNums = new int[]{0,1,2,3,4}; // The expected answer with correct length

        int k = removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    public int removeDuplicates(int[] nums) {
        int result = 0, repeat = 0;
        int prev = -10000;
        for (int i = 0; i < nums.length; i++) {
            nums[i-repeat] = nums[i];
            if (prev != nums[i]) {
                result++;
                prev = nums[i];
            } else {
                repeat++;
            }
        }
        return result;
    }
}
