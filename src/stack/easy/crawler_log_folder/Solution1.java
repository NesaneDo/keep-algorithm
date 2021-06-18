package stack.easy.crawler_log_folder;

/**
 * 分类讨论
 * @author Rondo Chan
 * @desc
 * @since 2021/6/18
 * @version 1.0.0
 */
public class Solution1 {
    public int minOperations(String[] logs) {
        int steps=0;
        for(String s:logs){
            if(s.equals("../")){
                steps-=steps>0?1:0;
            }else if(s.equals("./")){

            }else{
                steps++;
            }
        }
        return steps;
    }
}
