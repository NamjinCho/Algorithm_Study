import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-07.
 */
public class Trade {

    static char arr[];
    static int ans;
    static int wc;
    static int leng;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String line[] = sc.nextLine().split(" ");

            line[0] = line[0].trim();
            line[1] = line[1].trim();
            wc = Integer.parseInt(line[1]);
            arr = new char[line[0].length()];
            for (int i = 0; i < line[0].length(); i++) {
                arr[i] = line[0].charAt(i);
            }
            leng = arr.length;

            int count = 0;
            int insertIdx = 0;

            ans=0;
            if(leng==1 && wc>0)
                ans=-1;
            else if(leng==2)
            {
                if(arr[1]==0 && wc>1)
                    ans=-1;
            }
            if(ans==0) {
                dfs(0, 0);
            }

            System.out.println(ans);

    }

    public static ArrayList<Integer> findMaxIdx(int start) {
        int maxIdx = start;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[maxIdx] < arr[i]) {
                maxIdx = i;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=start;i<arr.length;i++)
            if(arr[i] == arr[maxIdx])
                result.add(i);
        return result;
    }

    public static void dfs(int start,int count)
    {
        if(count<wc && start < arr.length){
            ArrayList<Integer> maxs = findMaxIdx(start);

            for(int i=0;i<maxs.size();i++)
            {
                if(maxs.get(i)==start)
                {
                    dfs(start+1,count);
                    continue;
                }
                swap(start,maxs.get(i));
                dfs(start+1,count+1);
                swap(start,maxs.get(i));
            }
        }

        //System.out.println(getString() +" "+ count +" "+start);
        if (count < wc) {
            if ((wc - count) % 2 == 1) {
                swap(arr.length - 1, arr.length - 2);
                String r = getString();
                ans = Math.max(ans,Integer.parseInt(r));
                swap(arr.length-1,arr.length-2);
            }else
            {
                String r = getString();
                ans = Math.max(ans,Integer.parseInt(r));
            }
        }else
        {
            String r = getString();
            ans = Math.max(ans,Integer.parseInt(r));
        }
    }
    public static void swap(int s, int e) {
        char tmp = arr[s];
        arr[s] = arr[e];
        arr[e] = tmp;
    }
    public static String getString()
    {
        String r="";
        for(int i=0;i<arr.length;i++)
            r=r+arr[i];
        return r;
    }
}
