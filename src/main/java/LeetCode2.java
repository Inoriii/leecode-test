package main.java;

import main.java.common.ListNode;
import main.java.util.ListNodeUtil;

/**
 * @author sakura
 * @date: 2021/3/10 22:20
 * @description:
 */
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode();
        ListNode nowNode = resultNode;
        int i = 0;
        while (l1 != null || l2 != null || i != 0) {
            if (l1 == null && l2 == null) {
                nowNode.next = new ListNode(i);
                i = 0;
            } else if (l1 == null) {
                if (i == 0) {
                    nowNode.next = l2;
                } else {
                    int sum = l2.val + i;
                    i = sum / 10;
                    nowNode.next = new ListNode(sum % 10);
                }
            } else if (l2 == null) {
                if (i == 0) {
                    nowNode.next = l1;
                } else {
                    int sum = l1.val + i;
                    i = sum / 10;
                    nowNode.next = new ListNode(sum % 10);
                }
            } else {
                int sum = l1.val + l2.val + i;
                i = sum / 10;
                nowNode.next = new ListNode(sum % 10);
            }
            nowNode = nowNode.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return resultNode.next;
    }

    public static void main(String[] args) {
        LeetCode2 leetCode2 = new LeetCode2();
        int[] i1 = new int[]{9, 9, 9, 9, 9, 9, 9};
        int[] i2 = new int[]{9, 9, 9, 9};
        ListNode listNode = leetCode2.addTwoNumbers(ListNodeUtil.array2Tree(i1), ListNodeUtil.array2Tree(i2));
        System.out.println(listNode);
    }
}
