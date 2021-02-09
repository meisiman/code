package leetcode;

/**
 * @author Mei Siman
 * @date 2021/2/9 20:11
 *
 * 134. 加油站
 *
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 */
public class Test0134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur=0;
        int sum=0;
        int res=0;
        for (int i = 0; i < gas.length; i++) {
            sum+=gas[i]-cost[i];
            cur+=gas[i]-cost[i];
            if (cur<0){
                res=i+1;
                cur=0;
            }
        }
        return sum<0?-1:res;
    }
}
