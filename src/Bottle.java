import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-09.
 */
public class Bottle {
    static  int A,B,C;
    static boolean ans[];
    static class Ele{
        int a,b,c;
        Ele(int aa,int bb,int cc)
        {
            a = aa;
            b = bb;
            c = cc;
        }
    }

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        Ele e = new Ele(0,0,C);
        ans = new boolean[C+1];
        bfs(e);
        for(int i=0;i<=C;i++)
            if(ans[i])
                System.out.print(i+" ");
    }
    public static int [] trans(Ele e,int s,int e1,int e2)
    {
        int result[] = new int[3];
        int a,b,c;
        a = e.a;
        b = e.b;
        c = e.c;
        if(s == 0)
        {

            if(e1 == 1){
                b = b+a;
                a=0;
                if(b>B)
                {
                    a = b-B;
                    b = b - a;
                }
                c = c+a;
                a = 0;
                if(c>C)
                {
                    a = c-C;
                    c = c-a;
                }

            }else{
                c = c+a;
                a = 0;
                if(c>C)
                {
                    a = c-C;
                    c = c-a;
                }

                b = b+a;
                a=0;
                if(b>B)
                {
                    a = b-B;
                    b = b - a;
                }
            }
        }else if(s == 1)
        {
            if(e1 == 0){
                a = b+a;
                b=0;
                if(a>A)
                {
                    b = a-A;
                    a = a - b;
                }
                c = c+b;
                b = 0;
                if(c>C)
                {
                    b = c-C;
                    c = c-b;
                }

            }else{
                c = c+b;
                b = 0;
                if(c>C)
                {
                    b = c-C;
                    c = c-b;
                }

                a = b+a;
                b=0;
                if(a>A)
                {
                    b = a-A;
                    a = a-b;
                }
            }
        }else{
            if(e1 == 0){
                a = c+a;
                c=0;
                if(a>A)
                {
                    c = a-A;
                    a = a - c;
                }
                b = c+b;
                c = 0;
                if(b>B)
                {
                    c = b-B;
                    b = b-c;
                }

            }else{

                b = c+b;
                c = 0;
                if(b>B)
                {
                    c = b-B;
                    b = b-c;
                }
                a = c+a;
                c=0;
                if(a>A)
                {
                    c = a-A;
                    a = a - c;
                }
            }
        }
        result[0] = a;
        result[1] = b;
        result[2] = c;

        return result;
    }
    public static void bfs(Ele e)
    {
        boolean visit[][][] = new boolean[A+1][B+1][C+1];
        visit [e.a][e.b][e.c]=true;
        Queue<Ele> q = new LinkedList<>();
        q.offer(e);
        ans[e.c]=true;
        while (!q.isEmpty())
        {
            Ele ne = q.poll();
            int [][] result = new int[6][3];
            result[0]=trans(ne,0,1,2);
            result[1]=trans(ne,0,2,1);
            result[2]=trans(ne,1,0,2);
            result[3]=trans(ne,1,2,0);
            result[4]=trans(ne,2,0,1);
            result[5]=trans(ne,2,1,0);
            for(int i=0;i<6;i++)
            {
                int a = result[i][0];
                int b = result[i][1];
                int c= result[i][2];
                if(a==0)
                {
                    ans[c]=true;
                }
                if(!visit[a][b][c])
                {

                    visit[a][b][c] = true;
                    q.offer(new Ele(a,b,c));
                }
            }
        }
    }
}
