import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by NamjinCho on 2017-07-05.
 */
public class PolygonRace {
    static double Answer;
    public static void main(String args[]) throws Exception {
        /*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));
        String st = "abc";

        System.out.print(st.substring(0,1));
        int T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {

            // Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
            int N = sc.nextInt();
            int points[][] = new int[N][2];
            double dist[][] = new double[N][N];

            for(int i=0;i<N;i++)
            {
                points[i][0] = sc.nextInt();
                points[i][1] = sc.nextInt();
            }

            double max = -1;
            for(int i=0;i<N;i++)
            {

                double [] result = getIntersection(points[i],points[0],points[N-1]);
                double tdist= (points[i][0]-result[0])*(points[i][0]-result[0]) +
                        (points[i][1]-result[1])*(points[i][1]-result[1]);
                tdist=Math.sqrt(tdist);
                max=Math.max(tdist,max);

                for(int j=0;j<N-1;j++)
                {

                        result = getIntersection(points[i],points[j],points[j+1]);
                        tdist= (points[i][0]-result[0])*(points[i][0]-result[0]) +
                                (points[i][1]-result[1])*(points[i][1]-result[1]);
                        tdist=Math.sqrt(tdist);
                        max=Math.max(tdist,max);
                }

            }
            Answer = max;

            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.format("%.2f",Answer);
        }
    }
    public static double [] getIntersection(int []p1, int []p2,int []p3)
    {
        double a[]=new double[2];        // p 와 p1, p2 를 지나는 직선과의 교점

        double m1;  // l 의 기울기
        double k1;  // l 의 방정식 y = mx + k1 의 상수 k1

        double m2;  // l 과 수직인 직선의 기울기
        double k2;  // l 과 수직인 직선의 방정식 y = mx + k2 의 상수 k2

        // 먼저 l 의 직선의 방정식부터 구합니다.
        // 구하는 방법은 두 점 p1, p2 를 지나는 직선의 방정식을 구하면 되니
        // y - yp1 = (yp1-yp2)/(xp1-xp2) * (x-xp1) 이 되겠죠.

        // 먼저 기울기를 구할 건데 예외 상황부터 먼저 처리합니다.

        // 선분이 수직일 경우
        if ( p1[0] == p2[0] )
        {
            // 이 경우 교점은 다음과 같이 교점이 구해지겠죠
            a[0] = p1[0];
            a[1] = p3[1];
        }
        // 선분이 수평일 경우
        else if ( p1[1] == p2[1] )
        {
            a[0] = p3[0];
            a[1] = p1[1];
        }
        // 그 외의 경우
        else
        {
            // 기울기 m1
            m1 = (p1[1] - p2[1]) / (p1[1] - p2[1]);
            // 상수 k1
            k1 = -m1 * p1[0] + p1[1];

            // 잘 따라오고 있죠?
            // 이제 선분 l 을 포함하는 직선의 방정식은 y = m1x + k1 이 구해졌습니다.
            // 남은 것은 점 p 를 지나고 위의 직선과 직교하는 직선의 방정식을 구해 봅시다.
            // 두 직선은 직교하기 때문에 m1 * m2 = -1 입니다.

            // 기울기 m2
            m2 = -1.0 / m1;
            // p 를 지나기 때문에 yp = m2 * xp + k2 => k2 = yp - m2 * xp
            k2 = p3[0]- m2 * p3[0];

            // 두 직선 y = m1x + k1, y = m2x + k2 의 교점을 구한다
            a[0] = (k2 - k1) / (m1 - m2);
            a[1] = m1 * a[0]+ k1;
        }

        // 구한 점이 선분 위에 있는 지 확인
        if ( a[0] >= Math.min(p1[0], p2[0]) && a[0]<= Math.max(p1[0], p2[0]) &&
                a[1]>= Math.min(p1[1], p2[1]) && a[1]<= Math.max(p1[1], p2[1]) )
        // 구한 교점이 선분위에 있으면 p 와 a 와의 거리가 최소 거리임
        {
            return a;
        }
        // 구한 교점이 선분 위에 없으면 p~p1 또는 p~p2 중 작은 값이 최소 거리임
        else
        {
            double tdist= (p1[0]-a[0])*(p1[0]-a[0]) +
                    (p1[1]-a[1])*(p1[1]-a[1]);
            tdist=Math.sqrt(tdist);
            double tdist2= (p2[0]-a[0])*(p2[0]-a[0]) +
                    (p2[1]-a[1])*(p2[1]-a[1]);
            tdist2=Math.sqrt(tdist2);
            double result[] = new double[2];
            if(tdist > tdist2) {
                result[0] = p1[0];
                result[1]=p1[1];
                //   return p1;
            }
            else{
                result[0] = p2[0];
                result[1]=p2[1];
            }
            return result;
        }
    }

}
