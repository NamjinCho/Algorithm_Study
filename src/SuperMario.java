import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-27.
 */
public class SuperMario {
    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);
        int arr[] = new int[10];
        arr[0] = sc.nextInt();
        int a = 1;
        for(int i = 1;i<10;i++)
        {
            arr[i] = arr[i-1] + sc.nextInt();
        }

        int minIdx = 0;
        for(int i=1;i<10;i++)
        {
            if(Math.abs(arr[minIdx]-100) >= Math.abs(arr[i]-100))
                minIdx = i;
        }
        System.out.println(arr[minIdx]);
    }
}
