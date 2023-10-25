package newbie.c28;

/**
 * 实现位图
 */
public class C28_11 {

    private static class BitMap {

        private long[] ls;

        public BitMap(int num) {
            ls = new long[(num+64)>>6];
        }

        public void add(int n) {
            ls[n >> 6] |= (1L<<(n & 63));
        }

        public void remove(int n) {
            ls[n >>6] &= ~(1L<<(n&63));
        }

        public boolean contains(int n) {
            return  (ls [n >> 6] | (1L << (n & 63)) ) == 0 ? false: true;
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
