package leetcode;

import java.util.ArrayList;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 */
public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] memory = new boolean[2][pLen+1];
        memory[0][0] = true;
        int cur = 0, pre = 0;
        for(int i = 0; i <= sLen; i++) {
            cur = i % 2;
            pre = (i + 1) % 2;
            if(i > 1) {
                for(int j = 0; j <= pLen; j++) {
                    memory[cur][j] = false;
                }
            }
            for(int j = 1; j <= pLen; j++) {
                if(p.charAt(j-1) == '*') {
                    memory[cur][j] = memory[cur][j-2] || (i > 0 && (s.charAt(i-1) == p.charAt(j-2) ||
                            p.charAt(j-2) == '.') && memory[pre][j]);
                }else {
                    memory[cur][j] = i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                            && memory[pre][j-1];
                }
            }
        }
        return memory[cur][pLen];
    }

    /**
     * solution2: matching from right to left,
     * return false if any character not match the current pattern expression
     */
    public static boolean isMatch2(String s, String p) {
        for (int i = s.length()-1, j = p.length()-1; i > -1 && j > -1;) {

        }
    }
}
