> **思路1：分类**
>
> 遇到 "../"，则步数 -1，最小为 0，遇到 "./" 不做处理，其他的则步数 +1。

> **参考代码：**

```java
public int minOperations(String[] logs) {
    int steps=0;
    for(String s:logs){
        if(s.equals("../")){
            steps-=steps>0?1:0;
        }else if(s.equals("./")){

        }else{
            steps++;
        }
    }
    return steps;
}
```

