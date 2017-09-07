import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-07.
 */
public class Triangle {

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long arr[][] = new long [N][N];
        sc.nextLine();
        for(int i=0;i<N;i++)
        {
            String line = sc.nextLine();
            String sub[] = line.split(" ");
            for(int j=0;j<sub.length;j++)
            {
                arr[i][j] = Integer.parseInt(sub[j]);
            }
        }
        //위 왼쪽 볼수있음
        long ans = arr[0][0];
        int dir[][] = {{-1,0},{-1,-1}};
        for(int i=1;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                //1번 은 2개
                //2번은 3개
                //3번은 4개
                //4번은 5개
                if(j>i+1)
                    continue;
                long max = 0;
                for(int k=0;k<2;k++)
                {
                    int nr = i+dir[k][0];
                    int nc = j+dir[k][1];

                    if(nr>=0 && nc>=0)
                    {
                       if(max < arr[nr][nc])
                       {
                           max = arr[nr][nc];
                       }
                    }
                }
                arr[i][j] = max+arr[i][j];
                ans = Math.max(ans,arr[i][j]);
            }
        }
        System.out.println(ans);

    }
}
