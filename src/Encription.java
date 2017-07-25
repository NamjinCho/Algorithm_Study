import java.util.*;

/**
 * Created by NamjinCho on 2017-07-19.
 */
public class Encription {
    static ArrayList<Character> s1;
    static ArrayList<Character> s2;
    static ArrayList<String> answerList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int L = Integer.parseInt(line.split(" ")[0]);
        int C = Integer.parseInt(line.split(" ")[1]);
        line = sc.nextLine();
        String[] sub = line.split(" ");
        s1 = new ArrayList<>();
        s2 = new ArrayList<>();
        for (int i = 0; i < C; i++) {
            char c1 = sub[i].charAt(0);
            if (c1 == 'a' || c1 == 'i' || c1 == 'o' || c1 == 'e' || c1 == 'u') {
                s1.add(c1);
            } else
                s2.add(c1);
        }
        s1.sort(null);
        s2.sort(null);
        answerList =new ArrayList<>();
        //PriorityQueue<Element> que = new PriorityQueue<>();

        backTracking("", 0, 0, 0, 0, L);
        answerList.sort(null);
        for(int i=0;i<answerList.size();i++)
            System.out.println(answerList.get(i));
    }

    static void backTracking(String ans, int idx1, int idx2, int count1, int count2, int C) {
        // System.out.println(str + "/" + count1 + "/" + count2);
        if (count1 + count2 == C && count1>=1 && count2>=2) {

            char c[] = ans.toCharArray();
            Arrays.sort(c);
            String str ="";

            for(int i=0;i<C;i++)
                str+=c[i];
            if(!answerList.contains(str)) {
                answerList.add(str);
            }
            return;
        }

        if (C - count1 > 2 && idx1 < s1.size()) {

            backTracking(ans+s1.get(idx1), idx1 + 1, idx2, count1 + 1, count2, C);
        }

        if(idx2<s2.size()) {

            backTracking(ans+s2.get(idx2) , idx1+1, idx2 + 1, count1, count2 + 1, C);
            backTracking(ans, idx1+1, idx2 + 1, count1, count2, C);
        }

    }
}
