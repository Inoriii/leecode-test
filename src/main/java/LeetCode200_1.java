package main.java;

/**
 * @author sakura
 * @date: 2021/3/23 21:42
 * @description:
 */
public class LeetCode200_1 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ('1' == grid[i][j]) {
                    dfs(i, j, grid);
                    ++num;
                }
            }
        }
        return num;
    }

    private void dfs(int i, int j, char[][] grid) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == '0') {
            return;
        } else {
            grid[i][j] = '0';
        }
        dfs(i + 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i - 1, j, grid);
        dfs(i, j - 1, grid);
    }

    public static void main(String[] args) {
        LeetCode200_1 leecode200 = new LeetCode200_1();
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
