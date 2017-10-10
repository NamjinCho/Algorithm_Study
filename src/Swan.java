import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-08.
 */
public class Swan {

    static int R;
    static int C;
    static char map[][];
    static int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean visit[][];

    static class Pair {
        int row;
        int col;

        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];

        sc.nextLine();
        Queue<Pair> q = new LinkedList<>();
        int r=0, c=0;
        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '.')
                    q.offer(new Pair(i, j));
                else if (map[i][j] == 'L') {
                    r = i;
                    c = j;
                    q.offer(new Pair(i,j));
                }
            }
        }
        int ans = 0;
        visit = new boolean[R][C];
        Queue<Pair> q2 = new LinkedList<>();
        q2.offer(new Pair(r,c));
        while (true) {
            q2 = bfs(q2);
            if(q2==null)
                break;
            q = deletion(q);
            ans++;


        }
       System.out.println(ans);
    }

    public static Queue<Pair> deletion(Queue<Pair> q)
    {
        Queue<Pair> result= new LinkedList<>();

        while (!q.isEmpty())
        {
            Pair p = q.poll();
            for(int i=0;i<4;i++)
            {
                int nr = p.row+dir[i][0];
                int nc = p.col+dir[i][1];

                if(nr>=0 && nc>=0&& nr<R && nc<C)
                {
                    //System.out.println(map[nr][nc]);
                    if(map[nr][nc] == 'X')
                    {
                        map[nr][nc] = '.';
                        result.offer(new Pair(nr,nc));
                    }
                }

            }
        }

        return result;
    }

    public static Queue<Pair> bfs(Queue<Pair> q) {
        Queue<Pair>result = new LinkedList<>();
        while (!q.isEmpty())
        {
            Pair p = q.poll();
            visit[p.row][p.col] = true;
            for(int i=0;i<4;i++)
            {
                int nr = p.row+dir[i][0];
                int nc = p.col+dir[i][1];

                if(nr>=0 && nc>=0&& nr<R && nc<C)
                {
                    if(!visit[nr][nc])
                    {
                        visit[nr][nc] = true;
                        if(map[nr][nc]=='L') {
                            //System.out.println(nr + " " + nc + " / " + row + " " + col);
                            return null;
                        }
                        if(map[nr][nc]=='.')
                            q.offer(new Pair(nr,nc));
                        if(map[nr][nc] == 'X')
                            result.offer(new Pair(nr,nc));
                    }
                }

            }
        }
        return result;
    }
}
