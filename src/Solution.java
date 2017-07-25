import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//123 312 231 0 1 2 
//  0 1 2 k=2 (m+k)%n - > 0 2 3 -> 2 -> 3 , 1 2 3 ->  1 , 2 2 3 ->  2  
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];

        for(int a_i=0; a_i < n; a_i++){
            int idx = (a_i+k)%n;
            a[idx] = in.nextInt();

        }
        System.out.println("tmp");
        for(int a0 = 0; a0 < q; a0++){
            int m = in.nextInt();

            System.out.println(a[m]);
        }
    }
}
