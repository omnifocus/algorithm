package newbie.c38;


/**
 * 内存的空间局部性
 *
 * L3cache 16MB
 *
 * 一个long是8个Byte，传统的L3cache 64Byte 能读8个long， 对目前的6个long来说 绰绰有余
 * 因此 横着一下就能读完
 *
 * 竖着是 8M  (加载一横排)
 * 本机测试 8M * 3  效果更明显 快4倍的差距
 *
 *
 *  竖着相加的内存交互 明显多
 *
 * */
public class TestCacheline {
    public static void main(String[] args) {
        int w = 1024*1024*3;
        int h = 6;

        long [][] ls = new long[w][h];

        for (int i=0;i<w;i++) {
            for (int j=0;j<h;j++) {
                ls[i][j] = 1;
            }
        }



        System.out.println("init done.");

        long start1 = System.currentTimeMillis();

        long sum1 = 0;
        for (int i=0;i<w;i++) {
            for (int j=0;j<h;j++) {
                sum1 += ls[i][j] ;
            }
        }
        long end1 = System.currentTimeMillis();

        System.out.println("time:" + (end1-start1));


        System.out.println("sum1:" + sum1);
        System.out.println("++++++++++++++++++++++++++");
        long start2 = System.currentTimeMillis();

        long sum2 = 0;
        for (int i=0;i<h;i++) {
            for (int j=0;j<w;j++) {
                sum2 += ls[j][i] ;
            }
        }
        long end2 = System.currentTimeMillis();

        System.out.println("time:" + (end2-start2));
        System.out.println("sum2:" + sum2);
    }
}
