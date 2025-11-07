package leetcode.easy;
// https://leetcode.com/problems/remove-element/description/?source=submission-ac

import org.junit.jupiter.api.Test;
// https://leetcode.com/problems/remove-element/submissions/1818019333/?source=submission-ac

public class RemoveElement {
    @Test
    public void testMain() {
//        removeElement(new int[]{3, 2, 2, 3}, 3);
//        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
        System.out.println(removeElement(new int[]{0,1,2,3,2,0,4,2}, 2));
    }

    public int removeElement(int[] nums, int val) {
        int result = 0, lastIdx = 0;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] != val) {
                nums[lastIdx++] = nums[i];
                result++;
            }
        }
        return result;
    }
}
