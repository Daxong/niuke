package lee.leetcode102;

import java.util.HashMap;
import java.util.Map;

/**
 * 字节跳动笔试题：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 双指针解法
 */
class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        int max=0;
        int index=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                index=Math.max(map.get(s.charAt(i))+1,index);
                if((i-index+1)>max){
                    max=i-index+1;
                }
            }else{
                if((i-index+1)>max){
                    max=i-index+1;
                }
            }
            map.put(s.charAt(i), i);
        }
        return max;
    }
}
