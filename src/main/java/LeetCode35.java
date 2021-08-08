package main.java;

/**
 * @author sakura
 * @date: 2021/3/12 22:11
 * @description:
 */
public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int n = l + (r - l) / 2;
            if (nums[n] == target) {
                return n;
            }
            if (nums[n] > target) {
                r = n;
                continue;
            }
            if (nums[n] < target) {
                l = n + 1;
            }
        }
        if (nums[l] < target) {
            return l+ 1;
        } else {
            return l ;
        }
    }

    public static void main(String[] args) {
        LeetCode35 leetCode35 = new LeetCode35();
        int[] a = {1, 3, 5, 6};
        int i = leetCode35.searchInsert(a, 7);
        System.out.println(i);
    }
}
