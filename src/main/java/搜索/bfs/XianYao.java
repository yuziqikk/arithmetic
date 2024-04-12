package 搜索.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Package: lanqiao
 * @Author: YuZiQiKK
 * @Created: 2024/4/12 20:35
 **/
/*
输入格式
第一行输入两个非零整数 M 和 N，两者均不大于 20。M 表示迷阵行数, N 表示迷阵列数。
接下来有 M行, 每行包含 N 个字符,不同字符分别代表不同含义:
\1) ‘@’：少年李逍遥所在的位置；2) ‘.’：可以安全通行的方格；3) ‘#’：有怪物的方格；4) ‘*’：仙药所在位置。
输出格式
输出一行，该行包含李逍遥找到仙药需要穿过的最少的方格数目(计数包括初始位置的方块)。如果他不可能找到仙药, 则输出 −1。
输出时每行末尾的多余空格，不影响答案正确性
样例输入1
8 8
.@##...#
#....#.#
#.#.##..
..#.###.
#.#...#.
..###.#.
...#.*..
.#...###
样例输出1
10
 */
public class XianYao {
    //迷宫长宽
    public static int n;
    public static int m;
    //偏移量
    public static int[] x = {-1, 0, 1, 0};
    public static int[] y = {0, 1, 0, -1};
    //记录是否走过
    public static boolean[][] vis;
    //迷宫
    public static int[][] maze;
    //判断是否越界
    public static boolean isInMaze(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    //bfs找最短路
    public static int bfs(int sx, int sy){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sx, sy, 0));
        vis[sx][sy] = true;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(maze[node.x][node.y] == '*'){
                return node.num;
            }
            for(int i = 0 ; i < 4 ; i++){
                int xx = node.x + x[i];
                int yy = node.y + y[i];
                //注意这里不能写maze[xx][yy] == '.'，这样会避开仙药“#”，导致找不到结果
                if(isInMaze(xx, yy) && !vis[xx][yy] && maze[xx][yy] != '#'){
                    vis[xx][yy] = true;
                    queue.offer(new Node(xx, yy, node.num + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        maze = new int[n][m];
        vis = new boolean[n][m];
        int beginX = 0;
        int beginY = 0;
        for(int i = 0 ; i < n ; i++){
            String s = reader.readLine();
            for(int j = 0 ; j < m ; j++){
                char c = s.charAt(j);
                maze[i][j] = c;
                if(c == '@'){
                    beginX = i;
                    beginY = j;
                }
            }
        }
        System.out.println(bfs(beginX, beginY));
    }
}
