package leetcode;

import java.util.*;

/**
 * @author Mei Siman
 * @date 2020/10/15 15:54
 *
 * 347. 前 K 个高频元素
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class Test0347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });
        for (int key : map.keySet()) {
            if (pq.size()<k) pq.add(key);
            else if (map.get(key)>map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        //List<Integer> res = new ArrayList<>();
        //while (!pq.isEmpty()) res.add(pq.remove());
        //return res;

        int[] res = new int[k];
        int i=k-1;
        while (!pq.isEmpty()){
            res[i--]=pq.remove();
        }
        return res;
    }
}
