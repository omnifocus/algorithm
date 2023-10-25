package newbie.c28;

/**
 * 实现位图
 */
public class C28_9 {

    private static class BitMap {

        private long[] arr;

        public BitMap(int n) {
            arr = new long[(n + 64) >> 6];
        }

        public void add(int n) {
            arr[n >> 6] |= (1 << (n & 63));
        }

        public void remove(int n) {
            arr[n >>6] &= ~(1 << (n & 63));
        }

        public boolean contains(int n) {
         return (arr[n >> 6] & (1 << (n & 63)) )== 0 ? false: true;
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
