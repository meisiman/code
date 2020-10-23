package leetcode;

/**
 * @author Mei Siman
 * @date 2020/10/23 10:06
 *
 * 461. 汉明距离
 *
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 */
public class Test0461 {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int distance = 0;
        while (xor!=0){
            distance++;
            xor=xor&(xor-1);
        }
        return distance;
    }
}
