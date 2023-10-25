package newbie.c4;

import java.util.Arrays;

/**
 * 选择排序
 */
public class C4_1 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,5,7,3,2,6,9};
        System.out.println("before:" + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("after:" + Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
       if (arr == null)
           return;
       for (int i=0;i<arr.length-1;i++) {
           for (int j=i+1;j<arr.length;j++) {
               if (arr[i] > arr[j]) {
                   swap(arr,i,j);
               }
           }
       }
    }

    private static void swap(int[] arr, int k, int i) {
        int tmp = arr[k];
        arr[k] = arr[i];
        arr[i] = tmp;
    }
}
