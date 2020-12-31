/*
433. Number of Islands
中文English
Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

Find the number of islands.

样例
Example 1:

Input:
[
  [1,1,0,0,0],
  [0,1,0,0,1],
  [0,0,0,1,1],
  [0,0,0,0,0],
  [0,0,0,0,1]
]
Output:
3
Example 2:

Input:
[
  [1,1]
]
Output:
1
 */
package graph.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    /*
    Solution 1: BFS
     */
//    static class Coordinate {
//        int coorX;
//        int coorY;
//        public Coordinate(int x, int y) {
//            this.coorX = x;
//            this.coorY = y;
//        }
//    }
//
//    public int numIslands(boolean[][] grid) {
//        // edge case:
//        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
//
//        // result
//        int islands = 0;
//
//        // visited flag
//        int n = grid.length;
//        int m = grid[0].length;
//        boolean[][] visited = new boolean[n][m];
//
//        // basic idea is find a pos location and use BFS to expand
//        // mark every connect pos as visited, then islands += 1
//        for(int i = 0; i < n; i++)
//            for(int j = 0; j < m; j++) {
//                if(!grid[i][j]) continue;
//                if(visited[i][j]) continue;
//                islands++;
//                markByBFS(grid, i, j, visited);
//            }
//        return islands;
//    }
//
//    private void markByBFS(boolean[][] grid, int i, int j, boolean[][] visited){
//        // direction Array
//        int[] dx = {0, 0, 1, -1};
//        int[] dy = {1, -1, 0, 0};
//
//        // queue for BFS
//        Queue<Coordinate> queue = new ArrayDeque<>();
//        if(!inBound(grid, i, j)) return;
//        // KEY: set visited when insert coors not when coors poll
//        queue.offer(new Coordinate(i, j));
//        visited[i][j] = true;
//
//        while(!queue.isEmpty()){
//            Coordinate cur = queue.poll();
//            System.out.println(cur.coorX + " " + cur.coorY);
//
//            for(int k = 0; k <4; k++){
//                int newX = cur.coorX + dx[k];
//                int newY = cur.coorY + dy[k];
//                if(!inBound(grid, newX, newY) || !grid[newX][newY]) continue;
//                if(visited[newX][newY]) continue;
//                // KEY: set visited when insert coors not when coors poll
//                queue.offer(new Coordinate(newX, newY));
//                visited[newX][newY] = true;
//            }
//        }
//
//    }
//
//    private boolean inBound(boolean[][] grid, int i, int j) {
//        int n = grid.length;
//        int m = grid[0].length;
//
//        return i >= 0 && i < n && j >= 0 && j < m;
//    }

        /*
    Solution 2: Union Find
     */
    static class UnionFind{
        private int[] father;
        private int count;

        public UnionFind(int n){
            father = new int[n];
            for(int i=0; i<n; i++) {
                father[i] = i;
            }
        }

        private int find(int x) {
            if(father[x] == x) return x;
            return father[x] = find(father[x]);
        }

        public void connect(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            // connect father of a to father of b
            if(root_a != root_b) {
                father[root_a] = root_b;
                // disconnect components minus 1
                count--;
            }
        }

        //getter
        public int query() {
            return count;
        }
        //setter
        public void set_count(int total){
            count = total;
        }
    }


    public int numIslands(boolean[][] grid) {
        int islands = 0;
        if(grid == null || grid.length==0 || grid[0].length==0) return 0;
        int n = grid.length;
        int m = grid[0].length;

        UnionFind uf = new UnionFind(n*m);

        int totalPos = 0;
        for(int i=0; i< n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) totalPos++;
            }
        }
        //initialize unionfind instance
        uf.set_count(totalPos);
        for(int i=0; i< n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]) {
                    if(i>0 && grid[i-1][j]) {
                        uf.connect(i*m+j, (i-1)*m+j);
                    }
                    if (i <  n - 1 && grid[i + 1][j]) {
                        uf.connect(i * m + j, (i + 1) * m + j);
                    }
                    if (j > 0 && grid[i][j - 1]) {
                        uf.connect(i * m + j, i * m + j - 1);
                    }
                    if (j < m - 1 && grid[i][j + 1]) {
                        uf.connect(i * m + j, i * m + j + 1);
                    }
                }
            }
        }
        return uf.query();

    }
    public static void main(String[] args) {
        NumberOfIslands counter = new NumberOfIslands();
        boolean[][] input = new boolean [][] {
                {true,true,false,false,false},{false,true,false,false,true},{false,false,false,true,true},{false,false,false,false,false},{false,false,false,false,true}
        };
        System.out.println(counter.numIslands(input));
    }
}
