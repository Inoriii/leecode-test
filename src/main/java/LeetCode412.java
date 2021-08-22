package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sakura
 * @date: 2021/3/25 21:02
 * @description:
 */
public class LeetCode412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(8);
        Map<Integer, String> map = new HashMap<Integer, String>() {{
            put(3, "Fizz");
            put(5, "Buzz");
        }};

        for (int i = 1; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : map.keySet()) {
                if (i % integer == 0) {
                    sb.append(map.get(integer));
                }
            }
            String s = sb.toString();
            if (s.length() == 0) {
                res.add(i + "");
            } else {
                res.add(s);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode412 leetCode371 = new LeetCode412();
        List<String> res =leetCode371.fizzBuzz(15);
        System.out.println(res);
    }
}
