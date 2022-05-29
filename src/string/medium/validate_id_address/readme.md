### 题目

#### [468. Validate IP Address](https://leetcode.cn/problems/validate-ip-address/)

难度中等

Given a string `queryIP`, return `"IPv4"` if IP is a valid IPv4 address, `"IPv6"` if IP is a valid IPv6 address or `"Neither"` if IP is not a correct IP of any type.

**A valid IPv4** address is an IP in the form `"x1.x2.x3.x4"` where `0 <= xi <= 255` and `xi` **cannot contain** leading zeros. For example, `"192.168.1.1"` and `"192.168.1.0"` are valid IPv4 addresses while `"192.168.01.1"`, `"192.168.1.00"`, and `"192.168@1.1"` are invalid IPv4 addresses.

**A valid IPv6** address is an IP in the form `"x1:x2:x3:x4:x5:x6:x7:x8"` where:

- `1 <= xi.length <= 4`
- `xi` is a **hexadecimal string** which may contain digits, lowercase English letter (`'a'` to `'f'`) and upper-case English letters (`'A'` to `'F'`).
- Leading zeros are allowed in `xi`.

For example, "`2001:0db8:85a3:0000:0000:8a2e:0370:7334"` and "`2001:db8:85a3:0:0:8A2E:0370:7334"` are valid IPv6 addresses, while "`2001:0db8:85a3::8A2E:037j:7334"` and "`02001:0db8:85a3:0000:0000:8a2e:0370:7334"` are invalid IPv6 addresses.

 

**Example 1:**

```
Input: queryIP = "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".
```

**Example 2:**

```
Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".
```

**Example 3:**

```
Input: queryIP = "256.256.256.256"
Output: "Neither"
Explanation: This is neither a IPv4 address nor a IPv6 address.
```

 

**Constraints:**

- `queryIP` consists only of English letters, digits and the characters `'.'` and `':'`.



### 解法

1. 模拟

   没有特别的算法，按题目要求做即可

   **参考代码：**

   ```java
   class Solution {
       private static final String NEITHER = "Neither";
   
       public String validIPAddress(String queryIP) {
           String[] ipv4 = ("0" + queryIP + "0").split("\\.");
           String[] ipv6 = ("0" + queryIP + "0").split(":");
           if (ipv4.length == 4) {
               ipv4 = queryIP.split("\\.");
           }
           if (ipv6.length == 8) {
               ipv6 = queryIP.split(":");
           }
           if (ipv4.length == 4) {
               return ipv4(ipv4);
           } else if (ipv6.length == 8) {
               return ipv6(ipv6);
           } else {
               return NEITHER;
           }
       }
   
       String ipv4(String[] ipv4) {
           for (String ip : ipv4) {
               if (ip.length() > 1 && ip.startsWith("0")) {
                   return NEITHER;
               }
               try {
                   int i = Integer.parseInt(ip);
                   if (!(i >= 0 && i <= 255)) {
                       return NEITHER;
                   }
               } catch (NumberFormatException e) {
                   return NEITHER;
               }
           }
           return "IPv4";
       }
   
       String ipv6(String[] ipv6) {
           for (String ip : ipv6) {
               if (ip.length() < 1 || ip.length() > 4) {
                   return NEITHER;
               }
               for (char c : ip.toCharArray()) {
                   if (Character.isDigit(c) || Character.isLetter(c)) {
                       if (Character.isLowerCase(c) && c > 'f') {
                           return NEITHER;
                       } else if (Character.isUpperCase(c) && c > 'F') {
                           return NEITHER;
                       }
                   } else {
                       return NEITHER;
                   }
               }
           }
           return "IPv6";
       }
   }
   ```

   **复杂度：**
   $$
   \begin{cases}时间复杂度：O(n), n为字符串长度，因为会遍历每个字符 \\\\空间复杂度：O(n)，中间使用数组来分割字符串 \end{cases}
   $$
   