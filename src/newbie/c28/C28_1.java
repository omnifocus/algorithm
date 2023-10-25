package newbie.c28;

/**
 * 实现位图
 */
public class C28_1 {

    private static class BitMap {
        private Long[] bs;

        //！ max
        public BitMap(int max) {
            this.bs = new Long[(max + 64) >> 6];
        }

        public void add(int n) {
            int i = n >> 6;
            int j = n & 63;
            bs[n >> 6] |= (1L << (n & 63));
        }

        public void remove(int n) {
            bs[n >> 6] &= ~(1L << (n & 63));
        }

        public boolean contains(int n) {
            return   ((bs[n >> 6]) & (1L << (n & 63))) != 0;
        }
    }

}
