package newbie.c13;

/**
 * 计算1-(1-x)^2， 在[0,1)中，[0,x)范围上返回数的概率
 */
public class C13_2 {
    public static void main(String[] args) {
        int count = 10000000;
        int math_count = 0;
        double t = 0.4;
        for (int i=0;i<count;i++) {
            if ( genProbability()< t) {
                math_count ++;
            }
        }
        System.out.println((double) math_count / count);
        System.out.println((double)1-Math.pow((double)1-t,2));
    }

    private static double genProbability() {
        return Math.min(Math.random(),Math.random());
    }
}
