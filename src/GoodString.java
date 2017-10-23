import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-21.
 */
public class GoodString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int tc = 1; tc <= T; tc++) {
            boolean f = true;
            HashSet<String> set;
            String line = sc.nextLine().trim();
            int leng = line.length();
            for (int i = 1; i < leng; i++) {
                set = new HashSet<>();
                for (int s = 0; (s + i) < leng; s++) {
                    int e = s + i;
                    String ele = line.charAt(s) + "" + line.charAt(e);
                    if (set.contains(ele)) {
                        f = false;
                        break;
                    } else {
                        set.add(ele);
                    }
                }
            }

            if (f)
                System.out.println("GOOD");
            else
                System.out.println("BAD");
        }
    }
}
