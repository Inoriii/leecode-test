package main.java;

import java.util.*;

/**
 * @author sakura
 * @date: 2021/3/17 23:32
 * @description:
 */
public class LeetCode152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];

        maxF[0] = nums[0];
        minF[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(minF[i - 1] * nums[i], nums[i]));
            minF[i] = Math.min(maxF[i - 1] * nums[i], Math.min(minF[i - 1] * nums[i], nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < maxF.length; ++i) {
            ans = Math.max(maxF[i], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode152 leetCode90 = new LeetCode152();
        int[] nums = new int[]{0, 2};
        int ans = leetCode90.maxProduct(nums);
        System.out.println(ans);
    }
}
