package main.java;

/**
 * @author sakura
 * @date: 2021/3/23 22:45
 * @description:
 */
public class LeetCode200_3 {
    int unionSum;
    int line;
    int stand;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        line = grid[0].length;
        stand = grid.length;
        int sum = stand * line;
        int waterSum = 0;
        int[] unionFindArray = new int[sum];
        for (int i = 0; i < unionFindArray.length; i++) {
            unionFindArray[i] = i;
        }
        for (int i = 0; i < stand; i++) {
            for (int j = 0; j < line; j++) {
                if ('1' == grid[i][j]) {
                    unionFind(grid, unionFindArray, i, j);
                } else {
                    ++waterSum;
                }
            }
        }
        return sum - waterSum - unionSum;
    }

    private void unionFind(char[][] grid, int[] unionFindArray, int i, int j) {
        if (check(i - 1, j)) {
            if ('1' == grid[i - 1][j]) {
                union(unionFindArray, toArrayPosition(i - 1, j), toArrayPosition(i, j));
            }
        }
        if (check(i, j - 1)) {
            if ('1' == grid[i][j - 1]) {
                union(unionFindArray, toArrayPosition(i, j - 1), toArrayPosition(i, j));
            }
        }
        if (check(i + 1, j)) {
            if ('1' == grid[i + 1][j]) {
                union(unionFindArray, toArrayPosition(i + 1, j), toArrayPosition(i, j));
            }
        }
        if (check(i, j + 1)) {
            if ('1' == grid[i][j + 1]) {
                union(unionFindArray, toArrayPosition(i, j + 1), toArrayPosition(i, j));
            }
        }
    }

    private void union(int[] unionFindArray, int source, int target) {
        int i = find(unionFindArray, source);
        int j = find(unionFindArray, target);
        if (i != j) {
            unionFindArray[i] = j;
            ++unionSum;
        }
    }

    private int find(int[] unionFindArray, int parent) {
        if (unionFindArray[parent] == parent) {
            return parent;
        }
        return find(unionFindArray, unionFindArray[parent]);
    }

    private boolean check(int i, int j) {
        return !(i < 0 || j < 0 || i >= stand || j >= line);
    }

    private int toArrayPosition(int i, int j) {
        return i * line + j;
    }

    public static void main(String[] args) {
        LeetCode200_3 leecode200 = new LeetCode200_3();
        char[][] request = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int result = leecode200.numIslands(request);
        System.out.println(result);
    }


}
