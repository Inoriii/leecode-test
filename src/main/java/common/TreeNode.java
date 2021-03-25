package main.java.common;

/**
 * @author sakura
 * @date: 2021/3/20 16:47
 * @description:
 */
public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode() {
    }

    public TreeNode(T val) {
        this.val = val;
    }

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
