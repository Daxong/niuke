package niuke;

/**
 * @author yfy
 * @version : QuickPower.java,v 0.1 2019年07月21日 23:40
 */
import java.util.*;
public class QuickPower {
    public int getPower(int k, int N) {
        // write code here
        if (N == 0)
            return 1;

        String binN = Integer.toBinaryString(N);
        int len = binN.length();

        long res = 1;
        long cur = k;

        for (int i = len-1; i >= 0;i--) {
            //判断指数二进制值当前位是否为1
            if(binN.charAt(i)=='1'){
                res = res * cur;
            }
            cur = (cur * cur ) % 1000000007;
            res = res % 1000000007;
        }
        return (int)res;
    }
}
