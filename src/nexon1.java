import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by NamjinCho on 2017-06-28.
 */
public class nexon1 {

    /*
 * Complete the function below.
 */
    class LinkedListNode {
        int val;
        LinkedListNode next;
    };
    static LinkedListNode deleteOdd(LinkedListNode list) {

        LinkedListNode head = list;
        LinkedListNode ptr = list;
        LinkedListNode prevPtr = list;

        while(ptr!=null){

            if(ptr.val%2 == 1)
            {
                if(ptr == head)
                {
                    head = ptr.next;
                    ptr = head; // head delete
                    prevPtr = ptr;
                    continue;
                }else{
                    if(ptr.next==null)
                        prevPtr.next = null;
                    else{
                        prevPtr.next = ptr.next;
                    }
                    ptr=ptr.next;
                    continue;
                }

            }

            prevPtr = ptr;
            ptr = ptr.next;
        }


        return head;
    }
    static String longestEvenWord(String sentence) {

        String [] subString = sentence.split(" ");

        class Pair{
            String str;
            int length;
        }
        ArrayList<Pair> arrayList = new ArrayList<>();

        int length = subString.length;

        for(int i=0;i<length;i++)
        {
            if(subString[i].length()%2 == 0){
                Pair nP = new Pair();
                nP.str = subString[i];
                nP.length = subString[i].length();
                arrayList.add(nP);
            }

        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i=0;i<arrayList.size();i++)
        {
            if(arrayList.get(i).length > max)
            {
                max =arrayList.get(i).length;
                index = i;
            }
        }

        return arrayList.get(index).str;

    }
    /*
 * Complete the function below.
 */

    static int maxTickets(int[] tickets) {

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i=0;i<tickets.length;i++)
        {
            arr.add(tickets[i]);
        }
        arr.sort(null);

        int maxNum = 1;
        int tempNum =1;
        for(int i=0;i<arr.size();i++)
            System.out.print(arr.get(i) + " ");
        for(int i=0;i<arr.size()-1;i++)
        {
            if(arr.get(i+1) - arr.get(i) <2 )
            {
                tempNum++;
            }else{
                System.out.println(arr.get(i));
                maxNum = Integer.max(tempNum,maxNum);
                tempNum =1;
            }
        }
        HashMap<String,Boolean> visit;
        visit = new HashMap<>();



        return maxNum;

    }

    static long prison(int n, int m, int[] h, int[] v) {

        boolean hs[] = new boolean [n+1];
        boolean vs[] = new boolean [m+1];

        for(int i=0;i<h.length;i++)
            hs[h[i]] = true;
        for(int i=0;i<v.length;i++)
            vs[v[i]] = true;

        int maxY = 1;
        int count = 1;

        for(int i=0;i<=n;i++)
        {
            System.out.print(hs[i]+" ");
            if(hs[i]==true)
                count++;
            else
            {
                maxY=Math.max(maxY,count);
                count=1;
            }
        }
        System.out.print("\n");
        int maxX =1;
        count =1;
        for(int i=0;i<=m;i++)
        {
            System.out.print(vs[i]+" ");
            if(vs[i]==true) {
                count++;
            }
            else
            {

                maxX=Math.max(maxX,count);
                count=1;
            }
        }
        System.out.print("\n"+maxX);
        long total = maxX*maxY;
        return total;






    }

    static public void main(String [] args)
    {
        //

        int h[] = {1,2,3};
        int v[]={1,2};
        int n=3;
        int m=2;
        prison(n,m,h,v);




        //int m = maxTickets(t);
       // System.out.print(m);
    }


}
