/*
611. Knight Shortest Path
中文English
Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position, find the shortest path to a destination position, return the length of the route.
Return -1 if destination cannot be reached.

样例
说明
If the knight is at (x, y), he can get to the following positions in one step:

(x + 1, y + 2)
(x + 1, y - 2)
(x - 1, y + 2)
(x - 1, y - 2)
(x + 2, y + 1)
(x + 2, y - 1)
(x - 2, y + 1)
(x - 2, y - 1)
样例
例1:

输入:
[[0,0,0],
 [0,0,0],
 [0,0,0]]
source = [2, 0] destination = [2, 2]
输出: 2
解释:
[2,0]->[0,1]->[2,2]
例2:

输入:
[[0,1,0],
 [0,0,1],
 [0,0,0]]
source = [2, 0] destination = [2, 2]
输出:-1
 */

package graph.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class KnightShortestPath {
    static class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int n = grid.length;
        int m = grid[0].length;

        int[] dx = {1,1,-1,-1,2,2,-2,-2};
        int[] dy = {2,-2,2,-2,1,-1,1,-1};

        //we can save the space for the visited matrix in this problem
        Queue<Point> queue = new ArrayDeque();
        int steps = 0;
        queue.offer(source);
        //start BFS
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size;i++){
                Point cur = queue.poll();
                if(cur.x == destination.x && cur.y == destination.y) return steps;
                for(int k = 0; k < 8; k++) {
                    int nextX = cur.x + dx[k];
                    int nextY = cur.y + dy[k];
                    if(!inBound(n,m,nextX,nextY)) continue;
                    if(grid[nextX][nextY]) continue;
                    queue.offer(new Point(nextX,nextY));
                    grid[nextX][nextY] = true;
                }
            }
            steps++;

        }

        return -1;

    }
    private boolean inBound(int n, int m, int i, int j){
        return i >= 0 && i < n && j >= 0 && j < m;
    }

}
