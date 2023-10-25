package newbie.c16;

/**
 * 对数器
 * 可用来调错,有一个实际的例子（控制最大长度）
 */
public class C16_6 {
    public static void main(String[] args) {

        int runtimes = 1000000;
        int maxLen = 10;
        int maxValue = 100;
        System.out.println("start..");

        for (int i=0;i<runtimes;i++) {
            int[] arr = genRanArr(maxLen,maxValue);
            sort(arr);
            if (!checkSorted(arr)) {
                System.out.println("error");
                break;
            }
        }
        System.out.println("end..");
    }

    private static void sort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;

        for (int i=0;i<arr.length;i++) {
            for (int j=i-1; j>=0 && arr[j] > arr[j+1];j--) {
                swap(arr,j,j+1);
            }
        }
    }

    private static boolean checkSorted(int[] arr) {
        if (arr == null || arr.length <= 1)
            return true;

        for (int i=1;i<arr.length;i++) {
            if (arr[i] < arr[i-1]) {
                return false;
            }
        }
        return true;
    }

    private static int[] genRanArr(int maxLen, int maxValue) {
        int L = (int) (Math.random() * maxLen);
        int[] arr = new int[L];

        if (L > 0) {
            for (int i=0;i<L;i++) {
                arr[i] = (int)(Math.random() * maxValue);
            }
        }

        return arr;
    }


    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
