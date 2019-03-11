package JavaProperties;
import java.util.Scanner;
public class countK {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        String[] kstr ;
//        String k = scan.nextLine();
//        kstr = k.split(" ");
//        if (kstr.length != n) return;
//        int[] kint = new int[n];
//        for (int i = 0; i < n; i++) {
//            kint[i] = Integer.parseInt(kstr[i]);
//        }
//        //查询组数
//        int q = scan.nextInt();
//        int[][] group = new int[q][3];
//        //查询条件
//        for (int i = 0; i < q; i++) {
//            String[] qstr = scan.nextLine().split(" ");
//            for (int j = 0; j < 3; j++) {
//                group[i][j] = Integer.parseInt(qstr[i]);;
//            }
//            //find(kint, group[i][0], group[i][1], group[i][2]);
//        }
        int num = Integer.parseInt("-21");
        System.out.println(num);
        find(new int[]{1, 2, 3, 3, 5}, 1, 2, 1);
    }

    public static void find (int[] kint, int left, int right, int k) {
        int count = 0;
        for (int i = left-1; i < right; i++) {
            if (kint[i] == k) {
                count++;
            }
        }
        System.out.println(count);
    }
}
