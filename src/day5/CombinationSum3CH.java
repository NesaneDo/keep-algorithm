package day5;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3CH {
	public static void main(String[] args) {
		CombinationSum3CH combinationSum3CH = new CombinationSum3CH();
		System.out.println(combinationSum3CH.combinationSum3(3, 9));
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (k == 0) {
			return res;
		}
		if (k == 1) {
			list.add(n);
			res.add(new ArrayList<Integer>(list));
			return res;
		}
		dfs(res, list, k, n, 1);
		return res;
	}

	private void dfs(List<List<Integer>> res, List<Integer> list, int k, int n, int begin) {
		if (list.size() == k) { // 个数符合要求
			if (n == 0) { // 符合要求，添加一组
				res.add(new ArrayList<Integer>(list));
			}
			return;
		}
		for (int i = begin; i <= 9; i++) {
			list.add(i);
			dfs(res, list, k, n - i, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
