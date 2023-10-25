package newbie.c3;

/**
 * 计算1! + 2! + 3! + ... + N!
 */
public class C3_11 {

    public static void main(String[] args) {
        int N = 10;
        long r1 = method1(N);
        //4037913
        System.out.println("r1:" + r1);
    }

    private static long method1(int n) {
        long r = 0;
        long fib = 1;
        for (int i=1;i<=n;i++) {
            fib *= i;
            r += fib;
        }
        return r;
    }


}
