import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-10.
 */
public class RepairShop {

    static int N, M, K, A, B;

    static class Desk {
        int idx;
        int customerIdx;
        int time;
    }

    static class Person {
        int idx;
        int tk;
        int leftTime;
        Desk deskA;
        Desk deskB;

    }

    static Desk deskA[], deskB[];
    static Person [] persons;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();
            A = sc.nextInt();
            B = sc.nextInt();
            int leftPerson = K;
            deskA = new Desk[N + 1];
            deskB = new Desk[M + 1];
            persons = new Person[K+1];
            ArrayList<Person> q = new ArrayList<>();
            ArrayList<Person> qB = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                int ai = sc.nextInt();
                deskA[i] = new Desk();
                deskA[i].idx = i;
                deskA[i].customerIdx = -1;
                deskA[i].time = ai;
            }
            for (int i = 1; i <= M; i++) {
                int bi = sc.nextInt();
                deskB[i] = new Desk();
                deskB[i].idx = i;
                deskB[i].customerIdx = -1;
                deskB[i].time = bi;
            }

            for (int i = 1; i <= K; i++) {
                int tk = sc.nextInt();

                persons[i] = new Person();
                persons[i].idx = i;
                persons[i].tk = tk;
                q.add(persons[i]);
            }

            q.sort(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    if (o1.tk < o2.tk)
                        return -1;
                    else if (o1.tk > o2.tk)
                        return 1;
                    return 0;
                }
            });
            //solve
            int time = 0;

            while (true) {

                //여기는 A창구 처리
                for(int i=1;i<=N;i++)
                {
                    int pidx = deskA[i].customerIdx;
                    if(pidx==-1)
                        continue;
                    persons[pidx].leftTime--;
                    if(persons[pidx].leftTime<=0)
                    {
                        qB.add(persons[pidx]);
                        deskA[i].customerIdx = -1;
                    }
                }
                for(int i=1;i<=M;i++)
                {
                    int pidx = deskB[i].customerIdx;
                    if(pidx==-1)
                        continue;
                    persons[pidx].leftTime--;
                    if(persons[pidx].leftTime<=0)
                    {
                        deskB[i].customerIdx = -1;
                        leftPerson--;
                    }
                }

                int bid;
                while (qB.size()!=0&&(bid = emptyRepair())!=-1)
                {
                    int pidx = qB.get(0).idx;
                    deskB[bid].customerIdx = pidx;
                    persons[pidx].deskB = deskB[bid];
                    persons[pidx].leftTime = deskB[bid].time;
                    qB.remove(0);
                }

                while (q.size()!=0&&q.get(0).tk <= time)
                {
                    int idx = emptyDesk();
                    //빈창구 있는지 확인
                    if(idx!=-1)
                    {
                        Person p = q.get(0);
                        q.remove(0);
                        deskA[idx].customerIdx = p.idx;
                        p.deskA = deskA[idx];
                        p.leftTime = deskA[idx].time;
                    }else
                        break;
                    //없으면 대기
                }


                //여기는 B창구 처리
                time++;
                if(leftPerson <=0)
                    break;
            }
            int ans = 0;
            for(int i=1;i<=K;i++)
            {
                //System.out.println(persons[i].deskA.idx + " " + persons[i].deskB.idx);
                if(persons[i].deskA.idx == A && persons[i].deskB.idx==B)
                    ans +=persons[i].idx;
            }
            if(ans==0)
                ans = -1;
            System.out.println("#"+tc + " " + ans);

        }

    }
    public static int emptyRepair()
    {
        for(int i=1;i<=M;i++)
        {
            if(deskB[i].customerIdx==-1)
                return i;
        }

        return -1;
    }
    public static int emptyDesk()
    {
        for(int i=1;i<=N;i++)
        {
            if(deskA[i].customerIdx==-1)
                return i;
        }
        return -1;
    }
}
