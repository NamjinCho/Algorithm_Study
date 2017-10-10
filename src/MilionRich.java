import org.omg.CORBA.INTERNAL;

import java.io.*;

/**
 * Created by NamjinCho on 2017-10-09.
 */
public class MilionRich {
    public static void main(String []args)
    {
        try {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        int T = Integer.parseInt(line);

        for(int tc=1;tc<=T;tc++)
        {

            int N  = Integer.parseInt(br.readLine());
            line = br.readLine();
            String sub[] = line.split(" ");
            int arr[][] = new int[N][2];
            for(int i=0;i<N;i++)
            {
                arr[i][0] = Integer.parseInt(sub[i]);
            }
            long ans = 0;

            arr[N-1][1] = arr[N-1][0];
            for(int i=N-2;i>=0;i--)
            {
                if(arr[i][0] >= arr[i+1][1])
                {
                    arr[i][1] = arr[i][0];
                }else{
                    ans = ans+ (arr[i+1][1] - arr[i][0]);
                    arr[i][1] = arr[i+1][1];
                }
            }
            bw.write("#"+tc+" "+ans+"\n");

        }
        bw.flush();
        bw.close();
        br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
