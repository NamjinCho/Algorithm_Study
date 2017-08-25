import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-25.
 */
public class PictureCompare {


    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String picture [][] = new String[N+1][5];

        for(int i=1;i<=N;i++)
        {
            for(int j=0;j<5;j++)
            {
                picture[i][j]=sc.nextLine();
            }
        }
        int a=0,b=0;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<N;i++)
        {
            for(int j=i+1;j<=N;j++)
            {
                int r = compare(picture[i],picture[j]);

                if(min>r)
                {
                    a=i;
                    b=j;
                    min=r;
                }
            }
        }
        System.out.println(a + " " + b);
    }
    public static int compare(String a[], String b[])
    {
        int result = 0;
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<7;j++)
            {
                if(a[i].charAt(j)!=b[i].charAt(j))
                    result++;
            }
        }
        return result;
    }
}
