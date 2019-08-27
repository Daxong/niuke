package niuke;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @author yfy
 * @version : xx.java,v 0.1 2019年08月27日 16:41
 */
/**
 *
 六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，
 他才会上去表演节目。老师的目标是将巧克力分发给孩子们，使得最多的小孩上台表演。可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
 输入描述:
 第一行：n，表示h数组元素个数
 第二行：n个h数组元素
 第三行：m，表示w数组元素个数
 第四行：m个w数组元素
 输出描述:
 上台表演学生人数
 */


public class DistributeCandy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String[] expect = scan.nextLine().split(" ");
        int m = scan.nextInt();
        scan.nextLine();
        String[] weight = scan.nextLine().split(" ");
        int[] expectNum = new int[expect.length];
        for(int i = 0; i < expectNum.length; i++) {
            expectNum[i] = Integer.parseInt(expect[i]);
        }
        int[] weightNum = new int[weight.length];
        for(int i = 0; i < weightNum.length; i++){
            weightNum[i] = Integer.parseInt(weight[i]);
        }
        Arrays.sort(expectNum);
        Arrays.sort(weightNum);
        int result=0;
        int i=0,j=0;
        while(i<n && j<m){
            if(weightNum[j]>=expectNum[i]){
                result++;
                i++;
            }
            j++;
        }
        System.out.println(result);
    }
}
