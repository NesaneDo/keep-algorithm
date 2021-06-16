> 思路1：在原数组上修改

这题乍一看像后缀表达式的类型，想直接用栈，并且本题也是在 LeetCode 中“栈”的分类下的，但是简单分析下发现并不能像后缀表达式那样简单。

ok，进入正题，第一种方法：直接在原数组上修改。
1. 遍历数组，若当前为数字，不用处理，进行下一次循环
2. 若当前为 "C"，从当前位置往前找第一个不为 "0" 的数字，将其赋值为 "0"，并把当前的 "C" 也赋值为 "0"
3. 若当前为 "D"，从当前位置往前找第一个不为 "0" 的数字 t，把当前的 "D" 赋值为 t*2 的值
4. 若当前为 "+"，从当前位置往前找第一个不为 "0" 的数字 p1，p1 的索引为 i1,再从 i1-1 往前找不为 "0" 的数字 p2，把当前的 "+" 赋值为 p1+p2 的值
5. 重新遍历一次数组，求和

**时间复杂度： O(n)**  
**空间复杂度： O(1)**

>参考代码

```java
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
```