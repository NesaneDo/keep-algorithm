> **思路1：计数器**
>
> 设置一个从 1 开始的计数器 count，遍历数组，
>
> 若当前数字小于 n 且不等于 count，则先 push 再 pop，不进行数组下一个遍历；
>
> 若等于 count 则只 push，并遍历数组中下一个数字

> **参考代码：**

```java
public List<String> buildArray(int[] target, int n) {
    ArrayList<String> list = new ArrayList<>();
    if (target==null||target.length==0||n==0){
        return list;
    }
    for(int count=1,i=0;count<=n;count++){
        if (i>target.length-1){
            break;
        }
        if(target[i]==count){
            list.add("Push");
            i++;
        }else{
            list.add("Push");
            list.add("Pop");
        }
    }
    return list;
}
```

