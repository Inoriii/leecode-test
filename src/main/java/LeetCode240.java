package main.java;

import main.java.util.StringUtil;

/**
 * @author sakura
 * @date: 2021/3/23 22:45
 * @description:
 */
public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int line = matrix.length - 1;
        int row = 0;
        while (line >= 0 && row <= matrix[0].length - 1) {
            if (matrix[line][row] == target) {
                return true;
            }
            if (matrix[line][row] > target) {
                --line;
            } else {
                ++row;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        LeetCode240 leetCode240 = new LeetCode240();
        boolean b = leetCode240.searchMatrix(StringUtil.string2Array2(
                        "[[1,4,7,11,15]," +
                                "[2,5,8,12,19]," +
                                "[3,6,9,16,22]," +
                                "[10,13,14,17,24]," +
                                "[18,21,23,26,30]]"),
                5);
        System.out.println(b);
    }
}
