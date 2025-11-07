package leetcode.med;
//https://leetcode.com/problems/add-two-numbers/description/?source=submission-ac

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode ln1 = setInput(List.of(2,4,3));
        ListNode ln2 = setInput(List.of(5,6,4));
//        9 + 9999999991
//        ListNode ln1 = setInput(List.of(9));
//        ListNode ln2 = setInput(List.of(1,9,9,9,9,9,9,9,9,9));

        System.out.println(addTwoNumbers(ln1, ln2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode next = head;
        int carry = 0;

        while (l1 != null || l2 != null | carry != 0) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + carry;
            int val = sum % 10;
            carry = sum / 10;

            next.next = new ListNode(val);
            next = next.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        ListNode result = head.next;
        next.next = null;
        return result;
    }












    public static ListNode addTwoNumbers_ans(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }

    public static ListNode addTwoNumbers_my_org(ListNode l1, ListNode l2) {
        long numL1 = getNum(l1);
        long numL2 = getNum(l2);
        long num = numL1 + numL2;

        ListNode result = new ListNode();
        List<ListNode> list = new ArrayList<>();
        while (num / 10L >= 1) {
            list.add(new ListNode((int) (num%10L)));
            num = num / 10L;
        }
        list.add(new ListNode((int)(num%10L)));
        // 7,0,8
        for (int i = 0; i < list.size(); i++) {
            ListNode cur = list.get(i);
            if (i == 0) {
                result = cur;
            }
            if (i < list.size() -1)
                cur.next = list.get(i + 1);
        }

        return result;
    }

    public static long getNum(ListNode curL) {
        long num = 0;
        int pow = 0;
        while (curL.next != null) {
            num += curL.val * (long) Math.pow(10, pow++);
            curL = curL.next;
        }
        num += curL.val * (long) Math.pow(10, pow);

        return num;
    }

    public static ListNode setInput(List<Integer> list) {
        List<ListNode> listLn = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listLn.add(new ListNode(list.get(i)));
        }
        ListNode result = new ListNode();
        for (int i = 0; i < list.size(); i++) {
            ListNode cur = listLn.get(i);
            if (i == 0) {
                result = cur;
            }
            if (i < list.size() -1)
                cur.next = listLn.get(i + 1);
        }
        return result;
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


