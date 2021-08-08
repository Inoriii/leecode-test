package main.java;

/**
 * @author sakura
 * @date: 2021/3/12 22:11
 * @description:
 */
public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0, r = nums.length - 1;
        if (l == r) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }
        int mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (nums[mid] < target) {
                if (mid < nums.length - 1) {
                    ++mid;
                }
                l = mid;
            } else if ((nums[mid] > target)) {
                if (mid > 0) {
                    --mid;
                }
                r = mid;
            } else {
                break;
            }
        }
        if (l > r) {
            return new int[]{-1, -1};
        } else if (l == r) {
            if (nums[l] == target) {
                return new int[]{l, l};
            } else {
                return new int[]{-1, -1};
            }
        } else {
            return btwlr(mid, nums);
        }
    }

    private int[] btwlr(int mid, int[] nums) {
        int l = mid;
        int r = mid;
        while (l - 1 >= 0) {
            if (nums[l - 1] == nums[mid]) {
                --l;
                continue;
            }
            break;
        }
        while (r + 1 < nums.length) {
            if (nums[r + 1] == nums[mid]) {
                ++r;
                continue;
            }
            break;
        }
        return new int[]{l, r};
    }

    public static void main(String[] args) {
        LeetCode34 leetCode34 = new LeetCode34();
        int[] ints = leetCode34.searchRange(new int[]{1, 1, 2}, 1);
        System.out.println(ints);
    }
}
