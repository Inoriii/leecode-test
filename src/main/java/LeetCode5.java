package main.java;

/**
 * @author sakura
 * @date: 2021/3/10 22:20
 * @description:
 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        String sMax = chars[0] + "";
        String nowMax;
        String nowMax2;
        for (int i = 0; i < chars.length; i++) {
            nowMax = check1(chars, i);
            if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                nowMax2 = check2(chars, i);
                nowMax = nowMax.length() > nowMax2.length() ? nowMax : nowMax2;
            }
            sMax = nowMax.length() > sMax.length() ? nowMax : sMax;
        }
        return sMax;
    }

    private String check2(char[] chars, int i) {
        if (i == 0) {
            return "" + chars[i] + chars[i];
        }
        int n = 1;
        String nowMax = "" + chars[i] + chars[i];
        while (i - n >= 0 && i + 1 + n <= chars.length - 1) {
            if (chars[i - n] == chars[i + 1 + n]) {
                nowMax = chars[i - n] + nowMax + chars[i + 1 + n];
                ++n;
            } else {
                break;
            }
        }
        return nowMax;
    }

    private String check1(char[] chars, int i) {
        if (i == 0) {
            return chars[i] + "";
        }
        int n = 1;
        String nowMax = chars[i] + "";
        while (i - n >= 0 && i + n <= chars.length - 1) {
            if (chars[i - n] == chars[i + n]) {
                nowMax = chars[i - n] + nowMax + chars[i + n];
                ++n;
            } else {
                break;
            }
        }
        return nowMax;
    }

    public static void main(String[] args) {
        LeetCode5 leetCode5 = new LeetCode5();
        String babad = leetCode5.longestPalindrome("cbbd");
        System.out.println(babad);
    }
}
