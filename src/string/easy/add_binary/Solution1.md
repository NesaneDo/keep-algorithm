> 解法一：分情况讨论

使用一个两个字符串较长长度+1 的数组，用来记录从后往前求和之后的值，注意进位即可

**参考代码：**

```java
public String addBinary(String a, String b) {
    int lenA=a.length();
    int lenB=b.length();
    int len=Math.max(lenA,lenB);
    int minLen=Math.min(lenA,lenB);
    String c=lenA>lenB?a:b;
    String d=lenA>lenB?b:a;
    // 有可能进位，预留一位
    char[] chars=new char[len+1];
    for(int i=0;i<=len;i++){
        chars[i]='0';
    }
    boolean carry=false;
    for(int i=0;i<minLen;i++){
        if(c.charAt(len-i-1)=='1'&&d.charAt(minLen-i-1)=='1'){
            chars[len-i]=carry?'1':'0';
            carry=true;
        }else if(c.charAt(len-i-1)=='0'&&d.charAt(minLen-i-1)=='1'){
            chars[len-i]=carry?'0':'1';
        }else if(c.charAt(len-i-1)=='1'&&d.charAt(minLen-i-1)=='0'){
            chars[len-i]=carry?'0':'1';
        }else if(c.charAt(len-i-1)=='0'&&d.charAt(minLen-i-1)=='0'){
            chars[len-i]=carry?'1':'0';
            carry=false;
        }
    }
    for(int i=len-minLen-1;i>=0;i--){
        if(c.charAt(i)=='1'){
            chars[i+1]=carry?'0':'1';
        }else if (c.charAt(i)=='0'){
            chars[i+1]=carry?'1':'0';
            carry=false;
        }
    }
    chars[0]=carry?'1':'0';
    int index=carry?0:1;
    return new String(chars,index,chars.length-index);
}
```

$$
\begin{cases}时间复杂度：O(n)，n为字符串较长的长度 \\\\ 空间复杂度：O(n+1)，n为字符串较长的长度\end{cases}
$$

