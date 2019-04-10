package niuke;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 吉比特2019春招 给出一串非负数，抽去其中一些位数的值，如果剩下的数刚好为2018，则称为2018数 求2018数的数量
 */
public class CountNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] x = scan.nextLine().toCharArray();
        HashSet<Character> set = new HashSet<>();
        set.add('2');
        set.add('0');
        set.add('1');
        set.add('8');
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < x.length; i++) {

        }
    }
}
