import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-31.
 */
public class WhatYourName {

    static int N,M,K;
    static int dir[][] = {{0,1},{1,0},{0,-1}};
    static boolean msg[][];
    static char A='A'-1;
    static boolean ans[];
    static int[] cou;
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String [] sub = line.split(" ");
        N=Integer.parseInt(sub[0]);
        M=Integer.parseInt(sub[1]);
        K=Integer.parseInt(sub[2]);
        msg=new boolean[N+1][M+1];
        ans=new boolean[N+1];
        cou = new int[M+1];
        for(int i=1;i<=M;i++)
        {
            line = sc.nextLine();
            sub = line.split(" ");
            int c= Integer.parseInt(sub[0]);
            int m = sub[1].charAt(0)-A;
            msg[m][i]=true;
            cou[i]=c;
            if(K==i && c==0)
            {
                System.out.println("-1");
                return;
            }
        }
        bfs(1,K);
        int c = 0;
        for(int i=2;i<=N;i++)
        {
            if(!ans[i]){
                System.out.print((char) (A + i) + " ");
                c++;
            }
        }
        for(int i=1;i<M+1;i++)
            System.out.print(cou[i]+" ");
        if(c==0)
            System.out.println("-1");
    }

    public static void bfs(int row,int col)
    {
        boolean visit[][]= new boolean[N+1][M+1];
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        rq.offer(row);
        cq.offer(col);
        if(msg[row][col])
            ans[row]=true;

        while (!rq.isEmpty())
        {
            int rr=  rq.poll();
            int cc = cq.poll();

            for(int i=0;i<3;i++)
            {
                int nr = rr+dir[i][0];
                int nc = cc+dir[i][1];
                if(nr>=1 && nr <=N && nc>=1 && nc <=M)
                {
                    System.out.println(nr + " / " + nc + " " + msg[nr][nc] + " " + cou[nc]);
                    if(!visit[nr][nc])
                    {
                        if(msg[nr][nc] && cou[K]<=cou[nc])
                        {
                            ans[nr]=true;
                        }else
                        {
                            rq.offer(nr);
                            cq.offer(nc);
                        }
                        visit[nr][nc]=true;
                    }
                }
            }
        }
    }
}
