package lee.leetcode102;

public class Huiwen {
    public static void main(String[] args) {
        System.out.println(isHuiwen("looal"));
    }

    public static int isHuiwen(String str) {
        int len = str.length();
        if (len == 0) return 0;
        for (int i = 0,j = len-1; i < len && j > -1; i++,j--){
            if (str.charAt(i) != str.charAt(j)) return 0;
            if (i >= j) break;
        }
        return 1;
    }
}
