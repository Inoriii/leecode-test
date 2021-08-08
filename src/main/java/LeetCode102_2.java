package main.java;

import main.java.common.TreeNode;
import main.java.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sakura
 * @date: 2021/3/20 18:05
 * @description:
 */
public class LeetCode102_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            List<Integer> list = doBFS(queue, queue.size());
            result.add(list);
        }
        return result;
    }

    private List<Integer> doBFS(Queue<TreeNode> queue, int size) {
        List<Integer> list = new ArrayList<>();
        for (; size > 0; size--) {
            TreeNode peek = queue.remove();
            if (peek.left != null) {
                queue.offer(peek.left);
            }
            if (peek.right != null) {
                queue.offer(peek.right);
            }
            list.add((Integer) peek.val);
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode102_2 leecode102 = new LeetCode102_2();
        Integer[] request = new Integer[]{3, 9, 20, null, null, 15, 7};
        List<List<Integer>> result = leecode102.levelOrder(TreeNodeUtil.array2Tree(request));
        System.out.println(result);
    }
}
