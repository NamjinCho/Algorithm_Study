import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-19.
 */
public class AntCave {

    static class Node implements Comparable<Node>{
        String name;
        ArrayList<Node> child;

        @Override
        public int compareTo(Node o) {

            return this.name.compareTo(o.name);
        }
    }

    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        ArrayList<Node> parents = new ArrayList<>();

        String [] lines = new String [N];
        for(int i=0;i<N;i++) {
            lines[i] = sc.nextLine();

            String sub[] = lines[i].split(" ");

            int pidx = -1;
            for(int j=0;j<parents.size();j++)
            {
                if(parents.get(j).name.equals(sub[1]))
                {
                    pidx=j;
                    break;
                }
            }
            if(pidx==-1)
            {
                    Node n = new Node();
                    n.name = sub[1];
                    n.child = new ArrayList<>();
                    parents.add(n);
                    pidx = parents.size()-1;
            }
            insert(parents.get(pidx),sub,2);
        }
        parents.sort(null);
        for(int i=0;i<parents.size();i++)
            print(parents.get(i),"");

    }
    public static void print(Node p,String alpha)
    {
        System.out.println(alpha+p.name);
        for(int i=0;i<p.child.size();i++)
            print(p.child.get(i),alpha+"--");
    }
    public static void insert(Node parent , String [] childs, int curIdx)
    {
        if(childs.length == curIdx)
            return;
        ArrayList<Node> list = parent.child;
        int pidx = -1;
        for(int j=0;j<list.size();j++)
        {
            if(list.get(j).name.equals(childs[curIdx]))
            {
                pidx=j;
                break;
            }
        }
        if(pidx==-1)
        {
            Node n = new Node();
            n.name = childs[curIdx];
            n.child = new ArrayList<>();
            list.add(n);
            pidx = list.size()-1;
        }
        Node child = list.get(pidx);
        list.sort(null);
        insert(child,childs,curIdx+1);
    }
}
