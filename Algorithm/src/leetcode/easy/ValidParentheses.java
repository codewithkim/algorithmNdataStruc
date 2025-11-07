package leetcode.easy;
//https://leetcode.com/problems/valid-parentheses/description/?source=submission-ac

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ValidParentheses {
    @Test
    public void testMain() {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("["));
        System.out.println(isValid("]"));
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(')');
            } else if (c == '{') {
                st.push('}');
            } else if (c == '[') {
                st.push(']');
            } else if (st.size() == 0 || st.pop() != c) {
                return false;
            }
        }
        return st.isEmpty();
    }

    public boolean isValid_mine(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                st.push(cur);
            } else {
                if (st.size() == 0) return false;
                char prev = st.pop();
                switch (prev) {
                    case '(':
                        if (cur != ')')    return false;
                        break;
                    case '[':
                        if (cur != ']')    return false;
                        break;
                    case '{':
                        if (cur != '}')    return false;
                        break;
                }
            }
        }
        if (st.size() > 0)  return false;
        return true;
    }
}
