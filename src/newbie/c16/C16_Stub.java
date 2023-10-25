package newbie.c16;

/**
 * 对数器
 * 可用来调错,有一个实际的例子（控制最大长度）
 */
public class C16_Stub {
    public static void main(String[] args) {

        int runtimes = 1000000;
        int maxLen = 10;
        int maxValue = 100;
        System.out.println("start..");

        for (int i=0;i<runtimes;i++) {

        }
        System.out.println("end..");
    }


    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
