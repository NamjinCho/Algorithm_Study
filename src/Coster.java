import java.util.Scanner;
public class Coster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        for(int i=0;i<r*c;i++)
        {
            sc.nextInt();
        }
        boolean flag = true;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c-1;j++)
            {
                if(flag) {
                    System.out.print("R");
                }else {
                    System.out.print("L");
                }
            }
            flag=!flag;
            if(i<r-1)
                System.out.print("D");
        }
        System.out.println();
    }
}