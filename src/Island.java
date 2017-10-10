import java.util.*;

/**
 * Created by NamjinCho on 2017-10-10.
 */
public class Island {

    static int gid = 0;

    static int N, M;
    static char[][] map;
    static boolean visit[][];
    static int depth[];
    static HashMap<Integer, Integer> ans;

    static class Element implements Comparable<Element> {
        int idx;
        int maxRow;
        int minRow;
        int maxCol;
        int minCol;
        int start[] = new int[2];
        int size;
        ArrayList<Element> child;

        @Override
        public int compareTo(Element o) {
            return (size - o.size);
        }
    }

    static ArrayList<Element> islands;
    static int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        sc.nextLine();
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        islands = new ArrayList<>();

        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != '.' && !visit[i][j]) {
                    islands.add(divideIsland(i, j));
                    gid++;
                }
            }
        }
        if (gid == 0) {
            System.out.println(-1);
            return;
        }
        islands.sort(null);
        for (int i = 0; i < gid; i++) {
            Element s = islands.get(i);
            for (int j = i + 1; j < gid; j++) {
                Element e = islands.get(j);

                if (!canEscape(s, e)) {
                    e.child.add(s);
                    break;
                }

            }
        }
        depth = new int[gid];
        Arrays.fill(depth, -1);
        ans = new HashMap<>();
        for (int i = 0; i < gid; i++) {

            if (depth[islands.get(i).idx] == -1)
                getDepth(islands.get(i));
        }
        for (int i = 0; ans.containsKey(i); i++)
            System.out.print(ans.get(i) + " ");

    }

    public static int getDepth(Element s) {
        if (s.child.size() == 0) {
            depth[s.idx] = 0;
            if (ans.containsKey(0))
                ans.put(0, ans.get(0) + 1);
            else
                ans.put(0, 1);

            return 0;
        } else {
            int max = -1;
            for (int i = 0; i < s.child.size(); i++) {
                if (depth[s.child.get(i).idx] == -1) {
                    max = Math.max(getDepth(s.child.get(i)), max);
                } else {
                    max = Math.max(depth[s.child.get(i).idx], max);
                }
            }
            max = max + 1;
            depth[s.idx] = max;
            if (ans.containsKey(max))
                ans.put(max, ans.get(max) + 1);
            else
                ans.put(max, 1);
            return depth[s.idx];
        }
    }

    public static boolean canCheck(Element b, Element s) {
        if (b.maxRow >= s.maxRow && b.maxCol >= s.maxCol) {
            if (b.minRow <= s.minCol && b.minCol <= s.minCol)
                return true;
        }
        return false;
    }

    public static boolean canEscape(Element e, Element wall) {
        int idx = e.idx;

        boolean visit2[][] = new boolean[N][M];
        visit2[e.start[0]][e.start[1]] = true;

        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        rq.offer(e.start[0]);
        cq.offer(e.start[1]);


        while (!rq.isEmpty()) {
            int r = rq.poll();
            int c = cq.poll();
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (!visit2[nr][nc]) {
                        if (map[nr][nc] == ('0' + idx) || map[nr][nc] == '.') {
                            visit2[nr][nc] = true;
                            rq.offer(nr);
                            cq.offer(nc);

                            if (nr <= wall.minRow || nr >= wall.maxRow || nc <= wall.minCol || nc >= wall.maxCol)
                                return true;
                            if (nr == 0 || nr == N - 1 || nc == 0 || nc == M - 1)
                                return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    public static Element divideIsland(int row, int col) {
        int maxRow = row;
        int minRow = row;
        int maxCol = col;
        int minCol = col;
        visit[row][col] = true;

        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();

        rq.offer(row);
        cq.offer(col);
        map[row][col] = (char) ('0' + (char) gid);
        while (!rq.isEmpty()) {
            int r = rq.poll();
            int c = cq.poll();
            for (int i = 0; i < 8; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (!visit[nr][nc] && map[nr][nc] != '.') {
                        visit[nr][nc] = true;
                        map[nr][nc] = (char) (gid + '0');

                        maxRow = Math.max(nr, maxRow);
                        maxCol = Math.max(nc, maxCol);
                        minRow = Math.min(nr, minRow);
                        minCol = Math.min(nc, minCol);
                        rq.offer(nr);
                        cq.offer(nc);
                    }
                }
            }
        }
        Element e = new Element();
        e.child = new ArrayList<>();
        e.idx = gid;
        e.maxCol = maxCol;
        e.maxRow = maxRow;
        e.minCol = minCol;
        e.minRow = minRow;
        e.size = (maxRow - minRow + 1) * (maxCol - minCol + 1);
        e.start[0] = row;
        e.start[1] = col;
        return e;

    }

}
