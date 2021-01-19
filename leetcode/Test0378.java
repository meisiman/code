package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Mei Siman
 * @date 2021/1/19 16:22
 *
 * 378. 有序矩阵中第K小的元素
 *
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 */
public class Test0378 {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> queue = new PriorityQueue<>((x,y)->(y-x));//大顶堆
        for (int[] row : matrix) {
            for (int num : row) {
                queue.add(num);
                if (queue.size()>k) queue.poll();
            }
        }
        return queue.peek();
    }
}
