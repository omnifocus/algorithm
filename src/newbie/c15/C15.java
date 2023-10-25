package newbie.c15;

/**
 * 0,1不等概率返回 =》 0,1等概率返回
 */
public class C15 {
    public static void main(String[] args) {

    }

    private static int f() {
        return Math.random() < 0.85 ? 0 : 1;
    }

    /**
     * 舍掉 00  11
     * 那么剩下的 01 和 10 的概率一定相等
     * @return
     */
    private static int res() {
        int ans ;

        do {
            ans = f();
        } while (ans == f());

        return ans;
    }
}
