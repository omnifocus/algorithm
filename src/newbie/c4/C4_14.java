package newbie.c4;

import java.util.Arrays;

/**
 * 选择排序
 */
public class C4_14 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,5,7,3,2,6,9};
        System.out.println("before:" + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("after:" + Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        if (arr == null || arr.length <= 0) return;
        for (int i=0;i<arr.length;i++) {
            int index = i;
            for (int j=i+1;j<arr.length;j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            if (index != i) {
                swap(arr,index,i);
            }
        }
    }

    private static void swap(int[] arr, int k, int i) {
        int tmp = arr[k];
        arr[k] = arr[i];
        arr[i] = tmp;
    }
}
