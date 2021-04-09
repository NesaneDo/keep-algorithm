package before.day16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JewelsAndStones {
	public static void main(String[] args) {
		JewelsAndStones jewelsAndStones = new JewelsAndStones();
		jewelsAndStones.numJewelsInStones("aA", "aaAbdA");
	}

	/**
	 * 暴力枚举
	 * 
	 * @author Rondo
	 * @date 2020年10月2日 上午7:17:39
	 * @param J
	 * @param S
	 * @return
	 */
	public int numJewelsInStones(String J, String S) {
		int count = 0;
		for (int i = 0; i < J.length(); i++) {
			for (int j = 0; j < S.length(); j++) {
				if (J.charAt(i) == S.charAt(j))
					count++;
			}
		}
		return count;
	}

	/**
	 * 使用 HashSet 或 HashMap 将 J 的各个字符保存起来
	 * @author Rondo
	 * @date 2020年10月2日 上午7:26:51
	 * @param J
	 * @param S
	 * @return
	 */
	public int numJewelsInStones2(String J, String S) {
		int count = 0;
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < J.length(); i++) {
			set.add(J.charAt(i));
		}
		for (int j = 0; j < S.length(); j++) {
			if (set.contains(S.charAt(j))) {
				count++;
			}
		}
		return count;
	}

}
