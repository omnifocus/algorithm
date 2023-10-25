package newbie.c28;

/**
 * 实现位图  stupid & simple
 */
public class C28_3 {

    private static class BitMap {
        private int L = 32;
        // 0-1023
        private int[] container = new int[L];

        public void add(int n) {
            int out = n / L ;
            int in = n % L;
            int tomove = out * L + in;
            L |= (1 << tomove);
        }

        public void remove(int n) {
            int out = n / L ;
            int in = n % L;
            int tomove = out * L + in;
            L &= ~((1 << tomove));
        }

        public boolean contains(int n) {
            int out = n / L ;
            int in = n % L;
            int tomove = out * L + in;
            return (L & (1 << tomove)) == 0 ? false : true;
        }
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap();
        bitMap.add(1);
        System.out.println(bitMap.contains(1));
        bitMap.remove(1);
        System.out.println(bitMap.contains(1));
    }

}
