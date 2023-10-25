package newbie.c31;

/**
 * 二进制除法
 */
public class C31_2 {
    public static void main(String[] args) {
        int i = 100, j = 5;
        System.out.println(divide(i,j));
    }

    private static int divide(int i, int j) {
        int result = 0;
        int _i = i;
        int _j = j;
        if (i < 0) {
            i = neg(i);
        }
        if (j < 0) {
            j = neg(j);
        }
        for (int k=30;k>=0;k--) {
            if ((i >> k) >= j) {
                result = (1 << k) | result;
                i = add (i,neg(j << k));
            }
        }
        if (_i < 0 && _j < 0) {
            return result;
        }
        if (_i < 0 || _j < 0) {
            return neg(result);
        }
        return result;

    }
    private static int neg(int i) {
        return ~i + 1;
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
