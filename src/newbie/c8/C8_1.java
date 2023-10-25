package newbie.c8;

/**
 * Math.random 真的等概率返回
 *  * 在[0,1)范围上
 * */
public class C8_1 {

    public static void main(String[] args) {
        int try_count = 1000_0000;
        int act_count = 0;
        for (int i=0;i<try_count;i++) {
            if (Math.random() < 0.5) {
                act_count ++;
            }
        }
        System.out.println((double) act_count / (double)try_count);
    }
}
