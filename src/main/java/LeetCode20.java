package main.java;

import java.util.Stack;

/**
 * @author sakura
 * @date: 2021/3/10 22:26
 * @description:
 */
public class LeetCode20 {
    /**
     * ()[]{}
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> characters = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                characters.push(c);
                continue;
            }
            if (characters.empty()) {
                return false;
            } else {
                char pop = characters.pop();
                if (c == ')')
                    if (pop != '(')
                        return false;
                if (c == ']')
                    if (pop != '[')
                        return false;
                if (c == '}')
                    if (pop != '{')
                        return false;
            }
        }
        return characters.empty();
    }
}
