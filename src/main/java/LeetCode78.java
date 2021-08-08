package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sakura
 * @date: 2021/3/17 22:35
 * @description:
 */
public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        doCombine(nums, new ArrayList<>(), result, 0);
        return result;
    }

    private void doCombine(int[] nums, List<Integer> list, List<List<Integer>> result, int i) {
        result.add(new ArrayList<>(list));
        while (i < nums.length) {
            list.add(nums[i]);
            doCombine(nums, list, result, ++i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode78 leetCode78 = new LeetCode78();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> combine = leetCode78.subsets(nums);
        System.out.println(combine);
    }
}
