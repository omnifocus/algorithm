package newbie.c28;

/**
 * 实现位图 : 32错误，应该是31 ； 暂未改动
 */
public class C28_4 {

    private static class BitMap {

        private int L;
        private int[] arr;

        public BitMap(int l) {
            L = l;
            arr = new int[(l + 32) >> 5];
        }

        public void add(int n) {
            arr[n >> 5] |= (1 << (n & 32));
        }

        public void remove(int n) {
           arr[n >> 5] &= ~( 1 << (n & 32));
        }

        public boolean contains(int n) {
         return  (arr[n >> 5] & (1 << (n & 32))) != 0 ? true : false;
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
