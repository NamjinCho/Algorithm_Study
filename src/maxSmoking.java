import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-11.
 */
public class maxSmoking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int arr[][];
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = 0;
            int total = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    total = total + arr[i][j];
                }
            }

            int rTotal = total;
            int tmpTotal = total;
            ans = total;
            for (int i = 0; i + M - 1 < N; i++) {

                tmpTotal = rTotal;
                for (int j = 1; j + M - 1 < N; j++) {
                    int tmp = 0;

                    for (int k = i; k < i + M; k++) {
                        tmp += arr[k][j - 1];
                    }
                    tmpTotal = tmpTotal - tmp;
                    tmp = 0;
                    for (int k = i; k < i + M; k++) {
                        tmp += arr[k][j + M - 1];
                    }
                    tmpTotal = tmpTotal + tmp;
                    if(ans < tmpTotal)
                        ans = tmpTotal;
                }

                if (i + M - 1 == N - 1)
                    continue;

                int tmp = 0;
                for (int k = 0; k < M; k++) {
                    tmp = tmp + arr[i][k];
                }
                rTotal = rTotal - tmp;
                tmp = 0;
                for (int k = 0; k < M; k++) {
                    tmp = tmp + arr[i + M][k];
                }
                rTotal = rTotal + tmp;
                if(ans < rTotal)
                    ans = rTotal;
                //total 한칸 내리기
            }

            System.out.println("#" + tc + " " + ans);
        }

    }
}
