import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-14.
 */
public class BinaryTreeSearch {
    static class Node{
        char me;
        Node left;
        Node rigth;
    }
    static Node root;
    public static void main(String [] args)
    {
        Scanner sc  = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        root=null;

        for(int i=0;i<N;i++)
        {
            String line = sc.nextLine();
            String [] sub = line.split(" ");
            insert(root,sub[0].charAt(0),sub[1].charAt(0),sub[2].charAt(0));
        }
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }
    public static void inorder(Node parent)
    {
        if(parent.left!=null)
            inorder(parent.left);
        System.out.print(parent.me);
        if(parent.rigth!=null)
            inorder(parent.rigth);
    }
    public static void postorder(Node parent)
    {
        if(parent.left!=null)
            postorder(parent.left);
        if(parent.rigth!=null)
            postorder(parent.rigth);
        System.out.print(parent.me);
    }
    public static void preorder(Node root)
    {
        System.out.print(root.me);
        if(root.left!=null)
            preorder(root.left);
        if(root.rigth!=null)
            preorder(root.rigth);
    }
    public static void attach(Node root, char l, char r)
    {
        if(l!='.')
        {
            root.left = new Node();
            root.left.me = l;
        }
        if(r!='.')
        {
            root.rigth = new Node();
            root.rigth.me = r;
        }
    }
    public static void insert(Node parent,char me , char l , char r)
    {
        if(root==null)
        {
            root=new Node();
            root.me = me;
            attach(root,l,r);
            return;
        }else
        {
            if(parent.me==me)
            {
                attach(parent,l,r);
            }else
            {
                if(parent.left!=null)
                    insert(parent.left,me,l,r);
                if(parent.rigth!=null)
                    insert(parent.rigth,me,l,r);
            }
        }
    }


}
