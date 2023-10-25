package newbie.c31;

/**
 * 二进制除法
 * https://leetcode.com/problems/divide-two-integers
 */
public class C31_6 {
    public static void main(String[] args) {
        int i = 100, j = 5;
        C31_6 c = new C31_6();
        System.out.println(c.multi(i,j));

    }
    // 101


    public int divide(int a, int b) {

        if (a == b) return 1;
        if (b == Integer.MIN_VALUE) return 0;
        if (a == Integer.MIN_VALUE) {
            if (b == -1) {
                return Integer.MAX_VALUE;
            }

            int tmp = add(a,1);
            int tmp2 = div(tmp,b);
            return add(tmp2, div(min(Integer.MIN_VALUE,multi(tmp2,b)),b));
        }
        return div(a,b);
    }

    public int add(int a , int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public int neg(int a) {
        return ~a + 1;
    }

    public int min (int a, int b) {
        return add(a,neg(b));
    }
    public int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res,a);
            }
           a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public int div(int a, int b) {
        boolean flag = (a ^ b) >=0 ? true : false;
        a = a < 0 ? neg(a) : a;
        b = b < 0 ? neg(b):b;

        int res = 0;

        for (int i=31;i>=0;i--) {
            if ((a >> i) >= b) {
                res |= (1<<i);
                a = min(a,b<<i);
            }
        }

        return flag ? res : neg(res);

    }
}
