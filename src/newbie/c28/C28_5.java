package newbie.c28;

/**
 * 实现位图
 */
public class C28_5 {

    private static class BitMap {

        private int[] arr;

        public BitMap(int length) {
            arr = new int[(length + 32)>>5];
        }

        public void add(int n) {
            arr[n >> 5] |= (( 1 << (n & 31)));
        }

        public void remove(int n) {
            arr[n >> 5] &= ~((1 << (n & 31)));
        }

        public boolean contains(int n) {
            return  ((arr[n >> 5] & ( 1 << (n & 31))) == 0 ? false : true);
        }
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(2);
        bitMap.add(1);
        System.out.println(bitMap.contains(1));
        bitMap.remove(1);
        System.out.println(bitMap.contains(1));
    }

}
