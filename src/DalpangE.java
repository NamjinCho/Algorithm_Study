import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-07.
 */
public class DalpangE {

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int R,C,arr[][];
        int row = 0;
        int col = 0;
        int count =0;
        int idx = 0;
        int dir[][]= {{0,1},{1,0},{0,-1},{-1,0}};
        R=sc.nextInt();
        C=sc.nextInt();
        arr = new int[R][C];
        boolean f = false;
        arr[0][0]=1;
        while(true)
        {
            int nr = row +dir[idx][0];
            int nc = col + dir[idx][1];
            if(nr>=0&&nr<R && nc>=0 && nc <C)
            {
                if(arr[nr][nc]!=1)
                {
                    arr[nr][nc]=1;
                    row = nr ;
                    col = nc;
                    f=false;
                }else
                {
                    if(f == true) {
                        count--;
                        break;
                    }
                    count++;
                    idx++;
                    idx = idx%4;
                    f = true;
                }
            }else{
                if(f) {
                    count--;
                    break;
                }
                else
                {
                    idx++;
                    idx = idx%4;
                    f = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
