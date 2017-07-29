import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-26.
 */
public class Resist {

    public static void main(String [] args)
    {
        HashMap<String,Integer> map = new HashMap<>();
        //init
        map.put("black",0);
        map.put("brown",1);
        map.put("red",2);
        map.put("orange",3);
        map.put("yellow",4);
        map.put("green",5);
        map.put("blue",6);
        map.put("violet",7);
        map.put("grey",8);
        map.put("white",9);
        Scanner sc = new Scanner(System.in);
        String t="";

        for(int i=0;i<2;i++)
            t=t+map.get(sc.nextLine());
        int i = map.get(sc.nextLine());
        int s = Integer.parseInt(t);
        s= (int) (s*Math.pow(10,i));
        System.out.println(s);
    }

}
