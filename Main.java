import java.util.Scanner;

/**
 * 输出一个整数,表示所有碎片的平均长度,四舍五入保留两位小数。

 如样例所示: s = "aaabbaaac"
 所有碎片的平均长度 = (3 + 2 + 3 + 1) / 4 = 2.25
 */

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        float action=1f;

        int len = input.length();

        for (int i = 0;i<len-1;i++)
        {

            if( input.charAt(i) != input.charAt(i+1) )
            {
                ++action;
            }
        }
        System.out.printf("%.2f\n",len/action);

    }
}
