package main.java;

import java.util.Arrays;

/**
 * @author sakura
 * @date: 2021/3/17 23:32
 * @description:
 */
public class LeetCode189 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        LeetCode189 leetCode90 = new LeetCode189();
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int ans = leetCode90.majorityElement(nums);
        System.out.println(ans);
    }
}
