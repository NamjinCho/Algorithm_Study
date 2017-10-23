import java.util.*;

/**
 * Created by NamjinCho on 2017-10-22.
 */
public class Directory {

    static class Foolder{
        String name;
        String parent;
        ArrayList<Foolder> child = new ArrayList<>();
    }
    static HashMap<String , Foolder> map;

    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++)
        {
            int N = sc.nextInt();
            sc.nextLine();
            map = new HashMap<>();
            for(int i=0;i<N-1;i++)
            {
                String line = sc.nextLine();
                String sub[] = line.split(" ");
                if(sub[0].equals("Add"))
                {
                    Foolder parent;
                    if(map.containsKey(sub[1]))
                    {
                        parent = map.get(sub[1]);
                    }else
                    {
                        parent = new Foolder();
                        parent.name = sub[1];
                        map.put(sub[1],parent);
                    }
                    Foolder child;
                    if(map.containsKey(sub[2]))
                    {
                        child = map.get(sub[2]);
                    }else
                    {
                        child = new Foolder();
                        child.name = sub[2];
                        child.parent=sub[1];
                        map.put(sub[2],child);
                    }
                    if(parent.child.size()==4)
                        continue;
                    else
                        parent.child.add(child);
                }else
                {
                    Foolder del = map.get(sub[1]);
                    String parent = del.parent;
                    Foolder foolder = map.get(parent);
                    foolder.child.remove(del);
                }
            }
            int ans = bfs(sc.nextLine().split(" ")[1]);
            System.out.println("#"+tc+" "+ans);

        }
    }
    public static int bfs(String first)
    {
        HashSet<String> visit = new HashSet<>();
        visit.add(first);
        Queue<String> q = new LinkedList<>();
        int count =1;
        q.offer(first);
        while (!q.isEmpty())
        {
            String p = q.poll();
            Foolder pp = map.get(p);
            for(int i=0;i<pp.child.size();i++)
            {
                String c = pp.child.get(i).name;
                if(!visit.contains(c))
                {
                    count++;
                    visit.add(c);
                    q.offer(c);
                }
            }
        }

        return count;
    }
}
