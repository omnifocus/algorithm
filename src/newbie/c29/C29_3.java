package newbie.c29;

public class C29_3 {
    public static void main(String[] args) {
        int a = add (100, 2000);
        System.out.println(a);
    }

    private static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum =  a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
      return sum;
    }
}
