package newbie.c31;

/**
 * 二进制除法
 * https://leetcode.com/problems/divide-two-integers
 */
public class C31_Stub {
    public static void main(String[] args) {
        int i = 100, j = 5;
        System.out.println(divide(i,j));

    }
    // 101

    private static int divide(int i, int j) {
        int res = 0;
        //因为是正数，第一位是0，所以移30位
        for (int k=30; k>=0;k--) {
            if ((i>>k) >= j) {
                i  -=  (j<<k);
                res  |= (1 << k);
            }
        }
        return res;

    }
    private static int neg(int i) {
        return ~i + 1;
    }
    private static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }
}
