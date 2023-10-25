package newbie.c30;

/*
二进制乘法
 */
public class C30_Classic {
    public static void main(String[] args) {
        System.out.println(doMultiple(-10,54));
    }

    private static int doMultiple(int i, int j) {
        int sum = 0;
        while (j != 0) {
            if ((j & 1) != 0) {
                sum = add(sum,i);
            }
            i <<= 1;
            j >>>= 1;
        }
        return sum;
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


    private static int neg(int a) {
        return ~a + 1;
    }
    private static int subtract(int a, int b) {
        return add(a,neg(b));
    }
}
