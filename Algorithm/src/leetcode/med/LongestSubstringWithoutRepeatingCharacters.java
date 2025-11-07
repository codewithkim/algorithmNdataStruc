package leetcode.med;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
import org.junit.jupiter.api.Test;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    @Test
    public void testMain() {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); //3
        System.out.println(lengthOfLongestSubstring("bbbbb")); //1
        System.out.println(lengthOfLongestSubstring("pwwkew")); //3
        System.out.println(lengthOfLongestSubstring("ancd")); //4
        System.out.println(lengthOfLongestSubstring("aan")); //2
        System.out.println(lengthOfLongestSubstring("abac")); //3
        // abcdefgg abcdeafg abcbdeafg abcdefg
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), maxLength = 0, left = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (int r = 0; r < n; r++) {
            if (!charMap.containsKey(s.charAt(r)) || charMap.get(s.charAt(r)) < left) {
                charMap.put(s.charAt(r), r);
                maxLength = Math.max(maxLength, r - left + 1);
            } else {
                left = charMap.get(s.charAt(r)) + 1;
                charMap.put(s.charAt(r), r);
            }
        }
        return maxLength;
    }


    public int lengthOfLongestSubstring_sol(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
                charMap.put(s.charAt(right), right);
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = charMap.get(s.charAt(right)) + 1;
                charMap.put(s.charAt(right), right);
            }
        }

        return maxLength;
    }


//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0)    return 0;
//        if (s.length() == 1)    return 1;
//
//        int result = 0, cur = 0;
//        int[] map = new int[500];
//        Arrays.fill(map, -1);
//        for (int i = 0; i < s.length(); i++) {
////            if (result > 0 && (cur + (s.length() - i)) < result) {
////                break;
////            }
//            int num = s.charAt(i);
//            if (map[num] > -1) {
//                if (cur > result)   result = cur;
//                cur = i - map[num] -1;
//                map = new int[500];
//            }
//            cur++;
//            map[num] = i;
//        }
//        if (result < cur)    result = cur;
//
//        return result;
//    }

//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0)    return 0;
//        if (s.length() == 1)    return 1;
//
//        int result = 0, cur = 0;
//        boolean[] map = new boolean[500];
//        for (int i = 0; i < s.length(); i++) {
////            if (result > 0 && (cur + (s.length() - i)) < result) {
////                break;
////            }
//            int num = s.charAt(i);
//            if (map[num]) {
//                if (cur > result)   result = cur;
//                cur = 0;
//                map = new boolean[500];
//            }
//            cur++;
//            map[num] = true;
//        }
//        if (result < cur)    result = cur;
//
//        return result;
//    }
}
