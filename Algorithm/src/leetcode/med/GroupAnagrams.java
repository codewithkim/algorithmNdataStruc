package leetcode.med;

import org.junit.jupiter.api.Test;

import java.util.*;

public class GroupAnagrams {
    @Test
    public void testMain() {
        System.out.println((groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"})));
        System.out.println((groupAnagrams(new String[]{""})));
        System.out.println((groupAnagrams(new String[]{"a"})));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arrC = str.toCharArray();
            Arrays.sort(arrC);
            String s = new String(arrC);
            if (!map.containsKey(s)) map.put(s, new ArrayList<>());
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
