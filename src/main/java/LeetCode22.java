package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sakura
 * @date: 2021/3/10 23:11
 * @description:
 */
public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(combinations, 0, 0, n, new StringBuilder());
        return combinations;
    }

    private void generateAll(List<String> combinations, int l, int r, int n, StringBuilder s) {
        if (r > l) {
            return;
        }
        if (l == n && r == n) {
            combinations.add(s.toString());
            return;
        }
        if (l < n) {
            s.append("(");
            generateAll(combinations, l + 1, r, n, s);
            s.deleteCharAt(s.length() - 1);
        }
        if (r < n) {
            s.append(")");
            generateAll(combinations, l, r + 1, n, s);
            s.deleteCharAt(s.length() - 1);
        }
    }


    public static void main(String[] args) {
        LeetCode22 leetCode22 = new LeetCode22();
        List<String> strings = leetCode22.generateParenthesis(2);
        System.out.println(strings);
    }
}
