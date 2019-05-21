package leetcode;

import java.util.Scanner;

public class compress {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str =scanner.nextLine();
        System.out.println(compress(str));
    }

    public static String compress(String str){
        char prev = str.charAt(0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(prev);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == prev){
                count++;
            }else {
                if (count!=1) stringBuilder.append(count);
                count = 1;
                stringBuilder.append(cur);
                prev = cur;
            }
        }
        if (count!=1) stringBuilder.append(count);
        return stringBuilder.toString();

    }
}
