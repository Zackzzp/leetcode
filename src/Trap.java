import java.util.*;

public class Trap {
    //双指针
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftmax = 0, rightmax = 0;
        while (left < right) {
            leftmax = Math.max(leftmax, height[left]);
            rightmax = Math.max(rightmax, height[right]);
            if (height[left] < height[right]) {
                ans += leftmax - height[left];
                left++;
            } else {
                ans += rightmax - height[right];
                right--;
            }

        }
        return ans;
    }

    //单调栈
    public int trap1(int[] height) {

    }
}
