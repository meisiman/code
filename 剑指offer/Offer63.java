package offer;

/**
 * @author Mei Siman
 * @date 2020/7/18 13:03
 *
 * 剑指 Offer 63. 股票的最大利润
 * leetcode121
 *
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class Offer63 {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE,max=0;
        for (int i=0;i<prices.length;i++){
            if(prices[i]<min) min=prices[i];
            if(prices[i]-min>max) max=prices[i]-min;
        }
        return max;
    }
}
