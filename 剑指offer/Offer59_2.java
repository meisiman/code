package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Mei Siman
 * @date 2020/7/17 17:10
 *
 * 剑指 Offer 59 - II. 队列的最大值
 *
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 */
public class Offer59_2 {
    Queue<Integer> queue;
    LinkedList<Integer> max;
    public Offer59_2() {
        queue = new LinkedList<>();
        max = new LinkedList<>();//LinkedList是双端链表
    }

    public int max_value() {
        return max.size()==0?-1:max.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (max.size()!=0&&max.getLast()<value){
            max.removeLast();
        }
        max.add(value);
    }

    public int pop_front() {
        if(max.size()!=0&&queue.peek().equals(max.getFirst()))
            max.removeFirst();
        return queue.size()==0?-1:queue.poll();
    }
}
