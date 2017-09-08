import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-08.
 */
public class Dump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int arr[] = new int[100];
        for (int tc = 1; tc <= T; tc++) {
            int ans = 0;
            int N = sc.nextInt();
            for (int i = 0; i < 100; i++) {
                arr[i] = sc.nextInt();
            }
            int max = 0;
            int min = 0;
            for (int i = 0; i < N; i++) {
                max = 0;
                min = 0;

                for (int j = 0; j < 100; j++) {
                    if (arr[j] > arr[max]) {
                        max = j;
                    }
                    if (arr[j] < arr[min]) {
                        min = j;
                    }
                }
                if(arr[max]-arr[min]<=1)
                {
                    break;
                }
                arr[min]++;
                arr[max]--;

            }

            max = 0;
            min = 0;

            for (int j = 0; j < 100; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            ans = arr[max] - arr[min];
            System.out.println("#" + tc + " " + ans);
        }
    }
}
