package newbie.c10;

/**
 * (int)(Math.random()*K) 应该返回在[0,K-1]上等概率返回一个整数
 */
public class C10_6 {

    public static void main(String[] args) {
        int count = 100000;
        int math_count = 0;
        for(int i=0;i<count;i++) {
            if ((int)(Math.random() * 3) == 0) {
                math_count ++;
            }
        }
        System.out.println((double) math_count / count);
    }
}
