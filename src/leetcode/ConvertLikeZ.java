package leetcode;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 */
public class ConvertLikeZ {
    public static String convert(String s, int numRows) {
        int len = s.length();
        //count为统计分组数
        int count = len % numRows == 0 ? len / numRows : (len / numRows) + 1;

        double mid = ((numRows-1)*2+1)/2.0;
        System.out.println(mid);
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int j = 0; j <= mid;) {
                index = j;
                for (int i = 0; i < count; i++) {
                    if (index >= len) break;
                    sb.append(get(s,index));
                    int tail = (int)(2*(mid - j))+index-1;
                    if (index == tail || j == 0) {
                        index += (numRows+1);
                        continue;
                    }
                    if ( tail >= len) break;
                    sb.append(get(s,tail));
                    index += (numRows+1);
                }
                j++;
        }
        System.out.println(sb);
        return sb.toString();
    }

    public static char get(String s, int index) {
        return s.charAt(index);
    }

    public static void main(String[] args) {
        convert("PAYPALISHIRING",3);
//        char c = "LEETCODEISHIRING".charAt(0);
//        System.out.println(c);
    }
}
