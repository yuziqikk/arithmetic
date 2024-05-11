package 图论.最短路;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Package: 图论.最短路
 * @Author: YuZiQiKK
 * @Created: 2024/3/30 14:32
 * 用于存在负边权的情况，时间复杂度O(nm)
 * 注意，如果存在负权回路，那么最短路不一定存在
 * 原题链接:https://www.acwing.com/problem/content/855/
 **/
public class Bellmen_Ford {
    //最大点数,边数
    static int N = 510, M = 10010;
    //最大路径长度
    static int maxLen = 0x3f3f3f3f;
    //n点数, m边数, k最大不超过多少条边
    static int n, m, k;
    //起点（dist【0】）到其他点（dist【i】）的最短距离
    static int[] dist = new int[N];
    //表示第i条边关联a点、b点和权值w
    static int[][] g = new int[M][3];

    public static void bellmenFord(){
        //初始化
        Arrays.fill(dist, maxLen);
        dist[1] = 0;
        //
        for(int i = 0 ; i < k ; i++){
            //此处备份
            int[] backup = Arrays.copyOf(dist, N);
            for(int j = 0 ; j < m ; j++){
                int a = g[j][0];
                int b = g[j][1];
                int w = g[j][2];
                //松弛操作
                dist[b] = Math.min(dist[b], backup[a] + w);
            }
        }
        if(dist[n] > (maxLen >> 1)){
            System.out.println("impossible");
        }else{
            System.out.println(dist[n]);
        }
    }

    public static void main(String[] args) throws IOException {
        //处理输入，如果用Scanner要寄，这里用快速输入
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = reader.readLine().split(" ");
        n = Integer.parseInt(str1[0]);
        m = Integer.parseInt(str1[1]);
        k = Integer.parseInt(str1[2]);
        for(int i = 0;i < m;i++)
        {
            String[] str2 = reader.readLine().split(" ");
            g[i][0] = Integer.parseInt(str2[0]);
            g[i][1] = Integer.parseInt(str2[1]);
            g[i][2] = Integer.parseInt(str2[2]);
        }

        bellmenFord();
    }
}
