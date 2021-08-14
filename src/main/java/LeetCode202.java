package main.java;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sakura
 * @date: 2021/3/10 22:26
 * @description:
 */
public class LeetCode202 {

    private Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        set.add(n);
        int sum = n;
        while (true) {
            sum = sum(sum);
            if (sum == 1) {
                return true;
            }
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
        }
    }

    private int sum(int n) {
        int sum = 0;
        while (n != 0) {
            int end = n % 10;
            sum += end * end;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode202 leetCode202 = new LeetCode202();
        boolean happy = leetCode202.isHappy(2);
        System.out.println(happy);
    }

}
