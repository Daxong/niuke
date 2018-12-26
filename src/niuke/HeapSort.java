package niuke;

public class HeapSort {
//    private int[] arr;
//    public HeapSort(int[] arr) {
//        this.arr = arr;
//    }
//
//    public void sort() {
//        int len = arr.length - 1;
//        int beginIndex = (len -1) >> 1; // equals divide 2
//        for (int i = beginIndex; i >= 0 ; i--) {
//            maxHeapify(i, len);
//        }
//        for (int i = len; i > 0; i--) {
//            swap(0, i);
//            maxHeapify(0, i -1);
//        }
//    }
//    private void swap(int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    /**
//     * 调整index处数据，使符合堆特性
//     * @param index
//     * @param len 未排序的堆的长度
//     */
//    private void maxHeapify(int index, int len) {
//        int left = (index << 1) +1 ;
//        int right = left + 1;
//        int cMax = left;
//        if (left > len) return;
//        if (right <= len && arr[right] > arr[left]) cMax = right;
//        if (arr[cMax] > arr[index]) {
//            swap(cMax, index);
//            maxHeapify(cMax, len);
//        }
//    }

    public int[] heapSort(int[] A, int n) {
        // write code here
        n = n-1;
        int beginIndex = (n - 1) >> 1;
        for (int i = beginIndex ; i >= 0 ; i--) {
            maxHeapity(A, i, n);
        }
        for (int i = n ; i > 0; i--) {
            swap(A, 0, i);
            maxHeapity(A, 0, i - 1);
        }
        return A;
    }
    private void swap(int[] A , int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    private void maxHeapity(int[] A, int index, int len) {
        int left = (index << 1) + 1;
        int right = left + 1;
        int cMax = left;
        if (left > len) return;
        if (right <= len && A[right] > A[left]) cMax = right;
        if (A[cMax] > A[index]) {
            swap(A,cMax,index);
            maxHeapity(A,cMax,len);
        }
    }

    public static void main(String[] args) {
        new HeapSort().heapSort(new int[]{8,12,14,17,26,27,28,35,36,44,44,48,54},13);
    }
}
