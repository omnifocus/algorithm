package newbie.c28;

/**
 * 实现位图
 */
public class C28_2 {

    private static class BitMap {
        private Long[] bs;

        public BitMap(int length) {
            this.bs = new Long[(length + 64) >> 6];
        }

        public void add(int n) {
            bs[n >> 6]  |= (1L <<(n & 63));
        }

        public void remove(int n) {
            bs[n >> 6]  &= ~(1L <<(n & 63));

        }

        public boolean contains(int n) {
            return (bs[n>>6]  & (1L << (n & 63))) != 0;
        }
    }

}
