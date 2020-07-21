package leetcode;

/**
 * @author Mei Siman
 * @date 2020/6/28 11:19
 */
public class Test0011 {
    public int maxArea(int[] height) {
        int first = 0;
        int last = height.length - 1;
        int ans = 0;
        while(first<last){
            int area=Math.min(height[first],height[last])*(last-first);
            ans=Math.max(area,ans);
            if(height[first]<=height[last])
                ++first;
            else --last;
        }
        return ans;
    }
}
