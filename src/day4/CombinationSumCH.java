package day4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class CombinationSumCH {
	public static void main(String[] args) {
		CombinationSumCH ch = new CombinationSumCH();
		int[] candidates = new int[] { 2, 3,4, 6, 7 };
		int target = 7;
		System.out.println(ch.combinationSum(candidates, target));
	}

	/**
	 * 回溯
	 * 
	 * @author Rondo
	 * @date 2020年9月9日 上午7:15:26
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (candidates.length == 0) {
			return res;
		}
		Deque<Integer> path = new ArrayDeque<Integer>();
		Arrays.sort(candidates); // 排序，方便剪枝
		dfs(candidates, target, 0,path,res);
		return res;
	}

	public void dfs(int[] candidates, int target, int begin,Deque<Integer> path,List<List<Integer>> res) {
		if (target==0) {
			res.add(new ArrayList<Integer>(path));
			return;
		}
		for (int j = begin; j < candidates.length; j++) { // 
			if (target<candidates[j]) {
				break;
			}
			path.addLast(candidates[j]);
			dfs(candidates, target-candidates[j], j, path, res);
			path.removeLast();
		}
	}
}
