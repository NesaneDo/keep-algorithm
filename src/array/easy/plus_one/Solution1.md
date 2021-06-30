将数组从后往前遍历，先将数组最后一位 +1，若有进位，则进位只可能是 1。

**参考代码：**

```java
public int[] plusOne(int[] digits) {
    int len=digits.length;
    for(int i=len-1;i>=0;i--){
        digits[i]++;
        digits[i]%=10;
        if (digits[i]!=0){
            return digits;
        }
    }
    digits=new int[len+1];
    digits[0]=1;
    return digits;
}
```

