import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-30.
 */
public class SelectNum {

    static int N;
    static int arr[];
    static boolean check[];
    static LinkedList<Integer> list;
    static int start, count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        check = new boolean[N + 1];
        arr = new int[N + 1];
        list = new LinkedList<>();
        boolean ans[] = new boolean[N+1];
        for (int i = 1; i <= N; i++)
            arr[i] = sc.nextInt();
        count = 0;
        for (int i = 1; i <= N; i++) {
            if(ans[i]==false) {
                start = i;
                check = new boolean[N + 1];
                int r = checkCycle(i, false);
                if (r == 1) {
                    while (!list.isEmpty()) {
                        ans[list.removeLast()] = true;
                        count++;
                    }
                } else {
                    list = new LinkedList<>();
                }
            }
        }
        System.out.println(count);
        for (int i = 1; i <=N; i++) {
            if(ans[i])
                System.out.println(i);
        }
    }

    public static int checkCycle(int s, boolean f) {
        if (start == s && f!=false) {
            return 1;
        }
        if (check[arr[s]])
            return -1;

        check[arr[s]] = true;
        list.add(s);
        return checkCycle(arr[s],true);
    }
}
