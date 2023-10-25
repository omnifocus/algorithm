package newbie.c30;

/*
二进制乘法
 */
public class C30_2 {
    public static void main(String[] args) {

//        System.out.println(doMultiple(10,-54));
        System.out.println( (2147483646 >>> 32));
        int num = 2147483646;
        for (int j=33;j>0;j--) {

            for (int i = 31; i >= 0; i--) {
                if (((num >> i) & 1) != 0) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
            num = num >>> 1;
        }
    }

    private static int doMultiple(int i, int j) {
        int res = 0;
        while (j != 0) {
            if ((j & 1) != 0)
                   res = add(res,i);
            j >>>= 1;
            i <<= 1;
        }

        return res;

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
