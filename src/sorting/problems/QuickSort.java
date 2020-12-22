package sorting.problems;

public class QuickSort {
    public void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length-1);
    }
    private void quickSort(int[] arr, int start, int end) {
        //1. safe, start >= end, to avoid all equal element array infinite loop
        if (arr == null || arr.length <= 1 || start >= end) return;

        int pivot = arr[(start+end)/2];

        int left = start, right = end;

        //2. safe, start >= end, to avoid all equal element array infinite loop
        while(left <= right) {
            while(left <= right && arr[left] < pivot) {
                left++;
            }
            while(left <= right && arr[right] > pivot) {
                right--;
            }
            //3. safe, start >= end, to avoid all equal element array infinite loop
            if (left <= right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;

                left++;
                right--;
            }
        }
        quickSort(arr, start, right);
        quickSort(arr, left, end);
    }
}
