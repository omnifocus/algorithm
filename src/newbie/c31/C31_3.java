package newbie.c31;

/**
 * 二进制除法
 * -2147483648
 * -3
 */
public class C31_3 {
    public static void main(String[] args) {
        int i = 100, j = -5;
//        System.out.println(new C31_3().divide(-2147483648,-3));
        System.out.println(String.format("%1$sABC%2$s","a","c"));
    }

    public  int divide(int i, int j) {
        if (j == Integer.MIN_VALUE && i == Integer.MIN_VALUE) {
            return 1;
        }
        if (j == Integer.MIN_VALUE) {
            return 0;
        }
        if (i == Integer.MIN_VALUE) {
            if (j == -1) {
                //返回整形最大值
                return Integer.MAX_VALUE;
            } else {
                i = i+1;
                int res = div(i,j);
                int mul = doMultiple(res,j);
                int sub = subtract(Integer.MIN_VALUE, mul);
               return add(res,div(sub,j));

            }
        }
        return div(i,j);
    }

    public  int div(int i, int j) {
        int res = 0;
        boolean flag = (i ^ j) < 0 ? false : true;
        i = i < 0 ? neg(i) : i;
        j = j < 0 ? neg(j) : j;
        for (int k=31;k>=0;k--) {
            if ((i >>k) >= j) {
                // 减的是 j << k
                i = subtract(i,j<<k );
                res |= (1<<k);
            }
        }
        return flag ?  res : neg(res);
    }

    public  int neg(int i) {
        return ~i + 1;
    }

    public  int subtract (int a, int b) {
        return add(a, neg(b));
    }
    public  int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }
    public  int doMultiple(int i, int j) {
        int res = 0;
        while (j != 0) {
            if ((j & 1) != 0)
                res = add(res,i);
            j >>>= 1;
            i <<= 1;
        }

        return res;

    }
}
