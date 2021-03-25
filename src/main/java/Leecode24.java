package main.java;

import main.java.common.ListNode;

/**
 * @author sakura
 * @date: 2021/3/11 22:45
 * @description:
 */
public class Leecode24 {
    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode();
        start.next = head;
        swapPairsInfo(start);
        return start.next;
    }

    public void swapPairsInfo(ListNode start) {
        ListNode head = start.next;
        if (head == null) {
            return;
        }
        ListNode m = head.next;
        if (m == null) {
            return;
        }
        ListNode n = m.next;
        start.next = m;
        m.next = head;
        head.next = n;
        swapPairsInfo(head);
    }

}
