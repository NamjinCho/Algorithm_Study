/**
 * Created by NamjinCho on 2017-10-17.
 */
import java.util.*;
public class Nexon2_2 {

    /*
     * Complete the function below.
     */
    static HashMap<String,Boolean> map;
    static long substringCalculator(String s) {
        //        String s = "kincenvizh";
        long ans = 0;
        for(int i=0;i<s.length();i++)
        {
            String data = s.substring(i,s.length());
            ans+=data.length();
            for(int j=0;j<data.length();j++)
            {
                int t = s.indexOf(data.substring(0,j+1));
                if(t < i)
                    ans--;
                else
                    break;
            }
        }
        return ans;
    }
    public static void main(String []args)
    {
        String s = "kincenvizh";
        long ans = substringCalculator(s);
        System.out.println(ans);
    }

}
