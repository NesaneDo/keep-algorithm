package stack.easy.remove_outermost_parentheses;

import org.junit.Test;

/**
 * 使用计数法
 * @author Rondo Chan
 * @desc 使用计数法
 * @since 2021/6/16
 * @version 1.0.0
 */
public class Solution2 {
    public String removeOuterParentheses(String s) {
        StringBuilder res=new StringBuilder();
        int count=0;
        for(char c:s.toCharArray()){
            if((c=='('&&count++>0)||(c==')'&&count-->1)){
                res.append(c);
            }
        }
        return res.toString();
    }


    @Test
    public void main() {
        System.out.println(removeOuterParentheses("(()())(())()()(())((()())())"));
    }
}
