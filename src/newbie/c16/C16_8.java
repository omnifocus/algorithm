package newbie.c16;

/**
 * 对数器
 * 可用来调错,有一个实际的例子（控制最大长度）
 */
public class C16_8 {
    public static void main(String[] args) {

        int runtimes = 1000000;
        int maxLen = 10;
        int maxValue = 100;
        System.out.println("start..");

        for (int i=0;i<runtimes;i++) {
            int[] arr = genArr(maxLen,maxValue);
            bubbleSort(arr);
            if (!isSorted(arr)) {
                System.out.println("error");
                break;
            }
        }
        System.out.println("end..");
    }

    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        for (int j=arr.length-1;j>=1;j--) {
            for (int i=1;i<=j;i++) {
                if (arr[i-1] > arr[i]) {
                    swap(arr,i-1,i);
                }
            }
        }
    }

    private static boolean isSorted(int[] arr) {
        if (arr == null || arr.length <= 1) return true;
        for (int j=1;j<arr.length;j++) {
            if (arr[j] < arr[j-1]) {
                return false;
            }
        }
        return true;
    }

    private static int[] genArr(int maxLen, int maxValue) {
        int len = (int)(maxLen * Math.random());
        int[] arr = new int[len];
        if (len <= 0) return arr;
        for (int i=0;i<len;i++) {
            arr[i] = (int)(maxValue * Math.random());
        }
        return arr;
    }


    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
