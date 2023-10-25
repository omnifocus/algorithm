package newbie.c29;

public class C29_1 {
    public static void main(String[] args) {
        int a = add (100, 590);
        System.out.println(a);
    }

    private static int add(int a, int b) {
        int v1 = a ^ b;
        int v2 = a & b;
        int v3 = v1;
        while (v2 != 0) {
            v2 <<= 1;
            v3 = v1 ^ v2;
            v2 = v1 & v2;
            v1 = v3;
        }
        return v3;
    }
}
