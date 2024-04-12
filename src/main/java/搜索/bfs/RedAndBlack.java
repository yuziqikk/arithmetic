package 搜索.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Package: lanqiao.bfs
 * @Author: YuZiQiKK
 * @Created: 2024/4/12 21:00
 **/
/*
蒜厂有一个长方形的房子，地上铺了红色、黑色两种颜色的正方形瓷砖。你站在其中一块黑色的瓷砖上，只能向相邻的黑色瓷砖移动。
请写一个程序，计算你总共能够到达多少块黑色的瓷砖。
输入格式
第一行是两个整数 W 和 H，分别表示 x 方向和 y 方向瓷砖的数量。W 和 H 都不超过 20。
在接下来的 H 行中，每行包括 W 个字符。每个字符表示一块瓷砖的颜色，规则如下
1）‘.’：黑色的瓷砖；
2）‘#’：红色的瓷砖；
3）‘@’：黑色的瓷砖，并且你站在这块瓷砖上。该字符在每个数据集合中唯一出现一次。
输出格式
输出一行，显示你从初始位置出发能到达的瓷砖数(记数时包括初始位置的瓷砖)。
输出时每行末尾的多余空格，不影响答案正确性
样例输入
6 9
....#.
.....#
......
......
......
......
......
#@...#
.#..#.
样例输出
45
 */
public class RedAndBlack {
    public static int count;
    public static int n;
    public static int m;
    
    public static boolean[][] vis;
    public static int[][] maze;
    
    public static int[] x = {-1, 0, 1, 0};
    public static int[] y = {0, 1, 0, -1};
    
    public static boolean isInMaze(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static int bfs(int sx, int sy){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sx, sy, 0));
        vis[sx][sy] = true;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            count++;
            //注意，这个循环只是确定周围有几个点是能走的
            for(int i = 0 ; i < 4 ; i++){
                int xx = node.x + x[i];
                int yy = node.y + y[i];
                if(isInMaze(xx, yy) && !vis[xx][yy] && maze[xx][yy] != '#'){
                    queue.offer(new Node(xx, yy, 0));
                    vis[xx][yy] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        //有时候要注意矩阵的长和宽，别搞反了
        n = Integer.parseInt(str[1]);
        m = Integer.parseInt(str[0]);
        maze = new int[n][m];
        vis = new boolean[n][m];
        for(int i = 0 ; i < n ; i++) {
            String s = reader.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = s.charAt(j);
            }
        }
                bfs(0, 0);
        System.out.println(count);
    }
}
