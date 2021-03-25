package main.java;

import java.util.*;

/**
 * @author sakura
 * @date: 2021/3/22 22:59
 * @description:
 */
public class Leecode169_2 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        Leecode169_1 leecode169 = new Leecode169_1();
        int[] request = new int[]{3, 3, 4};
        int result = leecode169.majorityElement(request);
        System.out.println(result);
    }
}
