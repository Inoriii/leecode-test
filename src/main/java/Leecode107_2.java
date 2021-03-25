package main.java;

import main.java.common.TreeNode;
import main.java.util.TreeNodeUtil;

import java.util.*;

/**
 * @author sakura
 * @date: 2021/3/21 22:57
 * @description:
 */
public class Leecode107_2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        bfs(queue, 1, result);
        Collections.reverse(result);
        return result;
    }

    private void bfs(Queue<TreeNode> queue, int size, List<List<Integer>> result) {
        List<Integer> list = new ArrayList<>();
        result.add(list);
        for (int i = 0; i < size; i++) {
            TreeNode remove = queue.remove();
            list.add((Integer) remove.val);
            TreeNode lTreeNode = remove.left;
            TreeNode rTreeNode = remove.right;
            if (lTreeNode != null) {
                queue.add(lTreeNode);
            }
            if (rTreeNode != null) {
                queue.add(rTreeNode);
            }
        }
        if (queue.size() != 0) {
            bfs(queue, queue.size(), result);
        }
    }

    public static void main(String[] args) {
        Leecode107_2 leecode107 = new Leecode107_2();
        Integer[] request = new Integer[]{3, 9, 20, null, null, 15, 7};
        List<List<Integer>> result = leecode107.levelOrderBottom(TreeNodeUtil.array2Tree(request));
        System.out.println(result);
    }
}
