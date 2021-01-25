package leetcode;

import java.util.*;

/**
 * @author Mei Siman
 * @date 2021/1/25 19:56
 *
 * 380. 常数时间插入、删除和获取随机元素
 *
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 *
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回
 */
public class Test0380 {
    List<Integer> list = new ArrayList<>();
    Map<Integer,Integer> map = new HashMap<>();
    Random random = new Random();

    /** Initialize your data structure here. */
    public Test0380() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val);
        int last = list.get(list.size()-1);
        list.set(idx,last);
        list.remove(list.size()-1);
        map.put(last,idx);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
