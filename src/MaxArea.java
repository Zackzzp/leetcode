public class MaxArea {
    public int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int high = Math.min(height[left], height[right]);
            int weight = right - left;
            maxArea = Math.max(high * weight, maxArea);
            if (height[left] < height[right])
                left++;
            else right--;

        }
        return maxArea;
    }
}

