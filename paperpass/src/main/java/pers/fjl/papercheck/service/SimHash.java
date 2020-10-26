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
