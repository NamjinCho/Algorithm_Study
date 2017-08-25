import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-24.
 */
public class Rectangles {


    static class Rect implements Comparable<Rect> {
        int x, xp, y, yp;
        BigInteger size;
        Rect(int coord[]) {
            x = coord[0];
            y = coord[1];
            xp = coord[2];
            yp = coord[3];
            BigInteger w = new BigInteger((xp-x)+"");
            BigInteger h = new BigInteger((yp-y)+"");
            size = w.multiply(h);
        }
        public void print() {
            System.out.println("------------");
            System.out.println(x + " , " + y);
            System.out.println(xp + " , " + yp);
            System.out.println("------------");
        }
        /*
        @Override
        public int compareTo(Rect o) {
            if (this.x > o.x)
                return 1;
            else if (this.x == o.x) {
                if (this.y > o.y) {
                    return 1;
                } else if (this.y < o.y)
                    return -1;
                else
                    return 0;
            } else
                return -1;
        }*/

        public int compareTo(Rect o) {
            return this.size.compareTo(o.size);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            Rect[] rects = new Rect[K];
            for (int i = 0; i < K; i++) {
                int coord[] = new int[4];
                coord[0] = sc.nextInt();
                coord[1] = sc.nextInt();
                coord[2] = sc.nextInt();
                coord[3] = sc.nextInt();
                rects[i] = new Rect(coord);
            }

            Arrays.sort(rects);
            int[] arr = new int[K];

            //x1<=x2 && x2<x2p && x2p<=x1p
            int ans = 1;
            arr[0] = 1;
            for (int i = 1; i < K; i++) {
                int max = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (check(rects[i], rects[j])) {
                        max = Math.max(arr[j],max);
                    }
                }
                arr[i] = max+1;
                ans = Math.max(ans, arr[i]);
            }

            System.out.println("Case #"+(tc+1));
            System.out.println(ans);
        }
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
