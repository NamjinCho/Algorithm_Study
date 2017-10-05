import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-05.
 */
public class InOrder {
    static char[] arr;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc=1;tc<=10;tc++) {
            String line = sc.nextLine();
            N = Integer.parseInt(line);
            arr = new char[N + 1];
            for (int i = 1; i <= N; i++) {
                line = sc.nextLine();
                String sub[] = line.split(" ");
                arr[Integer.parseInt(sub[0])] = sub[1].charAt(0);
            }
            System.out.print("#"+tc + " ");
            inOrder(1);
            System.out.println();
        }
    }

    public static void inOrder(int idx) {
        if (idx > N)
            return;
        inOrder(idx * 2);
        System.out.print(arr[idx]);
        inOrder(idx * 2 + 1);
    }
}
