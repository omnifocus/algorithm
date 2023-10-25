package newbie.c30;

/*
二进制乘法
 */
public class C30_Stub {
    public static void main(String[] args) {
        System.out.println(doMultiple(10,54));
    }

    private static int doMultiple(int i, int j) {
        return 0;
    }
    private static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }
}
