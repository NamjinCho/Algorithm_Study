import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-04.
 */
public class FlowerRoad {

    static class Node{
        int row;
        int col;
        Node (int r, int c)
        {
            row = r;
            col = c;
        }
    }
    static int count2=0;
    static int N;
    static int map[][];
    static int ans;
    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    static boolean check[][];
    static LinkedList<Node> list;
    static Node nodes[];
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        N =sc.nextInt();
        map = new int[N][N];
        check = new boolean[N][N];
        list = new LinkedList<>();
        nodes = new Node[N*N];
        int idx=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                map[i][j] = sc.nextInt();
                nodes[idx] = new Node(i,j);
                idx++;
            }
        }
        ans = 3000;
        dfs(0,0);
        System.out.println(ans);
    }
    public static boolean[][] copy()
    {
        boolean[][] result = new boolean[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                result [i][j] = check[i][j];
            }
        }
        return result;
    }
    public static int bloom()
    {
        int total=0;
        boolean visit[][] = copy();
        for(int i=0;i<3;i++)
        {
            Node t = list.get(i);
            total += map[t.row][t.col];
            for(int j=0;j<4;j++)
            {
                int nr = t.row+dir[j][0];
                int nc = t.col+dir[j][1];
                if(nr<0 || nr >=N || nc<0 || nc>=N )
                {
                    return Integer.MAX_VALUE;
                }
                if(visit[nr][nc])
                    return Integer.MAX_VALUE;
                total += map[nr][nc];
                visit[nr][nc] = true;

            }
        }
        return total;
    }
    public static void dfs(int count, int idx)
    {
        if(idx>=N*N)
            return;
        if(count == 3)
        {
            int result = bloom();
            ans = Math.min(result,ans);
            return;
        }


        list.addLast(nodes[idx]);
        check[nodes[idx].row][nodes[idx].col] = true;
        dfs(count + 1, idx+1);
        list.removeLast();
        check[nodes[idx].row][nodes[idx].col] = false;
        dfs(count,idx+1);
    }
}
