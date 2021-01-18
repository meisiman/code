package leetcode;

import java.util.Random;

/**
 * @author Mei Siman
 * @date 2021/1/17 21:38
 *
 * 384. 打乱数组
 *
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 */
public class Test0384 {
    private int[] array;
    private int[] original;
    Random rand = new Random();

    private int randRange(int min,int max){
        return rand.nextInt(max-min)+min;
    }

    private void swapAt(int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Test0384(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i,randRange(i,array.length));
        }
        return array;
    }
}
