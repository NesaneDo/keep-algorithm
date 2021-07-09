> 解法一：根据性质3

第 n 行的第 m 个数（从 0 开始编号）可表示为可以被表示为组合数 $C(n,m)$, 记作 $C^m_n$ 或 $(^n_m)$, 即为从 n 个不同元素中取 m 个元素的组合数。我们可以用公式来表示它：$C^m_n=\frac{n!}{m!\times(n-m)!}$，则有 $c^m_n = C^{m-1}_n \times \frac{n - m + 1}{m}$。

即 res[i] = res[i - 1] * res[rowIndex - i + 1] / i。

**注意：**在 i = 30 时会溢出，可以使用 `res[i] = (int)((long)res[i - 1] * res[rowIndex - i + 1] / i)` 或者 `res[i] = 1L * res[i - 1] * res[rowIndex - i + 1] / i` 解决。

> 参考代码：

```java
public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        int[] ints = new int[rowIndex + 1];
        if (rowIndex == 0) {
            ints[0] = 1;
        } else if (rowIndex == 1) {
            ints[0] = ints[1] = 1;
        } else {
            ints[0] = ints[rowIndex] = 1;
            for (int i = 1; i <= rowIndex / 2; i++) {
                ints[i] = ints[rowIndex - i] = (int) ((long) (ints[i - 1] * (rowIndex - i + 1) / i));
            }
        }
        for (int i : ints) {
            res.add(i);
        }
        return res;
    }
```



> **补充：杨辉三角特性**

1. 每行数字左右对称，由 1 开始逐渐变大再变小，并最终回到 1。

2. 第 n 行（从 0 开始编号）的数字有 n+1 项，前 n 行共有 $\frac{n(n+1)}{2}$ 个数。

3. 第 n 行的第 m 个数（从 0 开始编号）可表示为可以被表示为组合数 $C(n,m)$, 记作 $C^m_n$ 或 $(^n_m)$, 即为从 n 个不同元素中取 m 个元素的组合数。我们可以用公式来表示它：$C^m_n=\frac{n!}{m!\times(n-m)!}$

4. 每个数字等于上一行的左右两个数字之和，可用此性质写出整个杨辉三角。即第 n 行的第 i 个数等于第 n-1 行的第 i-1 个数和第 i 个数之和。这也是组合数的性质之一，即 $C^i_n=C^i_{n-1}+C^{i-1}_{n-1}$。

5. ${(a+b)^n}$ 的展开式（二项式展开）中的各项系数依次对应杨辉三角的第 n 行中的第一项。