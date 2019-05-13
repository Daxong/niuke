package leetcode;

/**
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900
 */
public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(2999));
    }

    public static String intToRoman(int num){
        int values[] = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String reps[] = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String res = "";
        for(int i=0; i<13; i++){
            while(num>=values[i]){
                num -= values[i];
                res += reps[i];
                if (num == 0) {
                    return res;
                }
            }
        }
        return res;
    }
}
