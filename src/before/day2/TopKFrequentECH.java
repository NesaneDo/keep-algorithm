package before.day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TopKFrequentECH {
	public static void main(String[] args) {
		TopKFrequentECH topKFrequentE = new TopKFrequentECH();
//		int[] nums = new int[] { 1,1,1,2,2,2,2,2,3,3,3,3 };
		int[] nums = new int[] { -1, 1, 4, -4, 3, 5, 4, -2, 3, -1 };
		int[] res = topKFrequentE.topKFrequent(nums, 3);

		System.out.println(Arrays.toString(res));
	}

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) { // 使用 HashMap 来记录各个数字出现的次数
			if (map.containsKey(i)) {
				int x = map.get(i);
				map.put(i, ++x);
			} else {
				map.put(i, 1);
			}
		}
		// 题目要求时间复杂度必须优于 O(nlogn)，所以可以使用归并排序或堆排序
		// 1 使用归并排序

		// 2 使用堆排序（升序：大顶堆、降序：小顶堆）
		int[][] values = new int[map.size()][2];
		int i = 0;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			values[i][0] = entry.getKey();
			values[i++][1] = entry.getValue();
		}
		buildMaxHeap(values);
		for (int j = 0; j < values.length; j++) {
			System.out.println(Arrays.toString(values[j]));
		}
		int[] res = new int[k];
		for (int j = values.length - 1, n = 0; j >= 0 && n < k; j--, n++) {
			res[n] = values[j][0];
		}
		return res;
	}

	private void buildMaxHeap(int[][] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) { // 从第一个非叶子节点开始调整，从下到上，从右到左
			int fi = (i - 1) / 2;
			while (arr[i][1] > arr[fi][1]) {
				swap(arr, fi, i);
				i = fi;
				fi = (i - 1) / 2;
			}
		}
		while (len > 1) {
			swap(arr, 0, len-1);
			heapify(arr, 0, --len);
		}
	}

	/**
	 * 创建堆继而得到堆顶的最大值
	 * 
	 * @author Rondo
	 * @date 2020年9月7日 下午8:02:26
	 * @param arr 源数组
	 * @param i   当前元素索引
	 * @param len 数组长度
	 */
	private void heapify(int[][] arr, int i, int len) {
		int m = i; // 当前节点索引
		int left = 2 * i + 1; // 左子节点索引
		int right = left + 1; // 右子节点索引
		while (left < len) {
			if (right < len && arr[left][1] < arr[right][1]) {
				m = right;
			} else {
				m = left;
			}
			if (arr[i][1] > arr[m][1]) {
				m = i;
			}
			if (m == i) {
				break;
			}
			swap(arr, i, m);
			i = m;
			left = 2 * i + 1;
			right = left + 1;
		}
	}

	private void swap(int[][] arr, int i, int j) {
		int[] t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
