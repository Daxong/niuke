package niuke;

public class quickSort {

    public static int partition(int[] arr , int L , int R ){
        int p = arr[R];
        int less = L -1 ;
        for (int i = L ; i <= R ; i++) {
            if (arr[i] <= R) {
                swap(arr,less + 1, i );
            }

        }
        return less;
    }
    public static void swap(int[] arr , int less , int big) {
        int temp = arr[less];
        arr[less] = arr[big];
        arr[big] = temp;
    }

    public static void main(String[] args) {
        int[] test = {3,2,4,5,7,6};
//        int index = partition(test,)
    }
}
