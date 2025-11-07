package leetcode.easy;
//https://leetcode.com/problems/longest-common-prefix/description/

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LongestCommonPrefix {

    @Test
    public void testMain() {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flowet"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        Arrays.sort(strs);
        int size = Math.min(strs[0].length(), strs[strs.length-1].length());
        for (int i = 0; i < size; i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                break;
            }
            sb.append(strs[0].charAt(i));
        }

        return sb.toString();
    }

    public String longestCommonPrefix_mine_first(String[] strs) {
        StringBuffer sb = new StringBuffer("");

        loop1: for (int i = 0; i < strs[0].length(); i++) {
            try {
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].charAt(i) != strs[0].charAt(i)) {
                        break loop1;
                    }
                }
                sb.append(strs[0].charAt(i));
            } catch (Exception e) {
                break;
            }
        }

        return sb.toString();
    }
}
