package newbie.c30;

/*
二进制乘法 emm 思路转变：往左移 -> 往后移
 */
public class C30_1 {
    public static void main(String[] args) {
        System.out.println(doMultiple(-10,504));
    }

    private static int doMultiple(int i, int j) {
        int sum = 0;
        int _j = 0;
        for (int z=0;z<=31;z++) {

            _j = (1 << z) & j;
            if (_j != 0) {
                sum = add(sum,i<<z);
            }
        }
        return sum;
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
