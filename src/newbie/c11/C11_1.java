package newbie.c11;

/**
 * 在[0,K)范围上,[0,K)以1/K的等概率返回
 */
public class C11_1 {
    public static void main(String[] args) {
        xToXPower2_method1();
    }



    private static void xToXPower2_method1() {
       int count = 10000000;
       int res = 0;
       int N1,N2;
       for (int i=0;i<count;i++) {
           N1 = (int)(Math.random() * 8);
           N2 = (int)(Math.random() * 8);
            if (N1 == N2)
           res ++;
       }
        System.out.println((double)res / (double) count);
    }


}
