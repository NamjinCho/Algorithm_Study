import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-02.
 */
public class ApartNumber {

    static int N;
    static int arr[][];
    static ArrayList<Integer> anslist;
    static boolean visit[][];


    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        N = Integer.parseInt(line);
        arr= new int[N][N];
        visit = new boolean[N][N];
        for(int i=0;i<N;i++)
        {
            line = sc.nextLine();
            for(int j=0;j<N;j++)
            {
                arr[i][j]=line.charAt(j)-'0';
                if(arr[i][j]==0)
                    visit[i][j]=true;
            }
        }
        anslist = new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(!visit[i][j])
                {
                    int result=bfs(i,j);
                    anslist.add(result);
                }
            }
        }

        anslist.sort(null);
        System.out.println(anslist.size());
        for(int i=0;i<anslist.size();i++)
        {
            System.out.println(anslist.get(i));
        }

    }
    public static int bfs(int row , int col)
    {
        int size = 1;
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        visit[row][col] = true;
        rq.offer(row);
        cq.offer(col);
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        while (!rq.isEmpty()){
            int rr= rq.poll();
            int cc = cq.poll();
            for(int i=0;i<4;i++)
            {
                int nr = rr + dir[i][0];
                int nc = cc + dir[i][1];
                if(nr>=0 && nr<N && nc >=0 && nc< N)
                {
                    if(!visit[nr][nc] && arr[nr][nc]==1)
                    {
                        visit[nr][nc]=true;
                        rq.offer(nr);
                        cq.offer(nc);
                        size++;
                    }
                }
            }
        }
        return size;
    }
}
