package main.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sakura
 * @date: 2021/3/23 22:45
 * @description:
 */
public class Leecode200_2 {
    class La {
        int x;
        int y;

        public La(int i, int j) {
            this.x = i;
            this.y = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            La la = (La) o;
            return x == la.x &&
                    y == la.y;
        }

    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int num = 0;
        Queue<La> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ('1' == grid[i][j]) {
                    queue.add(new La(i, j));
                    bfs(grid, queue, 1);
                    ++num;
                }
            }
        }
        return num;
    }

    private boolean add(char[][] grid, int x, int y, Queue<La> queue) {
        return !(x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || grid[x][y] == '0' || queue.contains(new La(x, y)));
    }

    private void bfs(char[][] grid, Queue<La> queue, int size) {
        if (queue.isEmpty()) {
            return;
        }
        for (int i = 0; i < size; i++) {
            La remove = queue.remove();
            int x = remove.x;
            int y = remove.y;
            grid[x][y] = '0';
            if (add(grid, x + 1, y, queue)) {
                queue.offer(new La(x + 1, y));
            }
            if (add(grid, x, y + 1, queue)) {
                queue.offer(new La(x, y + 1));
            }
            if (add(grid, x - 1, y, queue)) {
                queue.offer(new La(x - 1, y));
            }
            if (add(grid, x, y - 1, queue)) {
                queue.offer(new La(x, y - 1));
            }
        }
        bfs(grid, queue, queue.size());
    }

    public static void main(String[] args) {
        Leecode200_2 leecode200 = new Leecode200_2();
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
