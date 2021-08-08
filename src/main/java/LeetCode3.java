package main.java;

import main.java.common.ListNode;
import main.java.util.ListNodeUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sakura
 * @date: 2021/3/10 22:20
 * @description:
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> charSet = new HashSet<>();
        int resLength = 0;
        int l = 0;
        int r = -1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!charSet.contains(chars[i])) {
                ++r;
                charSet.add(chars[i]);
                resLength = Math.max(resLength, r - l + 1);
            } else {
                for (int j = l; j < i; j++) {
                    ++l;
                    if (chars[j] == chars[i]) {
                        ++r;
                        break;
                    } else {
                        charSet.remove(chars[j]);
                    }
                }
                resLength = Math.max(resLength, r - l + 1);
            }
        }
        return resLength;
    }

    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        int abcabcbb = leetCode3.lengthOfLongestSubstring("pwwkew");
        System.out.println(abcabcbb);
    }
}
