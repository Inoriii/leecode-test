package main.java.util;

import java.util.Arrays;

/**
 * @author sakura
 * @date: 2021/8/14 15:02
 * @description:
 */
public class StringUtil {
    public static int[] string2Array1(String s) {
        if (s == null || s.length() == 0) {
            return new int[]{0};
        }
        s = s.replace("[", "");
        s = s.replace("]", "");
        return Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public static int[][] string2Array2(String s) {
        if (s == null || s.length() <= 2) {
            return new int[][]{{0, 0}};
        }
        s = s.substring(1, s.length() - 2);
        String[] split = s.split("],");
        int[][] result = new int[split.length][];
        for (int k = 0; k < split.length; ++k) {
            split[k] = split[k].replace("[", "");
            split[k] = split[k].replace("]", "");
            int[] ints = StringUtil.string2Array1(split[k]);
            result[k] = ints;
        }
        return result;
    }

}
