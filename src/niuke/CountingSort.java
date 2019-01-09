package niuke;

import java.util.*;

public class CountingSort {
    public int[] countingSort(int[] A, int n) {
        // write code here
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        if (A[0] > A[1]) {
            A[0] = A[0] ^ A[1];
            A[1] = A[0] ^ A[1];
            A[0] = A[0] ^ A[1];
        }
        int min = A[0], max = A[1];

        for (int i = 0 ; i < n ; i++) {
            if (min > A[i]) {
                min = A[i];
            }else if (max < A[i]) {
                max = A[i];
            }
            ArrayList<Integer> list = map.get(A[i]);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(A[i]);
            map.put(A[i],list);
        }

        int[] ints = new int[n];
        int count = 0;

        for (int i = min ; i < max+1 ; i++) {
            ArrayList list = map.get(i);
            if (list == null ) continue;
            for (int k = list.size()-1 ; k > -1 ; k-- ) {
                System.out.println(list.get(k));
                ints[count] = (Integer) list.get(k);
                count++;
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        countingSort.countingSort(new int[]{54,35,48,36,27,12,44,44,8,14,26,17,28},13);
    }
}
