package niuke;

import com.sun.tools.javac.util.List;

/**
 * 数字解析函数
 */
public class ParseInt {
    public static void main(String[] args) {
        try {
            List<String> list = List.of("11");
            System.out.println(parseInt("-211"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int parseInt(String s) throws Exception{
        int length = s.length();
        int val = 0;
        for (int i = length-1, j = 0; i > -1; i--,j++) {
            char c = s.charAt(i);
            int minu = c - '0';
            if (minu < 10 && minu > -1){
                val += bitVal(j,minu);
            }else if (c == '-' && i == 0){
                val -= (val<<1);
            }else {
                throw new Exception("invalid parameter!!");
            }
        }
        return val;
    }

    public static long bitVal(int i,int num){
        if (i == 0) {
            return num;
        }
        int val = 10;
        for (; i > 1; i--) {
            val *= val;
        }
        return val*num;
    }
}
