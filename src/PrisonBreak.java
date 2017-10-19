import java.math.BigInteger;
import java.util.*;

/**
 * Created by NamjinCho on 2017-10-18.
 */
public class PrisonBreak {

    static class Person{
        int row;
        int col;
        BigInteger visitDoor;
        Person(int r,int c,BigInteger v)
        {
            row = r;
            col = c;
            visitDoor = v;
        }
    }
    static class Door{
        int row;
        int col;
    }
    static int N,M;
    static Person p[];
    static ArrayList<Door> ds;
    static char map[][];
    public static void main(String []args)
    {
        Scanner sc=  new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++)
        {
            N = sc.nextInt();
            M = sc.nextInt();
            map = new char[N][M];
            ds = new ArrayList<>();
            p = new Person[2];
            int k=0;
            sc.nextLine();
            for(int i=0;i<N;i++)
            {
                String line = sc.nextLine();
                for(int j=0;j<M;j++)
                {
                    map[i][j] = line.charAt(j);
                    if(map[i][j]=='$')
                    {
                        p[k] = new Person(i,j,new BigInteger("0"));
                        k++;
                    }else if(map[i][j]=='#')
                    {
                        Door d = new Door();
                        d.row = i;
                        d.col = j;
                        ds.add(d);
                    }
                }
            }
            ArrayList<Person> p1 = bfs(p[0]);
            ArrayList<Person> p2 = bfs(p[1]);
            int l1 =p1.size();
            int l2 = p2.size();
            int ans = Integer.MAX_VALUE;
            for(int i=0;i<l1;i++)
            {
                for(int j=0;j<l2;j++)
                {
                    BigInteger t1 = p1.get(i).visitDoor.or(p2.get(j).visitDoor);
                    ans = Math.min(ans,t1.bitCount());
                }
            }
            System.out.println(ans);
        }
    }
    public static ArrayList<Person> bfs(Person p)
    {
        int visit[][] = new int[N][M];
        for(int i=0;i<N;i++)
            Arrays.fill(visit[i],Integer.MAX_VALUE);
        visit[p.row][p.col] = 0;
        Queue<Person> q = new LinkedList<>();
        q.offer(p);
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        ArrayList<Person> ans = new ArrayList<>();
        while (!q.isEmpty())
        {
            Person pp = q.poll();
            if(pp.row == 0 || pp.col==0 || pp.row==N-1 || pp.col==M-1)
            {
                ans.add(pp);
                continue;
            }
            for(int i=0;i<4;i++)
            {
                int nr = pp.row+dir[i][0];
                int nc = pp.col+dir[i][1];
                if(nr>=0 && nr<N && nc>=0 &&nc <M)
                {
                    if(map[nr][nc]!='*')
                    {
                       if(map[nr][nc]=='#')
                       {
                           int idx = find(nr,nc);
                           BigInteger t = new BigInteger("1");
                           t= t.shiftLeft(idx);
                           BigInteger tmp = pp.visitDoor.or(t);
                           if(visit[nr][nc] > tmp.bitCount())
                           {
                               visit[nr][nc] = tmp.bitCount();
                               Person np = new Person(nr,nc,tmp);
                               q.offer(np);
                           }

                       }else
                       {
                           if(visit[nr][nc] > pp.visitDoor.bitCount())
                           {
                               visit[nr][nc] = pp.visitDoor.bitCount();
                               BigInteger tmp = new BigInteger(pp.visitDoor.toString());
                               Person np = new Person(nr,nc,tmp);
                               q.offer(np);
                           }
                       }
                    }
                }

            }
        }

        return ans;
    }
    public static int find(int row,int col)
    {
        for(int i=0;i<ds.size();i++)
        {
            Door d= ds.get(i);
            if(d.row == row && d.col==col)
                return i;
        }
        return -1;
    }
}
