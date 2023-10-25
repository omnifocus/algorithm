package newbie.c11;

/**
 * 在[0,1)范围上,[0,K)以K^2的等概率返回
 */
public class C11 {
    public static void main(String[] args) {
        xToXPower2_method2();
    }

    private static void xToXPower2_method2() {
        int count = 1000000;
        int math_count = 0;
        for (int i=0; i<count; i++) {
           if (Math.max(Math.random(),Math.random()) < 0.7) {
               math_count ++;
           }
        }
        System.out.println((double)math_count/count);
    }

    private static void xToXPower2_method1() {
        int count = 1000000;
        int math_count = 0;
        for (int i=0; i<count; i++) {
            double t1 = Math.random();
            double t2 = Math.random();
            if (t1  < 0.7 && t2 < 0.7) {
                math_count ++;
            }
        }
        System.out.println((double)math_count/count);
    }


}
