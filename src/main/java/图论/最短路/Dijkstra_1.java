package 图论.最短路;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Package: 图论-最短路
 * @Author: YuZiQiKK
 * @Created: 2024/3/28 10:15
 * 朴素Dijkstra算法
 * 原题链接：https://www.acwing.com/activity/content/11/
 * 例题：3 3 1 2 2 2 3 1 1 3 4
 * 正确答案：3
 **/
public class Dijkstra_1 {
    //这个是点的最大数量
    static int N = 510;
    //n点数，m边数
    static int n, m;
    //起点（dist【0】）到其他点（dist【i】）的最短距离
    static int[] dist = new int[N];
    //存储图信息的邻接矩阵
    static int[][] g = new int[N][N];
    //集合s
    static boolean[] s = new boolean[N];

    //朴素dijkstra算法
    public static int dijkstra(){
        //循环n次，每次确定一个点的最短距离
        for(int i = 0 ; i < n ; i++){
            int t = -1;
            for(int j = 1 ; j <= n ; j++){
                //这里是找不在s中的，距离最近的点(也就是dist最小的点)，记为t
                if(!s[j] && (t == -1 || dist[t] > dist[j])){
                    t = j;
                }
            }
            //t这个点已经确定了
            s[t] = true;
            //然后用这个点去更新其他点的距离
            for(int j = 1 ; j <= n ; j++){
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }
        //如果没有最短路则返回-1
        if(dist[n] == 0x3f3f3f3f){
            return -1;
        }else {
            return dist[n];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        //首先初始化，注意，此处必须把g全部初始化成最大值，不能留空
        for(int i = 0 ; i < N ; i++){
            Arrays.fill(g[i], 0x3f3f3f3f);
        }
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        Arrays.fill(s, false);
        //处理输入
        for(int i = 0 ; i < m ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            //这个判断是在处理自环
            /*不需要特殊处理自环，自环本质上是对一个点的两次访问，只要边权都是正值，那么有自环的总是比
            没有自环的长。所以自环这种情况不用特殊处理，算法已经排除了自环的影响。
             */
//            if(!(x == y)){
                //这个取最小值是在处理重边
                g[x][y] = Math.min(g[x][y], z);
//            }
        }
        int ans = dijkstra();
        System.out.println(ans);
    }
}
