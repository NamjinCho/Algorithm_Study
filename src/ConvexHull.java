/**
 * Created by NamjinCho on 2017-06-29.
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class ConvexHull {
    /*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

    /*
       As the name of the class should be Solution , using Solution.java as the filename is recommended.
       In any case, you can execute your program by running 'java Solution' command.
     */

    static int Answer;

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
            for(int i=0;i<N;i++)
            {
                points[i][0] = sc.nextInt();
                points[i][1] = sc.nextInt();
            }
            int yMin = Integer.MAX_VALUE;
            int yMinIndex=-1;
            int xMin = Integer.MAX_VALUE;
            int xMinIndex = -1;
            for(int i=0;i<N;i++)
            {
                if(points[i][1] < yMin)
                {
                    yMin = points[i][1];
                    yMinIndex = i;
                }
            }
            xMinIndex = yMinIndex;
            xMin = points[yMinIndex][0];
            for(int i = 0;i<N;i++)
            {
                if(yMin == points[i][1])
                {
                    if(xMin > points[i][0])
                    {
                        xMin = points[i][0];
                        xMinIndex = i;
                    }
                }
            }
            int tmp1 = points[xMinIndex][0];
            int tmp2 = points[xMinIndex][1];

            points[xMinIndex][0] = points[0][0];
            points[xMinIndex][1] = points[0][1];
            points[0][0] = tmp1;
            points[0][1] = tmp2;

            class ForAngle implements Comparable<ForAngle>{
                int index;
                double angle;
                double distance;
                public int compareTo(ForAngle p) {
                    if (this.angle < p.angle)
                        return -1;
                    else if (this.angle > p.angle)
                        return 1;
                    else {
                        if (this.distance < p.distance)
                            return -1;
                        else if (this.distance > p.distance)
                            return 1;
                    }
                    return 0;
                }
            };
            ArrayList<ForAngle> arrayList = new ArrayList<>();
            for(int i=1;i<N;i++)
            {
                ForAngle f = new ForAngle();

                f.index = i;
                f.angle = angle(points[0][0],points[0][1],points[i][0],points[i][1]);
                f.distance = (points[0][0]-points[i][0])* (points[0][0]-points[i][0]) + (points[0][1]-points[i][1])*(points[0][1]-points[i][1]);
                arrayList.add(f);
            }
            //sort
            Collections.sort(arrayList);

            Stack<int[]> stack = new Stack<>();
            stack.push(points[0]);
            stack.push(points[arrayList.get(0).index]);
            stack.push(points[arrayList.get(1).index]);
            for(int i=2;i<arrayList.size();i++)
            {
                int p1[] = stack.pop();
                int p2[] = stack.pop();
                int nIndex = arrayList.get(i).index;
                int ccwValue = ccw(p1[0],p1[1],p2[0],p2[1],points[nIndex][0],points[nIndex][1]);
                if(ccwValue<0)
                {
                    stack.push(p1);
                    stack.push(points[nIndex]);
                }else
                {
                    stack.push(p1);
                    stack.push(p2);
                    stack.push(points[nIndex]);
                }
            }
            ForAngle f = new ForAngle();
            f.index = 0;
            arrayList.add(0,f);
            int length = stack.size();
            int arr[][] = new int[length][2];
            int index = 0;
            while(!stack.empty())
            {
                arr[index] = stack.pop();
                index++;
            }
            double minDist = Double.MAX_VALUE;

            for(int i=0;i<length;i++)
            {
                System.out.println("x - " + arr[i][0] + "y - " + arr[i][1]);
                double [] result = getIntersection(arr[i],arr[0],arr[length-1]);
                double tdist= (arr[i][0]-result[0])*(arr[i][0]-result[0]) +
                        (arr[i][1]-result[1])*(arr[i][1]-result[1]);
                tdist=Math.sqrt(tdist);
                if(tdist!=0)
                    minDist=Math.min(tdist,minDist);

                for(int j=0;j<length-1;j++)
                {

                    result = getIntersection(arr[i],arr[j],arr[j+1]);
                    tdist= (arr[i][0]-result[0])*(arr[i][0]-result[0]) +
                            (arr[i][1]-result[1])*(arr[i][1]-result[1]);
                    tdist=Math.sqrt(tdist);
                    if(tdist!=0)
                        minDist=Math.min(tdist,minDist);
                }

            }
            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.format("%.2f",minDist);
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
    public static double angle(int x1,int y1, int x2,int y2) {

        double result = (double)(y1 - y2) / (x1 - x2);
        return Math.atan(result);
    }
    public static int ccw(int x1,int y1 , int x2 , int y2, int x3,int y3) {

        // ( X1 * Y2 + X2 * Yp + Xp * Y1) - (X1 * Yp + X2 * Y1 + Xp * Y2);


        double result = (x1 * y2 + x2 * y3 + x3 * y1) - (x1 * y3 + x2 * y1 + x3 * y2);
        if (result > 0)
            return 1;
        else if (result == 0)
            return 0;
        else
            return -1;
    }


}
