import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-06.
 */
public class Ladder {

    static int arr[][];
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            tc = sc.nextInt();
            N = 100;
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 100; i++) {
                if (arr[0][i] == 1) {
                    int tmp = i;
                    int result = goLadder(tmp);
                    if(min>=result)
                    {
                        min = result;
                        ans = i;
                    }


                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }

    public static int goLadder(int col) {
        int dir[][] = {{0, 1}, {0, -1}, {1, 0}};
        int nr = 0;
        int nc = col;
        int length = 1;
        while (nr < N - 1) {
            boolean f = false;

            for (int i = 0; i < 2; i++) {
                int tr = nr + dir[i][0];
                int tc = nc + dir[i][1];
                if (tc >= 0 && tc < N) {
                    if (arr[tr][tc] != 0) {
                        length++;
                        while((tc>=0 && tc<N) &&arr[tr][tc]!=0)
                        {
                            tc=tc+dir[i][1];
                            length++;
                        }
                        length--;
                        tc=tc-dir[i][1];
                        nr = tr;
                        nc = tc;
                        break;
                    }
                }
            }
            nr = nr + dir[2][0];
            nc = nc + dir[2][1];
            length++;
        }
        return length-1;
    }
}
