package newbie.c11;

/**
 * 在[0,1)范围上,[0,K)以K^2的等概率返回一个数
 */
public class C11_2 {
    public static void main(String[] args) {
        xToXPower2_method1();
    }



    private static void xToXPower2_method1() {
        int count = 10000_000;
        int sum = 0;
        for (int i=0;i<count;i++) {
            if (Math.random() < 0.4 && Math.random() < 0.4) {
                sum ++;
            }
        }
        System.out.println((double)sum /(double)count);
    }


}
