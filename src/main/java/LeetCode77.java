package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sakura
 * @date: 2021/3/17 22:35
 * @description:
 */
public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        doCombine(n, k, new ArrayList<>(), result, 1);
        return result;
    }

    private void doCombine(int n, int k, List<Integer> list, List<List<Integer>> result, int i) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        while (i <= n) {
            if (list.contains(i)) {
                ++i;
                continue;
            }
            list.add(i);
            doCombine(n, k, list, result, ++i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode77 leetCode77 = new LeetCode77();
        List<List<Integer>> combine = leetCode77.combine(4, 2);
        System.out.println(combine);
    }
}
