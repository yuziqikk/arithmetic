package 搜索.bfs;

/**
 * @Package: lanqiao
 * @Author: YuZiQiKK
 * @Created: 2024/4/12 20:50
 **/

//记录当前的位置和已经走过的步数
public class Node {
    int x;
    int y;
    int num;
    public Node(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }
}
