package newbie.c12;

/**
 * [0,1) 上，[0,x)范围上的数出现概率 由x调整为x^3
 *
 *
 * roll三次，都小于x，即可
 */
public class C12_Stub {
    public static void main(String[] args) {
//        xToXPower3_method1();
        xToXPower3_method2();
    }

    private static void xToXPower3_method2() {
        int count = 10000000;
        int math_count = 0;
        double t = 0.3;
        for (int i=0;i<count;i++) {

            if (genNumber() < t) {
                math_count ++;
            }
        }

        System.out.println((double)math_count / count);
    }

    private static double genNumber() {
        return 0;
    }


}
