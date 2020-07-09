package leetcode;

/**
 * @author Mei Siman
 * @date 2020/6/18 10:49
 *
 * 买卖股票的最佳时机
 */
public class Test0121 {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfile = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<minPrice)
                minPrice=prices[i];
            else if(prices[i]-minPrice>maxProfile)
                maxProfile=prices[i]-minPrice;
        }
        return maxProfile;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,5,2,3};
        System.out.println(maxProfit(prices));
    }
}
