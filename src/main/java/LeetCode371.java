package main.java;

import main.java.common.ListNode;
import main.java.util.ListNodeUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sakura
 * @date: 2021/3/25 21:02
 * @description:
 */
public class LeetCode371 {
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        LeetCode371 leetCode371 = new LeetCode371();
        int sum = leetCode371.getSum(1, 2);
        System.out.println(sum);
    }
}
