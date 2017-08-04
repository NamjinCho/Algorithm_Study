import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-03.
 */
public class Escape {

    static int N, M;
    static char[][] map;
    static boolean visit[][];

    static class Node {
        int row;
        int col;
        int cost;
        boolean isWater;

        Node(int r, int c, int co, boolean f) {
            row = r;
            col = c;
            cost = co;
            isWater = f;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        int r[], c[];
        r = new int[2];
        c = new int[2];
        sc.nextLine();
        visit = new boolean[N][M];
        Queue<Node> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    r[0] = i;
                    c[0] = j;
                    visit[i][j] = true;
                } else if (map[i][j] == 'D') {
                    r[1] = i;
                    c[1] = j;
                } else if (map[i][j] == '*') {
                    que.offer(new Node(i, j, 0, true));
                    visit[i][j] = true;
                }
            }
        }

        que.offer(new Node(r[0], c[0], 0, false));
        int ans = bfs(que);
        if(ans == -1)
            System.out.println("KAKTUS");
        else
            System.out.println(ans);
    }

    public static int bfs(Queue<Node> q) {
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        while (!q.isEmpty()) {

            Node n = q.poll();

            for(int i=0;i<4;i++)
            {
                int nr = n.row + dir[i][0];
                int nc = n.col + dir[i][1];
                if(nr >= 0 && nr < N && nc >=0 && nc <M)
                {
                    if(!visit[nr][nc])
                    {
                        if(map[nr][nc]=='X')
                            continue;

                        if(n.isWater)
                        {
                            if(map[nr][nc]=='D')
                                continue;

                            visit[nr][nc]=true;
                            q.offer(new Node(nr,nc,0,true));
                        }
                        else
                        {
                            if(map[nr][nc]=='D')
                                return n.cost+1;
                            visit[nr][nc]=true;
                            q.offer(new Node(nr,nc,n.cost+1,false));
                        }
                    }
                }
            }
        }

        return -1;
    }
}


