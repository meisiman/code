package offer;

/**
 * @author Mei Siman
 * @date 2020/7/17 19:04
 *
 * 剑指 Offer 60. n个骰子的点数
 *
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 */
public class Offer60 {
    public double[] twoSum(int n) {
        double pre[] = {1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
        for (int i=2;i<=n;i++){
            double tmp[] = new double[5*i+1];
            for (int j = 0; j < pre.length; j++) {
                for (int x=0;x<6;x++)
                    tmp[j+x]+=pre[j]/6;
            }
            pre=tmp;
        }
        return pre;
    }
}
