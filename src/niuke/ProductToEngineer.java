package niuke;

import java.util.Scanner;

/**
 * 字节跳动笔试题 将产品经理变为程序员。。。。啥脑洞
 */
public class ProductToEngineer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String[] strs = scan.nextLine().split(" ");
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(strs[i]);
        }
        calcE(h);
    }

    public static int calcE(int[] h){
        int e = 0;
        int temp = e, i = 0;
        loop:
        for (; i < h.length; i++) {
            if (h[i] > e){
                e = e - (h[i]-e);
            }else{
                e = e + (e-h[i]);
            }

            if(e < 0){
                temp++;
                e = temp;
//                e = 0 - e;

                i = 0;
                continue loop;
            }

        }
        System.out.println(temp);
        return temp;
    }
}
