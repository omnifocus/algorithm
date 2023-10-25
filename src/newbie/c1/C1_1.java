package newbie.c1;

public class C1_1 {

    public static void main(String[] args) {
        //打印一个整数的32位表示
        int n = 123;
        printBinary(n);
        System.out.println(n & 63);
    }

    private static void printBinary(int n) {
        for (int i=31;i>=0;i--) {
            System.out.print(((n >> i)  & 1 ) == 0 ? "0" : "1");
        }
        System.out.println();
    }

}
