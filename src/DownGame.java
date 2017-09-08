import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-08.
 */
public class DownGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int dir[][] = {{-1, -1}, {-1, 0}, {-1, 1}};
        int C = 3;
        int arr[][][] = new int[N][3][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j][0] = sc.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                arr[0][i][j] = arr[0][i][0];
            }

        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int max = 0;
                int min = Integer.MAX_VALUE;
                for (int id = 0; id < 3; id++) {
                    int nr = i + dir[id][0];
                    int nc = i + dir[id][1];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < C) {
                        min = Math.min(min, arr[nr][nc][2]);
                        max = Math.max(max, arr[nr][nc][1]);
                    }
                }
                arr[i][j][1] = arr[i][j][0] + max;
                arr[i][j][2] = arr[i][j][0] + min;
            }
        }
        int min = arr[N-1][0][2];
        int max = arr[N-1][0][1];
        for(int i=0;i<3;i++)
        {
            max = Math.max(arr[N-1][i][1],max);
            min = Math.min(arr[N-1][i][2],min);
        }
        System.out.println(max + " " + min);
    }


}

