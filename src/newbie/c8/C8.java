package newbie.c8;

/**
 * Math.random 真的等概率返回
 *  * 在[0,1)范围上
 *  * [0,K)以K的等概率返回
 */
public class C8 {

    public static void main(String[] args) {
        int count = 10000000;
        int math_count = 0;
        for (int i=0;i<count;i++) {
            if (Math.random() < 0.85) {
                math_count ++;
            }
        }

        System.out.println((double)math_count/count);
    }
}
