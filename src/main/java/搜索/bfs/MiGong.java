package 搜索.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
输入格式
第一行输入两个整数 n 和 m，表示这是一个 n×m的迷宫。
接下来的输入一个 n 行 m 列的迷宫。其中 'S' 表示蒜头君的位置，'*'表示墙，蒜头君无法通过，'.'表示路，蒜头君可以通过'.'移动，'T'表示迷宫的出口
每次只能移动到四个与他相邻的位置——上，下，左，右）。
输出格式
输出整数，表示蒜头君逃出迷宫的最少步数，如果蒜头君无法逃出迷宫输出 -1−1。
样例输入1
3 4
S**.
..*.
***T
样例输出1
-1
样例输入2
3 4
S**.
....
***T
样例输出2
5
 */



public class MiGong {
	//下一个要移动到的位置
	public static int[] x = {-1, 0, 1, 0};
	public static int[] y = {0, -1, 0, 1};
	//标记是否走过
	public static boolean[][] vis;
	//存储迷宫
	public static char[][] maze;
	//迷宫的宽高
	public static int hight;
	public static int weight;
	
	//判断当前是否越界
	public static boolean isInMaze(int x, int y) {
		return x >= 0 && y >= 0 && x < hight && y < weight;
	}
	
	//bfs找最短路
	public static int bfs(int sx, int sy) {
		int min = 0;
		Queue<Node> queue = new LinkedList<>();
		//初始化位置（假设起点在（0，0））
		vis[0][0] = true;
		queue.offer(new Node(sx, sy, 0));
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(maze[node.x][node.y] == 'T') {
				return node.num;
			}
			for(int i = 0 ; i < 4 ; i++) {
				int xx = node.x + x[i];
				int yy = node.y + y[i];
				if(isInMaze(xx, yy) && !vis[xx][yy] && maze[xx][yy] != '*') {
					vis[xx][yy] = true;
					//步数加一
					queue.offer(new Node(xx, yy, node.num + 1));
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		//处理输入
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str = reader.readLine().split(" ");
		hight = Integer.parseInt(str[0]);
		weight = Integer.parseInt(str[1]);
		//初始化
		maze = new char[hight][weight];
		vis = new boolean[hight][weight];
		for(int i = 0 ; i < hight ; i++){
			String s = reader.readLine();
			for(int j = 0 ; j < weight ; j++) {
				maze[i][j] = s.charAt(j);
			}
		}
		int min = bfs(0, 0);
		System.out.println(min);
	}
}
