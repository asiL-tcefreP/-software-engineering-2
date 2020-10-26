# 个人项目：论文查重

| 这个作业属于哪个课程|            |
| ---- | ---- | ---- |
|这个作业要求在哪里|  https://edu.cnblogs.com/campus/gdgy/Networkengineering1834/homework/11146   |
|   这个作业的目标   | 1.简单的自我介绍 <br/> 2.关于软工的五个问题       |
|   传送门   | https://github.com/asiL-tcefreP/-software-engineering-2/tree/master|


## 一、模块接口的设计与实现过程</br>
### 1.1 算法来源
>文本相似度计算常用于网页去重以及NLP里文本分析等场景。文本相似度，可以分为两种，一种是字面相似度，另一种是语义相似度。本文记录的是文本的字面相似度的计算及实现，语义相似度计算则需要海量数据去计算语义值，较为复杂。
最常用的且最简单的两种文本相似检测方法：局部敏感hash、余弦相似度

在本案例中，用到的是局部敏感hash(LSH)中的simhash。计算出simhash值后，再计算hash值得汉明距离，即可得到文本的相似程度。

**汉明距离：**</br>
定义：两个长度相同的字符串对应位字符不同的个数</br>
两个关键点：
- 长度相同
- 对应位字符不同
传送门: [SimHash详细介绍](https://blog.csdn.net/wxgxgp/article/details/104106867).

### 1.2 项目结构
![](https://img2020.cnblogs.com/blog/2191659/202010/2191659-20201026173653682-1930542398.png)
包含文件读写类以及算法的实现类

![](https://img2020.cnblogs.com/blog/2191659/202010/2191659-20201026183926601-1017452294.png)

方法的接口如下：
```java
package pers.fjl.papercheck.service;
/**
 * @program: PaperCheck
 *
 * @description: ${description}
 *
 * @author: Fang Jiale
 *
 * @create: 2020-10-24 17:05
 **/
import pers.fjl.papercheck.service.impl.SimHashImpl;

import java.math.BigInteger;
import java.util.List;

public interface SimHash {
    /**
     * SimHash模块
     * @return
     */
    BigInteger simHash();

    /**
     *计算哈希值
     * @param source
     * @return
     */
    BigInteger hash(String source);

    /**
     * 汉明距离
     * @param other
     * @return
     */
    int hammingDistance(SimHashImpl other);

    /**
     *计算汉明距离
     * @param str1
     * @param str2
     * @return
     */
    double getDistance(String str1, String str2);

    /**
     *获取特征值
     * @param simHashImpl
     * @param distance
     * @return
     */
    List subByDistance(SimHashImpl simHashImpl, int distance);
}

```
## 二、测试
### 2.1 单元测试
这次测试只完成了空指针异常的测试，还应包括读写文件错误异常的测试。（后面有时间再commit）

### 2.2 覆盖率
![](https://img2020.cnblogs.com/blog/2191659/202010/2191659-20201026182255925-975717860.png)
![](https://img2020.cnblogs.com/blog/2191659/202010/2191659-20201026182331871-1864415892.png)
![](https://img2020.cnblogs.com/blog/2191659/202010/2191659-20201026182400811-877545466.png)

## 三、性能检测
![](https://img2020.cnblogs.com/blog/2191659/202010/2191659-20201026221310972-1424759330.png)
![](https://img2020.cnblogs.com/blog/2191659/202010/2191659-20201026221321366-1834546884.png)
![](https://img2020.cnblogs.com/blog/2191659/202010/2191659-20201026221511753-1155279970.png)
对该性能分析工具的使用还不太熟练，但可以看见的是，使用了GC之后，char,与String依旧占据内存的大部分。
![](https://img2020.cnblogs.com/blog/2191659/202010/2191659-20201026221600780-1830362823.png)
