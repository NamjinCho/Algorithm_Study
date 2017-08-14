import java.io.*;
import java.util.Scanner;

public class Sort3 {


    static int N;

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int arr[];
        int max = -1;
        try {
            N = Integer.parseInt(sc.readLine());
            arr = new int[10001];
            for (int i = 0; i < N; i++) {
                arr[Integer.parseInt(sc.readLine())]++;
            }
            sc.close();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < 10001; i++) {
                for (int j = 0; j < arr[i]; j++) {
                    bw.write(i + "\n");
                }
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
