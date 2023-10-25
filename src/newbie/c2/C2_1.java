package newbie.c2;

import algorithm.newbie.c1.C1_5;

/**
 * 取一个数的相反数
 */
public class C2_1 {
    public static void main(String[] args) {
        int a = 1;

        C1_5.printBinary(a);

        int _a = neg(a);

        C1_5.printBinary(_a);

    }

    private static int neg(int a) {
        return ~a + 1;
    }

}
