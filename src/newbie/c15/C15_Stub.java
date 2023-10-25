package newbie.c15;

/**
 * 0,1不等概率返回 =》 0,1等概率返回
 */
public class C15_Stub {
    public static void main(String[] args) {
        testF();
        System.out.println("================");
        testRes();
    }

    //TODO
    private static int res() {
        return 0;
    }

    private static int f() {
        return Math.random() < 0.85 ? 0 : 1;
    }


    private static void testF() {
        int count = 10000000;
        int res0 = 0;
        int res1 = 0;
        for (int i=0;i<count;i++) {
            if (f() == 0) {
                res0 ++;
            } else {
                res1 ++;
            }
        }
        System.out.println("res0:" + res0);
        System.out.println("res1:" + res1);
    }

    private static void testRes() {
        int count = 10000000;
        int res0 = 0;
        int res1 = 0;
        for (int i=0;i<count;i++) {
            if (res() == 0) {
                res0 ++;
            } else {
                res1 ++;
            }
        }
        System.out.println("res0:" + res0);
        System.out.println("res1:" + res1);
    }


}
