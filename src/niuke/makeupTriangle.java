package niuke;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class makeupTriangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (N > 50 & N < 0 ) {
            return;
        }
        String[] ints ;
        HashSet setArray = new HashSet<Integer>();
        in.nextLine();
        String str = in.nextLine();
//        System.out.println(str);
        ints = str.split(" ");
        for (int i = 0 ; i < ints.length ; i++ ){
            setArray.add(Integer.parseInt(ints[i]));
        }

        int len = setArray.size();
        Iterator iter = setArray.iterator();
        int[] ints1 = new int[len];
        int j =0;
        while(iter.hasNext()) {
            ints1[j] = (int)iter.next();
            j++;
        }
        //通过勾股定理判断
        HashSet set = new HashSet<Integer[]>();
        for (int i = 0 ; i < len ; i++) {
            for (int n = i+1 ; n < len ; n++) {
                int[] edge = new int[]{ints1[i],ints1[n]};
                set.add(edge);
            }
        }
        HashSet bingo = new HashSet<Integer>();
        Iterator<Integer> it = setArray.iterator();
        while (it.hasNext()) {
            int thirdEdge = it.next();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                int[] secEdge = (int[]) iterator.next();
                if (thirdEdge == secEdge[0] || thirdEdge == secEdge[1]) {
                    continue;
                }
                if (secEdge[0]+secEdge[1] > thirdEdge & secEdge[0]+thirdEdge > secEdge[1] & secEdge[1]+thirdEdge > secEdge[0]) {
                    bingo.add(secEdge[0]+secEdge[1]+thirdEdge);
                    System.out.println(secEdge[0]+" "+secEdge[1]+" "+thirdEdge);
                }
            }
        }
//        for (int i = 0 ; i < ints.length ; i++) {
//            System.out.println(ints[i]);
//        }
        System.out.println(bingo.size());
    }
}
/**
 * AC 30%
 * Q:首先输入一个正整数N，接下来的一行共有N个正整数表示每个木棒的长度，N<=50，木棒的长度<=10000
 * out: 输出一个整数表述方法数
 * input：
 * 5
 * 1 2 3 4 5
 * output：
 * 3
 */
