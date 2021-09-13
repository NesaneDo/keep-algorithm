> 解法一：使用 ascii 

前后各获取一个字符，使用它们各自的 ascii 来判断两个字符是否相同

**参考代码：**

```java
public boolean isPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return true;
        }
        for (int i = 0, j = len - 1; i <= j; ) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (c1 == c2) {
                i++;
                j--;
                continue;
            }
            if (c1 <= 57 && c1 >= 48) {

            } else if (c1 >= 97 && c1 <= 122) {
                c1 -= 32;
            } else if (c1 >= 65 && c1 <= 90) {
            } else {
                i++;
                continue;
            }
            if (c2 <= 57 && c2 >= 48) {
                if(c1!=c2){
                    return false;
                }
            } else if (c2 >= 97 && c2 <= 122) {
                c2 -= 32;
            } else if (c2 >= 65 && c2 <= 90) {
            } else {
                j--;
                continue;
            }
            // System.out.println(c1);
            // System.out.println(c2);
            // System.out.println();
            if (c1 == c2) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
```

