package main.java;

/**
 * @author sakura
 * @date: 2021/8/8 14:11
 * @description:
 */
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode136 leetCode136 = new LeetCode136();
        int i = leetCode136.singleNumber(new int[]{4, 1, 2, 1, 2});
        System.out.println(i);
    }
}
