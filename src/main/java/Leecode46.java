package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author sakura
 * @date: 2021/3/13 17:45
 * @description:
 */
public class Leecode46 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, false);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> info = new ArrayList<>();
        doa(nums, map, res, info);
        return res;
    }

    private void doa(int[] nums, HashMap<Integer, Boolean> map, List<List<Integer>> res, List<Integer> info) {
        if (info.size() == nums.length) {
            res.add(new ArrayList<>(info));
            return;
        }
        for (int num : nums) {
            if (!map.get(num)) {
                info.add(num);
                map.put(num, true);
                doa(nums, map, res, info);
                info.remove(info.size() - 1);
                map.put(num, false);
            }
        }
    }

    public static void main(String[] args) {
        Leecode46 leecode46 = new Leecode46();
        int[] i = {1, 2, 3};
        List<List<Integer>> permute = leecode46.permute(i);
        System.out.println(permute);
    }
}
