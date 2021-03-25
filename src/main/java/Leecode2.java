package main.java;

import main.java.common.ListNode;

/**
 * @author sakura
 * @date: 2021/3/10 22:20
 * @description:
 */
public class Leecode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode();
        ListNode next = start;
        int ten = 0;
        while (l1 != null || l2 != null || ten != 0) {
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            int sum = l1.val + l2.val + ten;
            ten = sum / 10;
            ListNode next2 = new ListNode(sum % 10);
            next.next = next2;
            next = next2;
            l1 = l1.next;
            l2 = l2.next;
        }
        return start.next;
    }
}
