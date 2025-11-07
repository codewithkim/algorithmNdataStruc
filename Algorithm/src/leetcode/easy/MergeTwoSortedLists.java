package leetcode.easy;
// https://leetcode.com/problems/merge-two-sorted-lists/?source=submission-ac

import org.junit.jupiter.api.Test;

import java.util.List;

public class MergeTwoSortedLists {

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    @Test
    public void testMain() {
//        mergeTwoLists(makeListNode(List.of(1, 2, 4)), makeListNode(List.of(1, 3, 4)));
        mergeTwoLists(makeListNode(List.of()), makeListNode(List.of()));
        mergeTwoLists(makeListNode(List.of()), makeListNode(List.of(0)));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode next = head;
        while (list1 != null || list2 != null) {
            int num1 = list1 == null ? Integer.MAX_VALUE : list1.val;
            int num2 = list2 == null ? Integer.MAX_VALUE : list2.val;
            if (num1 < num2) {
                next.next = new ListNode(num1);
                list1 = list1.next;
            } else {
                next.next = new ListNode(num2);
                list2 = list2.next;
            }
            next = next.next;
        }
        return head.next;
    }

    public ListNode makeListNode(List<Integer> l1) {
        ListNode head = new ListNode(0);
        ListNode next = head;
        for (int cur : l1) {
//            next.val = cur;
//            next.next = new ListNode();
            next.next = new ListNode(cur);
            next = next.next;
        }
//        next = null;
        return head.next;
    }
}
