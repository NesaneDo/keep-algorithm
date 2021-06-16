package stack.easy.remove_all_adjacent_duplicates_in_string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * 使用栈
 * @author Rondo Chan
 * @desc 使用栈
 * @since 2021/6/16
 * @version 1.0.0
 */
public class Solution1 {
    public String removeDuplicates(String s) {
        Deque<Character> stack=new ArrayDeque<Character>();
        StringBuilder res=new StringBuilder();
        for(char c:s.toCharArray()){
            // 栈不为空并且栈顶元素和当前元素相同，则出栈
            if(!stack.isEmpty()&&stack.peek()==c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        // 遍历完成后，栈中剩下的元素就是结果的逆序，需要逆序遍历
        Iterator<Character> iterator=stack.descendingIterator();
        while(iterator.hasNext()){
            res.append(iterator.next());
        }
        return res.toString();
    }
}
