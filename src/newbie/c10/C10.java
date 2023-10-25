package newbie.c10;

/**
 * (int)(Math.random()*K) 应该返回在[0,K-1]上等概率返回一个整数
 */
public class C10 {

    public static void main(String[] args) {
        int count = 100000;
        int math_count = 0;
        for(int i=0;i<count;i++) {
            int t = (int)(Math.random()*8);
            if (t == 7) {
                math_count ++;
            }
        }
        System.out.println((double) math_count / count);
    }
}
