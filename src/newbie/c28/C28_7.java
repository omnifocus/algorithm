package newbie.c28;

/**
 * 实现位图
 */
public class C28_7 {

    private static class BitMap {
        private long[] arr;

        public BitMap(int len) {
            arr = new long[(len + 64) >> 6];
        }

        public void add(int n) {
            arr[n >> 6] |= (1L << (n & 63));
        }

        public void remove(int n) {
            arr[n >> 6] &= ~(1L << (n & 63));
        }

        public boolean contains(int n) {
            return (arr[n >> 6] & (1L << (n & 63))) == 0 ? false : true;
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
