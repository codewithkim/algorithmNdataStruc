package leetcode.easy;

import org.junit.jupiter.api.Test;

public class PalindromeNumber {
    @Test
    public void testMain() {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    public boolean isPalindrome(int x) {
        if (x < 0)  return false;
        int t = 0, d = x;
        while (x > 0) {
            t = t*10 + x%10;
            x /= 10;
        }
        if (t == d) return true;
        return false;
    }

    public boolean isPalindrome_my_org(int x) {
        if (x < 0)  return false;
        String str = String.valueOf(x);

//        System.out.println(str);
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) == str.charAt(j)) continue;
            return false;
        }
        return true;
    }
}
