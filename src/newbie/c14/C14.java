package newbie.c14;

/**
 * 给定函数f(在[1~5])范围上等概率返回，返回[1-7]上等概率返回
 *
 * 1.生成0 1 发生器
 * 2.二进制 每位上放入 1产生的值
 * 3.排除掉不需要的值
 */
public class C14 {
    public static void main(String[] args) {
        int v = zeroToSix() + 1;
        // 测试0-6上等概率返回
        checkRes();
    }


    private static int zeroToSix() {
        int ans;
        do {
           ans = (zeroOne() << 2) + (zeroOne() << 1) + zeroOne();
        } while (ans == 7);
        return ans;
    }

    private static  int zeroOne() {
        int ans;
       do {
           ans = f();
       } while (ans == 3);

       return ans < 3 ? 0 : 1;
    }

    public  static int f() {
        int ans;
        ans = (int)  (Math.random() * 5);
        return ans + 1;
    }

    private static void checkF() {
        int c1 = 0,c2 = 0,c3 = 0,c4 = 0,c5 = 0;
        for (int i=0;i<10000000;i++) {
            switch (f()) {
                case 1:
                    c1 ++;break;
                case 2:
                    c2 ++;break;
                case 3:
                    c3 ++;break;
                case 4:
                    c4 ++;break;
                case 5:
                    c5 ++;break;
            }
        }
        System.out.println("c1:" + c1);
        System.out.println("c2:" + c2);
        System.out.println("c3:" + c3);
        System.out.println("c4:" + c4);
        System.out.println("c5:" + c5);
    }

    private static void checkRes() {
        int c0=0,c1 = 0,c2 = 0,c3 = 0,c4 = 0,c5 = 0,c6=0;
        for (int i=0;i<10000000;i++) {
            switch (zeroToSix()) {
                case 0:
                    c0 ++;break;
                case 1:
                    c1 ++;break;
                case 2:
                    c2 ++;break;
                case 3:
                    c3 ++;break;
                case 4:
                    c4 ++;break;
                case 5:
                    c5 ++;break;
                case 6:
                    c6 ++;break;
            }
        }
        System.out.println("c0:" + c0);
        System.out.println("c1:" + c1);
        System.out.println("c2:" + c2);
        System.out.println("c3:" + c3);
        System.out.println("c4:" + c4);
        System.out.println("c5:" + c5);
        System.out.println("c6:" + c6);
    }
}
