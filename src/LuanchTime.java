import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-10.
 */
public class LuanchTime {

    static class Person implements Comparable<Person>{
        int row;
        int col;
        int sel;
        int dist;
        int leftTime;
        public void calDist(Stair s , int ss)
        {
            int difR = s.row-this.row;
            int difC = s.col - this.col;
            difC = Math.abs(difC);
            difR = Math.abs(difR);
            sel = ss;
            dist = difR+difC;
        }

        @Override
        public int compareTo(Person o) {
            if(dist < o.dist)
                return -1;
            else if(dist>o.dist)
                return 1;
            return 0;
        }
    }
    static class Stair{
        int row;
        int col;
        int length;
        ArrayList<Person> onList;
        ArrayList<Person> waitList;
    }
    static ArrayList<Person> list;
    static int N;
    static int ans;
    static int []select;
    static Stair[] stairs;
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1;tc<=T;tc++)
        {
            N = sc.nextInt();

            list = new ArrayList<>();
            ans= Integer.MAX_VALUE;
            stairs = new Stair[2];
            int co = 0;
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    int tmp = sc.nextInt();
                    if(tmp==1)
                    {
                        Person p = new Person();
                        p.row = i;
                        p.col = j;
                        list.add(p);
                    }else if(tmp>=2)
                    {
                        stairs[co] = new Stair();
                        stairs[co].row = i;
                        stairs[co].col = j;
                        stairs[co].length = tmp;
                        stairs[co].onList = new ArrayList<>();
                        stairs[co].waitList = new ArrayList<>();
                        co++;
                    }
                }
            }
            select = new int[list.size()];
            co = 0;
            dfs(0);
            System.out.println("#"+tc+" "+ans);
        }
    }
    public static void solution()
    {

        //1차 대기 큐에 다 넣음
        for(int i=0;i<list.size();i++)
        {
            list.get(i).calDist(stairs[select[i]],select[i]);
            stairs[select[i]].waitList.add(list.get(i));
            list.get(i).leftTime=stairs[select[i]].length;
        }
        int time=1;
        stairs[0].waitList.sort(null);
        stairs[1].waitList.sort(null);
        while (time<ans)
        {
           // System.out.println(time);
            for(int i=0;i<2;i++)
            {
                for(int j=0;j<stairs[i].onList.size();j++)
                {
                    stairs[i].onList.get(j).leftTime--;
                    if(stairs[i].onList.get(j).leftTime==0)
                    {
                        stairs[i].onList.remove(j);
                        j--;
                    }
                }
            }

            for(int i=0;i<2;i++)
            {
                while (true)
                {
                    if(stairs[i].waitList.size()<= 0 || stairs[i].onList.size()==3)
                        break;
                    if(stairs[i].waitList.get(0).dist > time)
                        break;

                    stairs[i].onList.add(stairs[i].waitList.get(0));
                    stairs[i].waitList.remove(0);
                }
            }


            //다비었는지 확인
            boolean f = true;
            for(int i=0;i<2;i++)
            {
                if(stairs[i].waitList.size()==0 && stairs[i].onList.size()==0)
                {
                    continue;
                }else
                    f = false;
            }
            time++;
            if(f)
                break;
        }
        ans = Math.min(ans,time);
        stairs[0].onList=new ArrayList<>();
        stairs[0].waitList = new ArrayList<>();
        stairs[1].onList = new ArrayList<>();
        stairs[1].waitList = new ArrayList<>();
    }
    public static void dfs(int idx)
    {
        if(idx == list.size())
        {
            solution();
            return;
        }
        select[idx] = 0;
        dfs(idx+1);
        select[idx] = 1;
        dfs(idx+1);


    }

}
