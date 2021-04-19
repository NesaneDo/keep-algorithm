package stack.baseball_game;

import org.junit.Test;

/**
 * @author Rondo Chan
 * @version 1.0.0
 * @description 直接在原数组上修改
 * @since 2021/4/19 8:58
 */
public class Solution1 {
    public int calPoints(String[] ops) {
        if (null == ops || ops.length == 0) {
            throw new IllegalArgumentException();
        }
        if (ops.length == 1) {
            return Integer.parseInt(ops[0]);
        }
        int num = 0;
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "+":
                    int j = i;
                    while (true) {
                        if (!"0".equals(ops[--j])) {
                            int t = Integer.parseInt(ops[j]);
                            while (true) {
                                if (!"0".equals(ops[--j])) {
                                    ops[i] = String.valueOf(t + Integer.parseInt(ops[j]));
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                case "D":
                    int k = i;
                    while (true) {
                        if (!"0".equals(ops[--k])) {
                            ops[i] = String.valueOf(Integer.parseInt(ops[k]) * 2);
                            break;
                        }
                    }
                    break;
                case "C":
                    int l = i;
                    while (true) {
                        if (!"0".equals(ops[--l])) {
                            ops[l] = "0";
                            break;
                        }
                    }
                    ops[i] = "0";
                    break;
                default:
                    break;
            }
        }
        for (String n : ops) {
            System.out.print(n + " ");
            num += Integer.parseInt(n);
        }
        System.out.println();
        return num;
    }

    @Test
    public void test() {
        System.out.println();
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
        System.out.println();
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println();
        System.out.println(calPoints(new String[]{"-60", "D", "-36", "30", "13", "C", "C", "-33", "53", "79"}));
    }
}
