package stack.easy.make_the_string_great;

import org.junit.Test;

/**
 * 在原字符串数组上修改
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @since 2021/6/17
 */
public class Solution2 {
    public String makeGood(String s) {
        int loc=-1;
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;++i){
            if (loc==-1||(chars[loc]^chars[i])!=32){
                chars[++loc]=chars[i];
            }else{
                ++loc;
            }
        }
        return String.copyValueOf(chars);
    }

    @Test
    public void test() {
        System.out.println(makeGood("BAab"));
    }
}
