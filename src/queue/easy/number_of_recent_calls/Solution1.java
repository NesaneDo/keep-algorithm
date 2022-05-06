package queue.easy.number_of_recent_calls;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 933. 最近的请求次数
 * @author Rondo Chan
 * @desc LeetCode 933. 最近的请求次数
 * @since 2022/5/6
 * @version 1.0.0
 */
public class Solution1 {
    /**
     * ping method calls count
     */
    int count = 0;
    int lastVisitedIdx = 0;
    List<Integer> list=new LinkedList<>();
    public Solution1() {

    }

    public int ping(int t) {
        // add new t first
        list.add(t);
        // from last visited index, compare (t - 3000) and list.get(i), records count of list.get(i) < (t - 3000)
        for(int i = lastVisitedIdx; i < list.size(); i++) {
            if(list.get(i) < (t - 3000)){
                lastVisitedIdx = i + 1;
            }else{
                break;
            }
        }
        // return list.size() - lastVisitedIdx
        return list.size() - lastVisitedIdx;
    }
}
