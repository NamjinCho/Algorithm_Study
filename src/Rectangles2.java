import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-24.
 */
public class Rectangles2 {


    static class Rect {
        int x, xp, y, yp;
        int count;
        boolean visit;
        Rect(int coord[]) {
            x = coord[0];
            y = coord[1];
            xp = coord[2];
            yp = coord[3];
        }

    }
    static int ans,K;
    static Rect[] rects;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            K = sc.nextInt();
            rects = new Rect[K+1];
            int tmp [] = new int[4];
            tmp[0] = 0;
            tmp[1]=0;
            tmp[2] = N;
            tmp[3] = M;
            rects[0] = new Rect(tmp);

            for (int i = 1; i <= K; i++) {
                int coord[] = new int[4];
                coord[0] = sc.nextInt();
                coord[1] = sc.nextInt();
                coord[2] = sc.nextInt();
                coord[3] = sc.nextInt();
                rects[i] = new Rect(coord);
            }
            rects[0].visit = true;
            ans = dfs(0,0);


            System.out.println("Case #"+(tc+1));
            System.out.println(ans);
        }
    }
    public static int dfs(int count , int start)
    {

        for(int i=0;i<=K;i++)
        {
            if(i!=start&&check(rects[start],rects[i]))
            {
                if(!rects[i].visit)
                {
                    rects[i].visit = true;
                    rects[start].count = Math.max(dfs(0,i)+1,rects[start].count);
                }else
                {
                    rects[start].count = Math.max(rects[i].count+1,rects[start].count);
                }
            }
        }

        return rects[start].count;
    }
    public static boolean check(Rect r1, Rect r2) {

        if (r1.x <= r2.x && r2.x < r2.xp && r2.xp <= r1.xp) {
            if (r1.y <= r2.y && r2.y < r2.yp && r2.yp <= r1.yp)
                return true;
            else
                return false;

        } else
            return false;
    }
}
