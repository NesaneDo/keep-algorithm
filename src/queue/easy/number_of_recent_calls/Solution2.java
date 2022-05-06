package queue.easy.number_of_recent_calls;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 使用队列
 * @author Rondo Chan
 * @desc 使用队列
 * @since 2022/5/6
 * @version 1.0.0
 */
public class Solution2 {
    Deque<Integer> queue = new LinkedList<>();
    public Solution2() {

    }

    public int ping(int t) {
        queue.addLast(t);
        while(!queue.isEmpty()&&queue.getFirst()<(t-3000)){
            queue.pollFirst();
        }
        return queue.size();
    }
}
