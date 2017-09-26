import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-22.
 */
public class Croatia {


    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        String [] cro ={"c=","c-","dz=","d-","lj","nj","s=","z="};
        ArrayList <String> cros = new ArrayList<>();
        for(int i=0;i<cro.length;i++)
            cros.add(cro[i]);

        String line = sc.nextLine();
        String tmp ="";
        int ans = 0;
        for(int i=0;i<line.length();i++)
        {
            if(tmp.equals(""))
            {
                tmp = tmp+line.charAt(i);
            }else
            {
                tmp=tmp+line.charAt(i);
                if(cros.contains(tmp))
                {
                    ans++;
                    tmp="";
                }else {
                    if (tmp.equals("dz"))
                    {
                        continue;
                    }
                    if(tmp.length()==3)
                    {
                        ans++;
                    }
                    tmp=""+line.charAt(i);
                    ans++;
                }
            }
        }
        if(tmp.length()==1)
            ans++;
        System.out.println(ans);

    }
}
