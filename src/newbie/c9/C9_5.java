package newbie.c9;

/*
Math.random() * 8 应该在[0,8)上等概率返回

小于4的这段区间应该占50%
 */
public class C9_5 {
    public static void main(String[] args) {
        int count = 100000;
        int sum = 0;
        for (int i=0;i<count;i++) {
            if (genNumber() == 7)
                sum ++;
        }
        System.out.println("比例为:" + (double) sum / (double) count);
    }

    private static int genNumber() {
        return (int)(Math.random() * 8);
    }
}
