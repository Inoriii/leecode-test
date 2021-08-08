package main.java;

import main.java.common.TreeNode;
import main.java.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sakura
 * @date: 2021/3/21 22:57
 * @description:
 */
public class LeetCode107_1 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, root, 1);
        Collections.reverse(result);
        return result;
    }

    private void dfs(List<List<Integer>> result, TreeNode root, int treeHeight) {
        if (root == null) {
            while (result.size() < treeHeight - 1) {
                result.add(new ArrayList<>());
            }
            return;
        }
        dfs(result, root.left, treeHeight + 1);
        dfs(result, root.right, treeHeight + 1);
        List<Integer> list = result.get(treeHeight - 1);
        list.add((Integer) root.val);
    }

    public static void main(String[] args) {
        LeetCode107_1 leecode107 = new LeetCode107_1();
        Integer[] request = new Integer[]{3, 9, 20, null, null, 15, 7};
        List<List<Integer>> result = leecode107.levelOrderBottom(TreeNodeUtil.array2Tree(request));
        System.out.println(result);
    }
}
