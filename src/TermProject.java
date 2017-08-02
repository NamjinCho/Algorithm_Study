import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-30.
 */
public class TermProject {

    static int N;
    static int arr[];
    static boolean check[];
    static LinkedList<Integer> list;
    static int start, count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc= 0;tc<T;tc++) {
            N = sc.nextInt();
            check = new boolean[N + 1];
            arr = new int[N + 1];
            list = new LinkedList<>();
            boolean ans[] = new boolean[N + 1];
            for (int i = 1; i <= N; i++)
                arr[i] = sc.nextInt();
            count = 0;

            System.out.println(N - count);
        }
    }

    public static int dfs(int a,int start,int count)
    {
        if(start == a && count !=1)
        {
            return count;
        }else if(start == a && arr[a] == a && count==1)
            return 1;

        return 0;

    }
}
