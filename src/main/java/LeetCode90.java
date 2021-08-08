package main.java;

import java.util.*;

/**
 * @author sakura
 * @date: 2021/3/17 23:32
 * @description:
 */
public class LeetCode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        doSubsetsWithDup(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private Set<Map<Integer, Integer>> listSet = new HashSet<>();

    private void doSubsetsWithDup(int[] nums, List<List<Integer>> result, List<Integer> list, int i) {
        if (!contains(list)) {
            result.add(new ArrayList<>(list));
        }
        while (i < nums.length) {
            list.add(nums[i]);
            doSubsetsWithDup(nums, result, list, ++i);
            list.remove(list.size() - 1);
        }

    }

    private boolean contains(List<Integer> list) {
        Map<Integer, Integer> map2 = new HashMap<>();
        for (Integer i : list) {
            Integer integer = map2.computeIfAbsent(i, k -> 0);
            map2.put(i, ++integer);
        }
        if (!listSet.contains(map2)) {
            listSet.add(map2);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode90 leetCode90 = new LeetCode90();
        int[] nums = new int[]{4, 4, 4, 1, 4};
        List<List<Integer>> combine = leetCode90.subsetsWithDup(nums);
        System.out.println(combine);
    }
}
