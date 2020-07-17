package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mei Siman
 * @date 2020/7/17 19:42
 *
 * 剑指 Offer 61. 扑克牌中的顺子
 *
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 */
public class Offer61 {
    public boolean isStraight(int[] nums){
        Set<Integer> repeat = new HashSet<>();
        int max=0,min=14;
        for (int num : nums) {
            if(num==0) continue;
            max = Math.max(num,max);
            min = Math.min(num,min);
            if(repeat.contains(num)) return false;
            repeat.add(num);
        }
        return max-min<5;
    }
}
