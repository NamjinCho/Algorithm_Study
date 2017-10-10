import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-08.
 */
public class KeyProb {

    static boolean keys[];

    static class Node {
        int row;
        int col;
    }

    static Node[][] doors;
    static int R, C;
    static char map[][];
    static int doorCount[];
    static ArrayList<Node> exits;
    static ArrayList<Node> documents;
    static boolean absVisit[][];
    static int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            R = sc.nextInt();
            C = sc.nextInt();
            sc.nextLine();
            map = new char[R][C];
            doorCount = new int[26];
            doors = new Node[26][1000];
            char A = 'A';
            exits = new ArrayList<>();
            documents = new ArrayList<>();
            keys = new boolean[26];
            for (int i = 0; i < R; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < C; j++) {
                    map[i][j] = line.charAt(j);
                    if ((map[i][j] >= 'a' && map[i][j] <= 'z')) {
                        if (i == 0 || i == R - 1 || j == 0 || j == C - 1) {
                            keys[map[i][j] - 'a'] = true;
                        }
                    }
                }
            }
            String line = sc.nextLine().trim();
            char smallA = 'a';
            if (!line.equals("0")) {
                for (int i = 0; i < line.length(); i++) {
                    int idx = line.charAt(i) - smallA;
                    keys[idx] = true;
                }
            }
            removeDoor();
            for (int i = 0; i < R; i++) {
                if (map[i][0] == '.') {
                        Node n = new Node();
                        n.row = i;
                        n.col = 0;
                        exits.add(n);

                }
                if (map[i][C - 1] =='.') {
                        Node n = new Node();
                        n.row = i;
                        n.col = C - 1;
                        exits.add(n);
                }
            }
            for (int i = 0; i < C; i++) {
                if (map[0][i] == '.') {
                        Node n = new Node();
                        n.row = 0;
                        n.col = i;
                        exits.add(n);
                }
                if (map[R - 1][i] == '.') {
                        Node n = new Node();

                        n.row = R - 1;
                        n.col = i;
                        exits.add(n);
                }
            }
            absVisit = new boolean[R][C];
            for(int i=0;i<exits.size();i++)
            {
                int r = exits.get(i).row;
                int c=  exits.get(i).col ;
                absVisit[r][c] = true;
                getKeys(exits.get(i));
                getKeys(exits.get(i));
                absVisit[r][c] = false;
            }
            removeDoor();
            int ans = 0;
            for(int i=0;i<exits.size();i++)
            {
                ans = ans+getDocuments(exits.get(i));
            }
            System.out.println(ans);

        }
    }
    public static void removeDoor()
    {
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(map[i][j] >= 'A' && map[i][j] <= 'Z')
                {
                    if(keys[map[i][j]-'A'])
                    {
                        map[i][j]='.';
                    }
                }
            }
        }
    }
    public static void getKeys(Node n) {
        for(int i=0;i<4;i++)
        {
            int nr = n.row+dir[i][0];
            int nc = n.col+dir[i][1];
            if(nr>=0 && nr<R && nc>=0 && nc<C)
            {
                if(!absVisit[nr][nc])
                {
                    absVisit[nr][nc] = true;
                    if(map[nr][nc]>='a' && map[nr][nc]<='z')
                    {
                        keys[map[nr][nc]-'a'] = true;
                        map[nr][nc] ='.';
                    }
                    if(map[nr][nc]>='A' && map[nr][nc]<='Z')
                    {
                        if(keys[map[nr][nc]-'A'])
                        {
                            map[nr][nc] = '.';
                        }
                    }
                    if(map[nr][nc]=='.') {
                        Node n2= new Node();
                        n2.row = nr;
                        n2.col = nc;
                        getKeys(n2);
                    }
                    absVisit[nr][nc] = false;
                }
            }
        }
    }

    public static int getDocuments(Node n) {
        boolean visit[][] = new boolean[R][C];
        visit[n.row][n.col] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(n);
        int count = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for(int i=0;i<4;i++)
            {
                int nr = cur.row+dir[i][0];
                int nc = cur.col+dir[i][1];

                if(nr>=0 && nr<R && nc>=0 && nc<C)
                {
                    if(!visit[nr][nc])
                    {
                        visit[nr][nc] = true;
                        if(map[nr][nc]=='$')
                            count++;
                        else if(map[nr][nc]!='.')
                            continue;
                        Node go = new Node();
                        go.row = nr;
                        go.col = nc;
                        q.offer(go);
                    }
                }
            }
        }
        return count;
    }
}
