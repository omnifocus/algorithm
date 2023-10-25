package newbie.c3;

/**
 * 计算1! + 2! + 3! + ... + N!
 */
public class C3_13 {

    public static void main(String[] args) {
        int N = 10;
        long r1 = method1(N);
        //4037913
        System.out.println("r1:" + r1);
    }

    private static long method1(int n) {
     long res = 0l;
     long fib = 1l;
     for (int i=1;i<=n;i++) {
         fib *= i;
         res += fib;
     }
     return res;
    }


}
