package lee.leetcode102;

import java.util.LinkedList;
import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        new DecodeString().decodeString("3[a]2[b4[F]c]");
    }
    public String decodeString(String s) {
        Stack<Integer> integer  = new Stack();
        LinkedList<String> subStr   = new LinkedList();
        StringBuilder str = new StringBuilder();
        int mark = 0;
        String nums = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c > 47 && c < 58 ) {
                nums += c;
                if (str.length() != 0) {
                    subStr.add(str.toString());
                    str.setLength(0);
                }
                continue;
            }
            if (c == '['){
                integer.push(Integer.valueOf(nums));
                nums = "";
                mark++;
                continue;
            }
            if (c == ']'){

                mark--;
                int count = integer.pop();
                String temp;
                if (str.length() == 0) {
                    temp = subStr.removeLast();
                }else {
                    temp = str.toString();
                }
                str.setLength(0);
                while(count > 0) {
                    str.append(temp);
                    count--;
                }
                if (mark != 0 ) {
                    subStr.add(subStr.removeLast()+str.toString());
                }else {
                    subStr.add(str.toString());
                }
                str.setLength(0);
                continue;
            }
            str.append(c);
            if (i == s.length()-1 ) {
                if (subStr.isEmpty()) {
                    subStr.add(str.toString());
                }else {
                    subStr.add(subStr.removeLast()+str.toString());
                }

            }
        }
        str.setLength(0);
        while(!subStr.isEmpty()) {
            str.append(subStr.poll()).toString();
        }

        System.out.println(str.toString());
        return str.toString();
    }



}


