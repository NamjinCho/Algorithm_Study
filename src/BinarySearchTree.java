import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-24.
 */
public class BinarySearchTree {
    static class Node {
        int idx;
        Node leftChild;
        Node rightChild;
    }

    static int Count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int t = sc.nextInt();
        Node root = new Node();
        root.idx = t;
        Count = 0;
        System.out.println(Count);

        for(int i=1;i<N;i++)
        {
            t = sc.nextInt();
            insert(t,root);
            System.out.println(Count);
        }
    }

    public static void insert(int X, Node N) {

        Count++;
        if (X < N.idx) {
            if (N.leftChild == null) {
                Node n = new Node();
                n.idx = X;
                N.leftChild=n;
            }//만듬
            else {
                insert(X, N.leftChild);
            }
        } else if (X > N.idx) {
            if (N.rightChild == null) {
                Node n = new Node();
                n.idx = X;
                N.rightChild = n;
            }//만들어 삽입
            else
                insert(X, N.rightChild);
        }
    }
}