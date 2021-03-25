package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author sakura
 * @date: 2021/3/22 22:33
 * @description:
 */
public class Leecode169_1 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer integer = map.computeIfAbsent(i, x -> 0);
            ++integer;
            map.put(i, integer);
        }
        int max = 0;
        int maxKey = 0;
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            Integer preMax = map.get(key);
            if (preMax > max) {
                max = preMax;
                maxKey = key;
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Leecode169_1 leecode169 = new Leecode169_1();
        int[] request = new int[]{3, 3, 4};
        int result = leecode169.majorityElement(request);
        System.out.println(result);
    }
}
