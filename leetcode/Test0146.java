package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Mei Siman
 * @date 2020/8/20 14:16
 *
 * 146. LRU缓存机制
 */
public class Test0146 extends LinkedHashMap<Integer,Integer> {
    private int capacity;

    public Test0146(int capacity) {
        super(capacity,0.75F,true);
        this.capacity=capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
