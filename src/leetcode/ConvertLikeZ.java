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
        if(numRows == 1) return s;
        int[] rowIdx = new int[numRows];
        char[] chars = new char[s.length()];
        int n = 0;
        int burketSize = numRows * 2 - 2;
        int burketNum = chars.length / burketSize;
        int rem = chars.length % burketSize;
        for(int i = 1; i < numRows; i ++){
            int flag = i == 1 ? 1 : 2;
            n = flag * burketNum + (rem >= i ? ( 1 + (burketSize - rem + 1 < i ? 1 : 0)) : 0);
            rowIdx[i] = rowIdx[i-1] + n;
        }
        int flag = -1;
        int curRow = 0;
        for(char c : s.toCharArray()){
            chars[rowIdx[curRow]] = c;
            rowIdx[curRow] = rowIdx[curRow] + 1;
            if (curRow == 0 || curRow == numRows - 1) flag = -flag;
            curRow += flag;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
//        char c = "LEETCODEISHIRING".charAt(0);
//        System.out.println(c);
    }
}
