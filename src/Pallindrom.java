import java.io.*;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-15.
 */
public class Pallindrom {

    public static void main(String[] args) {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int N = 0;
        try {
            N = Integer.parseInt(sc.readLine());

            int arr[] = new int[N + 1];
            String line = sc.readLine();
            String [] sub = line.split(" ");
            for (int i = 1; i <= N; i++)
                arr[i] = Integer.parseInt(sub[i-1]);

            boolean dp[][] = new boolean[N + 1][N + 1];
            int pal[] = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = i; j <= N; j++) {
                    pal[j] = arr[j];
                    dp[i][j] = check(pal, i, j);
                }
            }
            int K = Integer.parseInt(sc.readLine());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < K; i++) {
                line = sc.readLine();
                sub = line.split(" ");
                int s = Integer.parseInt(sub[0]);
                int e = Integer.parseInt(sub[1]);
                if (dp[s][e])
                    bw.write(1+"\n");
                else
                    bw.write(0+"\n");
            }
            bw.flush();
            sc.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 12
    public static boolean check(int[] pal, int s, int e) {
        while (s <= e) {
            if (pal[s] != pal[e])
                return false;
            s++;
            e--;
        }

        return true;
    }
}
