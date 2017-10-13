import java.util.*;

/**
 * Created by NamjinCho on 2017-10-01.
 */
public class NoBio {

    static int N, M, K;

    static class Bio implements Comparable<Bio> {

        int num;
        int dir;
        ArrayList<Bio> sum;

        public int compareTo(Bio o) {
            if(num < o.num)
                return 1;
            else if(num>o.num)
                return -1;
            return 0;
        }
    }

    static int dir[][] = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Bio[][] before, after;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();
            before = new Bio[N][N];
            for (int i = 0; i < K; i++) {
                //r,c,num,dir;

                int r = sc.nextInt();
                int c = sc.nextInt();
                int num = sc.nextInt();
                int dir = sc.nextInt();

                Bio b = new Bio();
                b.num = num;
                b.dir = dir;
                b.sum = new ArrayList<>();
                before[r][c] = b;
            }

            for (int time = 0; time < M; time++) {

                after = new Bio[N][N];

                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (before[r][c] != null) {

                            if (before[r][c].sum.size() != 0) {
                                merger(before[r][c]);
                            }

                            int nr = r + dir[before[r][c].dir][0];
                            int nc = c + dir[before[r][c].dir][1];

                            if (after[nr][nc] != null) {
                                after[nr][nc].sum.add(before[r][c]);
                            } else
                                after[nr][nc] = before[r][c];

                            if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
                                after[nr][nc].num = after[nr][nc].num / 2;

                                if (after[nr][nc].num == 0) {
                                    after[nr][nc] = null;
                                    continue;
                                }
                                int ndir = after[nr][nc].dir;

                                if (ndir % 2 == 0)
                                    ndir--;
                                else
                                    ndir++;

                                after[nr][nc].dir = ndir;
                            }
                        }
                    }
                }
                before = after;
            }
            int total = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (before[i][j] != null) {
                        total += before[i][j].num;
                    }
                }
            }
            System.out.println("#" + tc + " " + total);

        }

    }

    public static void merger(Bio b) {
        b.sum.sort(null);
        Bio first = b.sum.get(0);

        if (first.num > b.num)
            b.dir = first.dir;

        for(int i=0;i<b.sum.size();i++) {
            b.num += b.sum.get(i).num;
        }

        b.sum = new ArrayList<>();

    }
}
