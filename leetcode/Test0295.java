package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Mei Siman
 * @date 2021/1/19 15:48
 *
 * 295. 数据流的中位数
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 */
public class Test0295 {
    Queue<Integer> a,b;
    /** initialize your data structure here. */
    public Test0295() {
        a = new PriorityQueue<>();
        b = new PriorityQueue<>((x,y)->(y-x));
    }

    public void addNum(int num) {
        if (a.size()!=b.size()){
            a.add(num);
            b.add(a.poll());
        }else {
            b.add(num);
            a.add(b.poll());
        }
    }

    public double findMedian() {
        return a.size()!=b.size()?a.peek():(a.peek()+b.peek())/2.0;
    }
}
