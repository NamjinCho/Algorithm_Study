import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-03.
 */
public class FindMatrix {

    static int arr[][];
    static boolean visit[][];
    static class AnsPair implements Comparable<AnsPair>{
        int row;
        int col;

        @Override
        public int compareTo(AnsPair o) {
            int t1 = row*col;
            int t2 = o.row*o.col;

            if(t1<t2)
                return -1;
            else if(t1>t2)
                return 1;
            else
            {
                if(row < o.row)
                    return -1;
                else if(row>o.row)
                    return 1;
                else
                    return 0;
            }



        }
    }
    static ArrayList<AnsPair> ans;
    static int N;
    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++)
        {
            N = sc.nextInt();


            ans = new ArrayList<>();
            visit = new boolean[N][N];
            arr = new int[N][N];

            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    arr[i][j] = sc.nextInt();
                    if(arr[i][j]==0)
                        visit[i][j] =true;
                }
            }
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if(!visit[i][j])
                    {
                        ans.add(bfs(i,j));
                    }
                }
            }

            ans.sort(null);
            System.out.print("#"+tc+" "+ans.size()+" ");
            for(int i=0;i<ans.size();i++)
            {
                System.out.print(ans.get(i).row +" "+ans.get(i).col+" ");
            }
            System.out.println();
        }
    }
    public static AnsPair bfs(int row ,int col)
    {
        visit[row][col]=true;
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        int maxRow = row;
        int maxCol = col;

        rq.offer(row);
        cq.offer(col);
        int dir[][] ={{0,1},{1,0}};
        while (!rq.isEmpty())
        {
            int r = rq.poll();
            int c=  cq.poll();
            for(int i=0;i<2;i++)
            {
                int nr =r + dir[i][0];
                int nc =c + dir[i][1];
                if(nr <N && nc<N)
                {
                    if(!visit[nr][nc])
                    {

                         visit[nr][nc] = true;

                        maxRow = Math.max(nr,maxRow);
                        maxCol = Math.max(nc,maxCol);
                        rq.offer(nr);
                        cq.offer(nc);
                    }
                }
            }
        }

        AnsPair result = new AnsPair();
        result.row = maxRow-row +1;
        result.col = maxCol-col +1;
        return result;
    }
}
