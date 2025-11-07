package leetcode.easy;
// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/?source=submission-ac
import org.junit.jupiter.api.Test;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    @Test
    public void testMain() {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
