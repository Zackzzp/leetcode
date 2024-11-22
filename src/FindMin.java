public class FindMin {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        while(low<high){
            int privot=low+(high-low)/2;
            if (nums[privot]<nums[high])
                high=privot;
            else low=privot+1;
        }
        return nums[low];
    }
}
