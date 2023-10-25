package newbie.c9;

/*
扩展到Math.random() * 8 应该在[0,8)上等概率返回
0.xx
1.xx
2.xx
3.xx
4.xx
5.xx
6.xx
7.xx
小于4的这段区间应该占50%
 */
public class C9 {
    public static void main(String[] args) {
        int count = 100000;
        int math_count = 0;
        for (int i=0;i<count;i++) {
            if (Math.random() * 8 < 4) {
                math_count ++;
            }
        }
        System.out.println((double) math_count/ count);
    }
}
