package newbie.c31;

/**
 * 二进制除法
 * https://leetcode.com/problems/divide-two-integers
 */
public class C31_4 {
    public static void main(String[] args) {
        int i = 100, j = 5;
        System.out.println(new C31_4().mul(i,j));

    }
    // 101

    public  int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        }
        if (b == Integer.MIN_VALUE) {
            return 0;
        }
        if (a == Integer.MIN_VALUE) {
            if (b == neg(1)) {
                return Integer.MAX_VALUE;
            }
            a = add(a,1);
            int divres = div(a,b);
            int mulres = mul(divres,b);
            int remainres = sub(Integer.MIN_VALUE,mulres);
            int remaindiv = div(remainres,b);
            return add(divres,remaindiv);
        }
        return div(a,b);
    }

    public int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }


    public int neg (int a) {
        return ~a + 1;
    }

    public int sub (int a, int b) {
        return add(a, neg(b));
    }

    public int mul(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public int div(int a, int b) {
        boolean flag = (a ^ b) >= 0 ? true : false;
        a = a < 0 ? neg(a) : a;
        b = b < 0 ? neg(b) : b;

        int res = 0;

        for (int i=30;i>=0;i=sub(i,1)) {
            if ((a >>i) >= b) {
                a = sub (a, (b<<i));
                res |= (1 << i);
            }
        }

        return flag ? res : neg(res);
    }
}
