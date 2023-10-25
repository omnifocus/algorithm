package newbie.c3;

/**
 * 计算1! + 2! + 3! + ... + N!
 */
public class C3 {

    public static void main(String[] args) {
        int N = 10;
        long r1 = method1(N);
        long r2 = method2(N);
        System.out.println("r1:" + r1);
        System.out.println("r2:" + r2);
    }

    private static long method2(int n) {
        long sum = 0;
        long facN = 1;
        for (int i=1;i<=n;i++) {
            //当前数的阶乘
            facN *= i;
            //累加每个阶乘
            sum += facN;
        }
        return sum;
    }

    private static long method1(int n) {
        long sum = 0;
        for (int i=1;i<=n;i++) {
            sum += factorial(i);
        }
        return sum;
    }

    private static long factorial(int n) {
        long total = 1;
        for (int i=n;i>0;i--) {
            total *= i;
        }
        return total;
    }

}
