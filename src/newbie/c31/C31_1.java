package newbie.c31;

/**
 * 二进制除法
 */
public class C31_1 {
    public static void main(String[] args) {
        int i = 1000, j = 0;
//        System.out.println(divide(i,j));
        System.out.println(Integer.MIN_VALUE);
    }

    private static int divide(int i, int j) {
        int _i =i ; int _j = j;
        if (i < 0) {
            i = neg(i);
        }
        if (j < 0) {
            j = neg(j);
        }
        int res = 0;
        for (int k=30;k>=0;k--) {
            if ((i >> k) >= j) {
                res = (1 << k) | res;
                i = add(i,neg(j << k));
            }
        }
        if (_i < 0 && _j <0) {
            return res;
        }
        if (_i <0 || _j < 0) return neg(res);
        return res;
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
