import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-21.
 */
public class Parking {

    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int A,B,C;
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        int arr[][] = new int [3][2];

        int max= 0 ;
        for(int i=0;i<3;i++)
        {
            int s = sc.nextInt();
            int e = sc.nextInt();
            max = Math.max(e,max);
            arr[i][0] = s;
            arr[i][1] = e;
        }
        int cost[] = new int[max+1];
        for(int i=0;i<3;i++)
        {
            for(int j=arr[i][0];j<arr[i][1];j++)
            {
                cost[j]++;
            }
        }
        int ans = 0;
        for(int i=1;i<=max;i++)
        {
            if(cost[i]==1)
                ans+=A;
            else if(cost[i]==2)
                ans+=(B*2);
            else if(cost[i]==3)
                ans+=(C*3);
        }
        System.out.println(ans);

    }
}
