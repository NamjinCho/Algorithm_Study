public class Dynamic{
    public static void main(String[] args){
        B b1 = new B();
        C c1 = new C();
        B b2 = new B();
        C c2 = new C();

        A[] arr = {b1, c1, b2, c2};

        for (A a: arr){
            a.test();
        }
    }
}

class A{
    public void test(){
        System.out.println("a");
    }
}

class B extends A{
    public void test(){
        System.out.println("b");
    }
}

class C extends A{
    public void test(){
        System.out.println("C");
    }
}
