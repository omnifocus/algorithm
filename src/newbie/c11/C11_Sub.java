package newbie.c11;

/**
 * 在[0,1)范围上,[0,K)以K^2的等概率返回一个数
 */
public class C11_Sub {
    public static void main(String[] args) {

        int count = 1000_000;
        int sum = 0;
        double num = 0.7;
        for (int i=0;i<count;i++) {
            if ( xToXPower2_method1() < 0.7 ) {
                sum ++;
            }
        }
        System.out.println((double)sum / (double)count);
        System.out.println(Math.pow(num,2));
    }



    private static double xToXPower2_method1() {
        return 0;
    }


}
