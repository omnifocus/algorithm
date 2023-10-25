package newbie.c9;

/*
Math.random() * 8 应该在[0,8)上等概率返回

小于4的这段区间应该占50%
 */
public class C9_1 {
    public static void main(String[] args) {
        int count = 100000;
        int res = 0;
        for (int i=0;i<count;i++) {
            if (Math.random() * 8 < 4) {
                res ++;
            }
        }
        System.out.println((double)res / (double)count);
    }
}
