import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by NamjinCho on 2017-09-29.
 */
public class PokemonMaster {

    public static void main(String[] args) {
        try {
            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String line = br.readLine();
            String sub[] = line.split(" ");
            int N = Integer.parseInt(sub[0]);
            int M = Integer.parseInt(sub[1]);
            HashMap<String, Integer> mapS = new HashMap<>();
            HashMap<Integer, String> mapI = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                line = br.readLine();

                mapS.put(line, i);
                mapI.put(i, line);
            }
            for (int i = 0; i < M; i++) {
                line = br.readLine();

                if (line.charAt(0) >= '1' && line.charAt(0) <= '9') {
                    bw.write(mapI.get(Integer.parseInt(line))+"\n");
                } else
                    bw.write(mapS.get(line)+"\n");

            }
            bw.flush();
            br.close();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
