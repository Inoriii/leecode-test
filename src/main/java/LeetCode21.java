package main.java;

import main.java.common.ListNode;

/**
 * @author sakura
 * @date: 2021/3/10 22:41
 * @description:
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode start = new ListNode();
        ListNode next = start;
        while (true) {
            if (l1 == null) {
                next.next = l2;
                break;
            }
            if (l2 == null) {
                next.next = l1;
                break;
            }
            if (l1.val > l2.val) {
                next.next = l2;
                next = next.next;
                l2 = l2.next;
            } else {
                next.next = l1;
                next = next.next;
                l1 = l1.next;
            }
        }
        return start.next;
    }
}
