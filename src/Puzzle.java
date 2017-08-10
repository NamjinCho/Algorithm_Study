import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-09.
 */
public class Puzzle {
    static int N;
    static int arr[][];
    static int [][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static class Node{
        int row;
        int col;
        int arr[][];
        int cost;
        Node(int r,int c,int co,int a[][])
        {
            row = r;
            col = c;
            cost = co;
            int tr=0;
            int tc=0;
            arr = new int[3][3];
            for(int i =0;i<3;i++)
            {
                for(int j=0;j<3;j++){
                    arr[i][j] = a[i][j];
                    if(arr[i][j]==0)
                    {
                        tr=i;
                        tc=j;
                    }
                }
            }
            //swap
            int tmp = arr[row][col];
            arr[row][col] = arr[tr][tc];
            arr[tr][tc] = tmp;


        }
    }

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        N = 3;
        arr = new int[N][N];
        Node n;
        int row=0,col=0;
        for(int i =0 ; i<N;i++)
        {
            for(int j=0;j<3;j++)
            {
                arr[i][j] = sc.nextInt();
                if(arr[i][j]==0)
                {
                    row = i;
                    col = j;
                }
            }
        }
        n = new Node(row,col,0,arr);
        int ans = 0;
        if(!checkEnd(n))
            ans = bfs(n);
        System.out.println(ans);
    }
    public static boolean checkEnd(Node n)
    {
        int idx = 1;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(n.arr[i][j]!=idx)
                    return false;
                if(idx==8)
                    break;
                idx++;
            }
        }
        return true;
    }
    public static String getSurround(Node n)
    {
        String result="";
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                result=result+n.arr[i][j];
            }
        }

        return result;
    }
    public static int bfs(Node node)
    {
        String tmp = getSurround(node);
        HashMap<String,Boolean> visit = new HashMap<>();
        visit.put(tmp,true);
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty())
        {
            Node n = q.poll();

            for(int i = 0;i<4;i++)
            {
                int nr = n.row +dir[i][0];
                int nc = n.col +dir[i][1];
                if(nr>=0 && nr < 3 && nc>=0 && nc <3)
                {
                    Node nn = new Node(nr,nc,n.cost+1,n.arr);
                    tmp = getSurround(nn);

                    if(checkEnd(nn))
                        return nn.cost;
                    if(!visit.containsKey(tmp))
                    {
                        visit.put(tmp,true);
                        q.offer(nn);
                    }
                }
            }
        }
        return -1;
    }
}
