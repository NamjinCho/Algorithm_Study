import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-02.
 */
public class SwimPool {

    static int days [];
    static int pay[];
    static int jump[] = {1,1,3,12};
    static int ans;
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        int T =sc.nextInt();
        for(int tc=1;tc<=T;tc++)
        {
            pay= new int[4];
            for(int i=0;i<4;i++)
                pay[i] = sc.nextInt();

            days = new int[12];

            for(int i=0;i<12;i++)
                days[i] = sc.nextInt();
            ans = Integer.MAX_VALUE;
            dfs(0,0);
            System.out.println(ans);
        }
    }
    public static void dfs(int curMon,int sum)
    {
        if (curMon>=12) {
            ans = Math.min(ans,sum);
            return;
        }
        if(ans<sum)
            return;

        dfs(curMon+jump[0],sum+(pay[0]*days[curMon]));
        for(int i=1;i<=3;i++) {
            dfs(curMon + jump[i], sum + pay[i]);
        }
    }
}
