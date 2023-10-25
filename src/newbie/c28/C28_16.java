package newbie.c28;

/**
 * 实现位图
 */
public class C28_16 {

    private static class BitMap {

        long[] bs ;
        public BitMap(int num) {
            bs = new long[(num >> 6)+1];
        }
        public void add(int n) {
            bs[n >>6] |=  1 << (n&63 );
        }

        public void remove(int n) {
            bs[n>>6] &= ~(1 << (n&63));
        }

        public boolean contains(int n) {
            return (bs[n>>6] & (1<<(n&63))) !=0 ? true : false;
        }
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(10);
        bitMap.add(1);
        System.out.println(bitMap.contains(1));
        bitMap.remove(1);
        System.out.println(bitMap.contains(1));
    }

}
