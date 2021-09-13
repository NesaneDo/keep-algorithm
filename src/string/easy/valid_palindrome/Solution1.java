package string.easy.valid_palindrome;

import org.junit.Test;

public class Solution1 {
    public boolean isPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return true;
        }
        for (int i = 0, j = len - 1; i <= j; ) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (c1 == c2) {
                i++;
                j--;
                continue;
            }
            if (c1 <= 57 && c1 >= 48) {
            } else if (c1 >= 97 && c1 <= 122) {
                c1 -= 32;
            } else if (c1 >= 65 && c1 <= 90) {
            } else {
                i++;
                continue;
            }
            if (c2 <= 57 && c2 >= 48) {
                if(c1!=c2){
                    return false;
                }
            } else if (c2 >= 97 && c2 <= 122) {
                c2 -= 32;
            } else if (c2 >= 65 && c2 <= 90) {
            } else {
                j--;
                continue;
            }
            if (c1 == c2) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(isPalindrome(
                "Marge, let's \"[went].\" I await {news} telegram."));
    }
}
