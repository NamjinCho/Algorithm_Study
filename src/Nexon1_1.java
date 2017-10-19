/**
 * Created by NamjinCho on 2017-10-17.
 */
import java.util.*;
public class Nexon1_1 {
    static class Data implements Comparable<Data>{
        int data;
        int bit;
        Data (int a)
        {
            data = a;
            bit = Integer.bitCount(a);
        }

        @Override
        public int compareTo(Data o) {
            if(bit < o.bit)
                return -1;
            else if(bit > o.bit)
                return 1;
            else{
                if(data < o.data)
                    return -1;
                else if(data > o.data)
                    return 1;
                else
                    return 0;
            }
        }
    }
    static int[] rearrange(int[] elements) {
        ArrayList<Data> list = new ArrayList();
        int size = elements.length;
        for(int i=0;i<size;i++)
        {
            list.add(new Data(elements[i]));
        }
        int result []= new int[size];

        for(int i=0;i<size;i++)
        {
            result[i] = list.get(i).data;
        }

        return result;

    }
    public static void main(String []args)
    {
        int [] datas = {5,3,7,10,14};
        int result[] = rearrange(datas);
        for(int i=0;i<5;i++)
        {
            System.out.println(result[i]);
        }
    }
}
