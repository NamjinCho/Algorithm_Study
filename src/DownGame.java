import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-08.
 */
public class DownGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int dir[] = {0,-1,1};
        int C = 3;
        int arr[][] = new int[N][3];
        int max[] = new int[3];
        int min[] = new int[3];
        for(int j=0;j<3;j++) {
            arr[0][j] = sc.nextInt();
            max[j] = arr[0][j];
            min[j] = arr[0][j];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
            int m2[] = new int[3];
            int m3[] = new int[3];
            for(int j=0;j<3;j++) {
                int t1=max[j];
                int t2=min[j];

                for (int k = 0; k < 3; k++) {
                    int nc = j + dir[k];
                    if(nc>=0 && nc<3)
                    {
                        t1 = Math.max(t1,max[nc]);
                        t2 = Math.min(t2,min[nc]);
                    }
                }
                m2[j] = t1+arr[i][j];
                m3[j] = t2+arr[i][j];

            }
            for(int j=0;j<3;j++)
            {
                max[j] = m2[j];
                min[j] = m3[j];

            }
        }
        int ans1=max[0];
        int ans2=min[0];
        for(int j=1;j<3;j++)
        {
            ans1=Math.max(ans1,max[j]);
            ans2=Math.min(ans2,min[j]);
        }
        System.out.println(ans1+" "+ans2);
    }


}

