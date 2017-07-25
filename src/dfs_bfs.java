import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by NamjinCho on 2017-07-19.
 */
public class dfs_bfs {

    public static Stack<Integer> stack;
    public static void main(String [] args)
    {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int V = sc.nextInt();
        int start = sc.nextInt();

        int [][] arr =new int[N+1][N+1];

        for(int i=0;i<V;i++)
        {
            int s = sc.nextInt();
            int e = sc.nextInt();

            arr[s][e] = 1;
            arr[e][s] = 1;
        }
        boolean visit[] = new boolean[N+1];
        stack = new Stack<>();
        visit[start] = true;
        System.out.print(start+" ");
        dfs(arr,start,visit,N);
        System.out.println();
        bfs(arr,start,N);
        System.out.println();
    }
    public static void dfs(int [][]arr,int idx,boolean []visit,int N)
    {

        for(int i=1;i<=N;i++)
        {
            if(arr[idx][i]==1 && !visit[i]){
                visit[i]=true;
                System.out.print(i +" ");
                dfs(arr,i,visit,N);
            }
        }
    }
    public static void bfs(int [][]arr , int start,int N)
    {
        Queue<Integer> que = new LinkedList();
        que.offer(start);
        boolean visit[] = new boolean[N+1];
        visit[start] = true;

        while(!que.isEmpty()){
            int idx = que.poll();
            System.out.print(idx+" ");
            for(int i=1;i<=N;i++)
            {
                if(!visit[i] && arr[idx][i]==1)
                {
                    que.offer(i);
                    visit[i]=true;
                }
            }
        }

    }

}
