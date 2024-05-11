package 搜索.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Package: 搜索.dfs
 * @Author: YuZiQiKK
 * @Created: 2024/4/12 21:24
 **/
public class MiGong {
    public static int n;
    public static int m;
    public static char[][] maze;
    public static int[] x = {-1, 0, 1, 0};
    public static int[] y = {0, 1, 0, -1};
    public static boolean isInMaze(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static int dfs(int sx, int sy){
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        //初始化
        maze = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            String s = reader.readLine();
            for(int j = 0 ; j < m ; j++) {
                maze[i][j] = s.charAt(j);
            }
        }
        long a = Long.parseLong("342342");
    }
}
