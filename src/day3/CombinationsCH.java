package day3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Rondo rondo_eleven@163.com
 * @version
 * @date 2020年9月8日 上午7:49:31
 */
public class CombinationsCH {

	public static void main(String[] args) {
		CombinationsCH combinations = new CombinationsCH();
		System.out.println(combinations.combine(4, 3));
	}

	public List<List<Integer>> combine(int n, int k) {
		return solution1(n, k);
	}

	/**
	 * 解法一：回溯 + 剪枝
	 * 
	 * @author Rondo
	 * @date 2020年9月8日 上午7:51:34
	 * @param n
	 * @param k
	 * @return
	 */
	List<List<Integer>> res=new ArrayList<List<Integer>>();
	List<Integer> tmp=new ArrayList<Integer>();
	public List<List<Integer>> solution1(int n, int k) {
		dfs(1, n, k);
		return res;
	}

	private void dfs(int cur, int n, int k) {
		// 剪枝：tmep 长度 + [cur,n] 的长度小于 k，不可能构造出长度为 k 的temp
		if (tmp.size()+(n-cur+1)<k) {
			return;
		}
		// 添加
		if (tmp.size()==k) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		// 从当前位置继续搜索
		tmp.add(cur);
		dfs(cur+1, n, k);
		// 不考虑当前位置
		tmp.remove(tmp.size()-1);
		dfs(cur+1, n, k);
	}

}
