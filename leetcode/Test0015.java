package leetcode;

import java.util.*;

/**
 * @author Mei Siman
 * @date 2020/6/12 17:17
 */
public class Test0015 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        // 枚举 a
        for (int i = 0; i < nums.length; ++i) {
            // 需要和上一次枚举的数不相同
            if(i>0&&nums[i]==nums[i-1])
                continue;
            // c 对应的指针初始指向数组的最右端
            int k=nums.length-1;
            int target=-nums[i];
            // 枚举 b
            for (int j=i+1;j<nums.length;++j){
                // 需要和上一次枚举的数不相同
                if(j>i+1&&nums[j]==nums[j-1])
                    continue;
                // 需要保证 b 的指针在 c 的指针的左侧
                while(j<k&&nums[j]+nums[k]>target)
                    k--;
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if(j==k) break;
                if(nums[j]+nums[k]==target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }
}
