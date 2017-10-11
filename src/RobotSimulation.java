import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-11.
 */
public class RobotSimulation {

    static class Robot{
        int row;
        int col;
        int dir;
    }
    static int R,C;
    static Robot[] robots;
    static int arr[][];
    static int dir[][] ={{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int T = Integer.parseInt(line);
        for (int tc = 0; tc < T; tc++) {
            line = sc.nextLine();
            String sub[] = line.split(" ");
            String NESW = "NESW";
            C = Integer.parseInt(sub[0]);
            R = Integer.parseInt(sub[1]);
            arr = new int[R + 1][C + 1];
            line = sc.nextLine();
            sub = line.split(" ");
            int N = Integer.parseInt(sub[0]);
            int M = Integer.parseInt(sub[1]);
            robots = new Robot[N + 1];
            for (int i = 1; i <= N; i++) {
                robots[i] = new Robot();
                line = sc.nextLine();
                sub = line.split(" ");
                robots[i].col = Integer.parseInt(sub[0]);
                robots[i].row = Integer.parseInt(sub[1]);
                robots[i].dir = NESW.indexOf(sub[2]);
                arr[robots[i].row][robots[i].col] = i;
            }

            boolean f= true;
            for (int i = 0; i < M; i++) {
                line = sc.nextLine();
                sub = line.split(" ");
                int idx = Integer.parseInt(sub[0]);
                String motion = sub[1];
                int count = Integer.parseInt(sub[2]);

                for (int j = 0; j < count && f; j++) {

                    if (motion.equals("F")) {
                        int nr = robots[idx].row + dir[robots[idx].dir][0];
                        int nc = robots[idx].col + dir[robots[idx].dir][1];
                        if (nr < 1 || nr > R || nc < 1 || nc > C) {
                            System.out.println("Robot " + idx + " crashes into the wall");
                            f=false;
                            break;
                        } else {
                            if (arr[nr][nc] != 0) {
                                System.out.println("Robot " + idx + " crashes into robot " + arr[nr][nc]);
                                f=false;
                                break;
                            } else {
                                arr[nr][nc] = idx;
                                arr[robots[idx].row][robots[idx].col] = 0;
                                robots[idx].row = nr;
                                robots[idx].col = nc;
                            }
                        }

                    } else if (motion.equals("L")) {
                        robots[idx].dir--;
                        if (robots[idx].dir == -1)
                            robots[idx].dir = 3;
                    } else //R
                    {
                        robots[idx].dir++;
                        robots[idx].dir = robots[idx].dir % 4;
                    }

                }
            }
            if(f)
                System.out.println("OK");
        }
    }

}
