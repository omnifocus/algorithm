package newbie.c30;

/*
二进制乘法
 */
public class C30_3 {
    public static void main(String[] args) {

        System.out.println(doMultiple(-10,-54));
//        System.out.println((-1) >> 1);
//        System.out.println((-1) >>> 1);
    }

    private static int doMultiple(int i, int j) {
      int sum = 0;

      while (j != 0) {
          if ((j & 1) ==1) {
              sum = add(sum,i);
          }
          //如果带符号的话，就没头了， -1 >> 1 还是-1
          j >>>= 1;
          i <<= 1;
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
