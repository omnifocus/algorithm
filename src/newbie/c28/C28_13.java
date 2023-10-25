package newbie.c28;

/**
 * 实现位图
 */
public class C28_13 {

    private static class BitMap {

        private long[] bits ;

        public BitMap(int n) {
            bits = new long[n];
        }

        public void add(int n) {
            bits[n >> 6] |=  (1 << (n & 63));
        }
        public void remove(int n) {
            bits[n>>6] &= ~(1<<(n & 63));
        }

        public boolean contains(int n) {
            return (bits[n>>6] & (1 << (n & 63))) == 0 ? false: true;
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
