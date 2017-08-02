import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-02.
 */
public class Exercise {


    public static void main(String [] args)
    {
        //N m M T R ,M은 최대치 N분 운동 목표  m 은 맥박 및 최소치, R은 감소치 T 는 증가치
        Scanner sc = new Scanner(System.in);
        int N , m ,M,T,R,x;
        N = sc.nextInt();
        m = sc.nextInt();
        M= sc.nextInt();
        T=sc.nextInt();
        R=sc.nextInt();
        x=m;
        int time = 0,eT=0;
        if(m+T >M)
        {
            System.out.println(-1);
            return;
        }
        while(eT<N)
        {
            if(x+T <= M)
            {
                x=x+T;
                eT++;
                time++;
                continue;
            }else{
                x= x-R;
                if(x <m)
                    x=m;
                time++;
            }
        }
        System.out.println(time);
    }

}
