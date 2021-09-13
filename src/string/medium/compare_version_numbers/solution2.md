> 解法一：切割字符串

依次判断后，不为 0 的更长的字符串则更大

**参考代码：**

```java
public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int len=Math.min(str1.length,str2.length);
        int i=0;
        for(;i<len;i++){
            int i1 = Integer.parseInt(str1[i]);
            int i2 = Integer.parseInt(str2[i]);
            if(i1>i2){
                return 1;
            }
            if(i2>i1){
                return -1;
            }
        }
        boolean b = str1.length > str2.length;
        String [] str=b?str1:str2;
        for (;i<str.length;i++){
            if(0!=Integer.parseInt(str[i])){
                return b ?1:-1;
            }
        }
        return 0;
    }
```

