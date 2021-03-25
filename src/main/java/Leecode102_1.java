package main.java;

import main.java.common.TreeNode;
import main.java.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sakura
 * @date: 2021/3/20 16:49
 * @description:
 */
public class Leecode102_1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        doResult(result, root, 0);
        return result;
    }

    private void doResult(List<List<Integer>> result, TreeNode root, int i) {
        if (root == null) {
            return;
        }
        while ((result.size() <= i)) {
            result.add(new ArrayList<>());
        }
        List<Integer> list = result.get(i);
        list.add((Integer) root.val);
        doResult(result, root.left, ++i);
        --i;
        doResult(result, root.right, ++i);
    }

    public static void main(String[] args) {
        Leecode102_1 leecode102 = new Leecode102_1();
        Integer[] request = new Integer[]{3, 9, 20, null, null, 15, 7};
        List<List<Integer>> result = leecode102.levelOrder(TreeNodeUtil.array2Tree(request));
        System.out.println(result);
    }
}
