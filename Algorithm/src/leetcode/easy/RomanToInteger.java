package leetcode.easy;
// https://leetcode.com/problems/roman-to-integer/description/?source=submission-ac

import org.junit.jupiter.api.Test;

import java.util.Map;

public class RomanToInteger {
    @Test
    public void testMain() {
        System.out.println(romanToInt("III")); //3
        System.out.println(romanToInt("LVIII")); //58
        System.out.println(romanToInt("MCMXCIV")); //1994
    }
    /*Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000*/
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('M', 1000, 'C', 100, 'X', 10, 'D', 500, 'L', 50, 'V', 5, 'I', 1);
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int num1 = map.get(s.charAt(i));
            int num2 = (i < s.length()-1) ? map.get(s.charAt(i + 1)) : 0;
            if (num1 >= num2)
                result += num1;
            else {
                result += num2 - num1;
                i++;
            }
        }

        return result;
    }
}
