import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by NamjinCho on 2017-10-21.
 */
public class CarFactory {
    static int N, M;

    static class Employee {
        int salary;
        ArrayList<Integer> adl = new ArrayList<>();
    }

    static Employee[] employees;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String line = br.readLine();
            String [] sub = line.split( " ");
            N = Integer.parseInt(sub[0]);
            M = Integer.parseInt(sub[1]);
            line = br.readLine();
            employees = new Employee[N+1];
            employees[1] = new Employee();
            employees[1].salary = Integer.parseInt(line);
            for(int i=2;i<=N;i++)
            {
                employees[i] = new Employee();
                line = br.readLine();
                sub = line.split(" ");
                employees[i].salary = Integer.parseInt(sub[0]);
                int master = Integer.parseInt(sub[1]);
                employees[master].adl.add(i);
                employees[1].adl.add(i);
            }
            for(int i=0;i<M;i++)
            {
                line = br.readLine();
                sub = line.split(" ");
                if(sub[0].equals("p"))
                {
                    int m = Integer.parseInt(sub[1]);
                    int w = Integer.parseInt(sub[2]);
                    bfs(m,w);
                }else
                {
                    int idx = Integer.parseInt(sub[1]);
                    bw.write(employees[idx].salary+"\n");
                }
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void bfs(int m,int w)
    {
        boolean visit[] = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        int len = employees[m].adl.size();
        for(int i=0;i<len;i++)
        {
            int serv = employees[m].adl.get(i);
            q.offer(serv);
            employees[serv].salary +=w;
            visit[serv] = true;
        }
        while (!q.isEmpty())
        {
            int midx = q.poll();
            len = employees[midx].adl.size();
            for(int i=0;i<len;i++)
            {
                int serv = employees[midx].adl.get(i);
                if(!visit[serv])
                {
                    q.offer(serv);
                    employees[serv].salary +=w;
                    visit[serv] = true;
                }
            }
        }
    }
}
