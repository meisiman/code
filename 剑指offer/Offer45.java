package offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Mei Siman
 * @date 2020/7/15 12:51
 *
 * 剑指 Offer 45. 把数组排成最小的数
 *
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 小顶堆
 */
public class Offer45 {
    public String minNumber(int[] nums) {
        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //字典序列小的放在堆顶
                return (o1+o2).compareTo(o2+o1);
            }
        });
        for (int num : nums) {
            queue.add(""+num);
        }
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()){
            res.append(queue.poll());
        }
        return res.toString();
    }
}
