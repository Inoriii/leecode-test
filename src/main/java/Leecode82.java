package main.java;

import main.java.common.ListNode;
import main.java.util.ListNodeUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sakura
 * @date: 2021/3/25 21:02
 * @description:
 */
public class Leecode82 {
    Map<Integer, Integer> map = new HashMap<>();

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode start = new ListNode();
        start.next = head;
        while (head != null) {
            int i = map.computeIfAbsent(head.val, x -> 0);
            map.put(head.val, ++i);
            head = head.next;
        }
        doDelete(start);
        return start.next;
    }

    private void doDelete(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        Integer num = map.get(node.next.val);
        if (num != null && num > 1) {
            node.next = node.next.next;
            doDelete(node);
        } else {
            doDelete(node.next);
        }
    }

    public static void main(String[] args) {
        Leecode82 leecode82 = new Leecode82();
        int[] request = new int[]{1, 2, 3, 3, 4, 4, 5};
        ListNode listNode = leecode82.deleteDuplicates(ListNodeUtil.array2Tree(request));
        List<Integer> resultList = ListNodeUtil.listNode2List(listNode);
        System.out.println(resultList);
    }
}
