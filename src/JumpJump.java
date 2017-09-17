import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-20.
 */
public class JumpJump {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [][]arr = new int[N+1][2];
        for (int i=1;i<N+1;i++)
        {
            arr[i][0] = sc.nextInt();
            arr[i][1] = Integer.MAX_VALUE;
        }
        arr[1][1] = 0;
        for(int i=1;i<N;i++)
        {

            if(arr[i][1]==Integer.MAX_VALUE)
                continue;

            for(int j=1;j<=arr[i][0];j++)
            {
                if(j+i>N)
                    break;
                arr[i+j][1] = Math.min(arr[i+j][1],arr[i][1]+1);
            }
        }
        if(arr[N][1]==Integer.MAX_VALUE)
            arr[N][1] = -1;
        System.out.println(arr[N][1]);
    }
}
