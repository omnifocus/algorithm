package newbie.c1;

public class C1 {

    public static void main(String[] args) {
        //打印一个整数的32位表示
        int n = 1628;
        printBinary(n);
    }

    /**
     * 如果与运算完是0，那么该位必是0；与运算完不是0，则必然是1
     * @param n
     */

    private static void printBinary(int n) {
        for (int i = 31;i>=0;i--) {
            System.out.print((n & 1 << i)  == 0 ? "0" : "1");
        }
        System.out.println();
    }


}
