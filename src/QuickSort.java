/**
 * Created by NamjinCho on 2017-10-20.
 */
public class QuickSort {

    public static void main(String []args)
    {
        int arr[] = {8,5,3,2,1,9,6};

        QuickSort q = new QuickSort();
        q.quick(arr,0,6);

        for(int i=0;i<7;i++)
            System.out.println(arr[i]);
    }

    public void quick(int []arr , int left , int right)
    {
        int pivot = arr[left];
        int low = left+1;
        int high = right;

        while (low<=high)
        {
            while (low <= right && pivot >= arr[low]) low++;
            while (left+1 <= high && pivot <= arr[high])high--;
            if(low<=high)
                swap(arr,low,high);
        }
        swap(arr,high,left);
        if(high > left)
            quick(arr,left,high-1);
        if(low < right)
            quick(arr,low,right);

    }





    public void quickSort(int [] arr , int left , int right)
    {
        //8532196
        //1532689
        int piviot = arr[left];
        int low =left+1;
        int high = right;
        while (low <= high)
        {
            while (low<=right && piviot>=arr[low])
                low++;
            while (left+1 <=high && piviot<=arr[high] )
                high--;
            if(low<=high)
            {
                swap(arr,low,high);
            }
        }
        swap(arr,high,left);
        if(left<high)
        {
            quickSort(arr,left,high-1);
        }
        if(low < right)
        {
            quickSort(arr,low,right);
        }
    }

    public void swap(int []arr , int a, int b)
    {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
