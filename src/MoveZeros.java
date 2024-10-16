import java.security.cert.CRLException;

public class MoveZeros
{
    public void moveZeroes(int[] nums) {
        int n=nums.length,left=0,right=0;
        while(right<n){
            if (nums[right]!=0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }

    }
    private void swap(int[]nums,int left,int right){
        int temp;
        temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}