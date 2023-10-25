package newbie.c8;

/**
 * Math.random 真的等概率返回
 *  * 在[0,1)范围上
 * */
public class C8_3 {

    public static void main(String[] args) {
        int count = 100000;
        int sum = 0;
        for (int i=0;i<count;i++) {
            if (genNumber() < 0.5) {
                sum ++;
            }
        }
        System.out.println("比例为:" + (double) sum / (double) count);
    }

    private static double genNumber() {
        return Math.random() ;
    }
}
