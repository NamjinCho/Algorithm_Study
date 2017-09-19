import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-19.
 */
public class Admin {
     public static void main(String []args)
     {
         String name = "PROBRAIN,GROW,ARGOS,ADMIN,ANT,MOTION,SPG,COMON,ALMIGHTY";
         int row =9;

         Scanner sc= new Scanner(System.in);
         int N =sc.nextInt();

         int arr[][] = new int[row][N+1];

         for(int i=0;i<row;i++)
         {
             int max=0;
             for(int c=0;c<N;c++)
             {
                arr[i][c] = sc.nextInt();
                max = Math.max(max,arr[i][c]);
             }
             arr[i][N] = max;
         }
         int max = 0;
         for(int i=0;i<row;i++)
         {
             if(arr[max][N] < arr[i][N])
                 max = i;
         }
         System.out.println(name.split(",")[max]);
     }
}
