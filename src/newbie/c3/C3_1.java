package newbie.c3;

/**
 * 计算1! + 2! + 3! + ... + N!
 */
public class C3_1 {

    public static void main(String[] args) {
        int N = 10;
        long r1 = method1(N);
        System.out.println("r1:" + r1);
    }

    private static long method1(int n) {
        long res = 0L;
        long tmp = 1L;
        for (int i=1;i<=n;i++) {
            tmp *= i;
            res += tmp;
        }
        return res;
    }


}
