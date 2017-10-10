import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-01.
 */
public class NoBio {

    static class Bio implements Comparable<Bio>{
        int row;
        int col;
        int dir;
        int numOfBio;
        int lastMove = 0;
        ArrayList<Bio> sum = new ArrayList<>();

        @Override
        public int compareTo(Bio o) {
            if(numOfBio < o.numOfBio)
                return 1;
            else if(numOfBio>o.numOfBio)
                return -1;
            return 0;
        }
    }
    public static void merge(Bio f)
    {
        f.sum.sort(null);
        if(f.numOfBio < f.sum.get(0).numOfBio)
        {
            f.dir = f.sum.get(0).dir;
        }
        //System.out.println(f.row + " " + f.col+" "+f.numOfBio+" DE : " + f.dir +" "+ f.sum.get(0).row+" " + f.sum.get(0).col +" " + f.numOfBio);
        int s = f.sum.size();
        for(int i=0;i<s;i++) {
            if(f.sum.get(i).numOfBio==0)
                continue;
            f.numOfBio += f.sum.get(i).numOfBio;
            f.sum.get(i).numOfBio=0;
        }
        f.sum = new ArrayList<>();

    }
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int T =sc.nextInt();
        for(int tc =1;tc<=T;tc++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            Queue <Bio>bios = new LinkedList<>();
            Bio arr[][] = new Bio[N][N];
            //row col num dir

            int dir[][] = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
            ArrayList<Bio> ars [][] = new ArrayList[N][N];
            for(int i=0;i<K;i++) {
                Bio bio = new Bio();
                bio.row =sc.nextInt();
                bio.col = sc.nextInt();
                bio.numOfBio = sc.nextInt();
                bio.dir = sc.nextInt();
                bios.offer(bio);
                arr[bio.row][bio.col] = bio;
            }
            //
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                    ars[i][j] = new ArrayList<>();
            }
            //
            int ans = 0;
            while (ans < M) {
                ans++;
                int size = bios.size();
                for (int j = 0; j < size; j++) {
                    Bio b = bios.poll();
                    //1.나보다 먼저 움직인애들 합하기
                    Bio f=null;

                    if (ars[b.row][b.col].size() != 0) {
                        f = ars[b.row][b.col].get(0);
                        ars[b.row][b.col].remove(0);
                            while (ars[b.row][b.col].size() != 0) {
                                f.sum.add(ars[b.row][b.col].get(0));
                                ars[b.row][b.col].remove(0);
                        }
                        if(f.sum.size()!=0)
                            merge(f);
                    }
                    if (b.numOfBio == 0)
                        continue;

                    //2.내가 합체해서 방향 새로 구하기
                    if (b.sum.size() != 0)
                        merge(b);
                    //
                    int nr = b.row + dir[b.dir][0];
                    int nc = b.col + dir[b.dir][1];
                    arr[b.row][b.col] = f;
                    b.lastMove = ans;
                    b.row = nr;
                    b.col = nc;

                    if (arr[nr][nc] != null) {
                        if (arr[nr][nc].lastMove == ans) {
                            arr[nr][nc].sum.add(b);
                        } else {
                            ars[nr][nc].add(b);
                        }
                    } else {
                        arr[nr][nc] = b;
                    }
                    if(nr==0 || nc==0 || nr == N-1 || nc ==N-1)
                    {
                        int d = b.dir;

                        if(d%2==0)
                            d--;
                        else
                            d++;
                        b.dir = d;
                        b.numOfBio = b.numOfBio/2;
                    }
                    bios.offer(b);
                   // System.out.print((j+1)+ "_ ");b.print();
                }
                //
                // System.out.println("----------------------------------");
            }
            int total = 0;
            while (!bios.isEmpty())
            {
                Bio b = bios.poll();
                total+=b.numOfBio;
            }
            System.out.println("#"+tc+" "+total);
        }
    }
}
