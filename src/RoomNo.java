import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-26.
 */
public class RoomNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int map[] = new int[10];
        if (N == 0) {
            System.out.println(1);
            return;
        }

        while (N != 0) {
            int idx = N % 10;
            N = N / 10;
            if(idx==9)
                idx=6;
            map[idx]++;
        }
        int t = map[6]/2;
        if(map[6]%2 == 1)
            t++;
        map[6]=t;
        int max = -1;
        int mi = 0;
        for (int i = 0; i < 9; i++) {
            if (max < map[i]) {
                max = map[i];
            }
        }
        System.out.println(max);
    }
}
