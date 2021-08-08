package main.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sakura
 * @date: 2021/3/10 22:20
 * @description:
 */
public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            return 0;
        }
        int[] all = null;
        if ((nums1 == null || nums1.length == 0)) {
            all = nums2;
        } else if ((nums2 == null || nums2.length == 0)) {
            all = nums1;
        } else {
            int l1 = 0, l2 = 0;
            all = new int[nums1.length + nums2.length];
            int i = 0;
            while (l1 < nums1.length || l2 < nums2.length) {
                if (l1 == nums1.length) {
                    while (l2 < nums2.length) {
                        all[i++] = nums2[l2++];
                    }
                } else if (l2 == nums2.length) {
                    while (l1 < nums1.length) {
                        all[i++] = nums1[l1++];
                    }
                } else {
                    if (nums1[l1] <= nums2[l2]) {
                        all[i++] = nums1[l1++];
                    } else {
                        all[i++] = nums2[l2++];
                    }
                }
            }
        }
        int length = all.length;
        int num = length % 2;
        int mid = length / 2;
        if (num == 0) {
            return (all[mid] + all[mid - 1]) * 1.0 / 2;
        } else {
            return all[mid];
        }
    }

    public static void main(String[] args) {
        LeetCode4 leetCode = new LeetCode4();
        double medianSortedArrays = leetCode.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println(medianSortedArrays);
    }
}
