public class Rotate {
    //环状替换
//    回到初始位置 0 时，有些数字可能还没有遍历到，此时我们应该从下一个数字开始重复的过程，可是这个时候怎么才算遍历结束呢？我们不妨先考虑这样一个问题：从 0 开始不断遍历，最终回到起点 0 的过程中，我们遍历了多少个元素？
//
//    由于最终回到了起点，故该过程恰好走了整数数量的圈，不妨设为 a 圈；再设该过程总共遍历了 b 个元素。因此，我们有 an=bk，即 an 一定为 n,k 的公倍数。又因为我们在第一次回到起点时就结束，因此 a 要尽可能小，故 an 就是 n,k 的最小公倍数 lcm(n,k)，因此 b 就为 lcm(n,k)/k。
//
//    这说明单次遍历会访问到 lcm(n,k)/k 个元素。为了访问到所有的元素，我们需要进行遍历的次数为
//
//
//n/lcm(n,k)=nk/lcm(n,k) =gcd(n,k)
//    其中 gcd 指的是最大公约数。

    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        int count=gcd(n,k);

        for (int start = 0; start < count; start++) {
            int current=start;
            int prev=nums[start];
            do {
                int next=(current+k)%n;
                int temp=nums[next];
                nums[next]=prev;
                prev=temp;
                current=next;
            }while(start!=current);
        }

    }
    public int gcd(int x, int y){
        return y>0? gcd(y,x%y):x;
    }
    public void rotate1(int []nums,int k){
        int n=nums.length;
        k%=n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);

    }
    public void reverse(int []nums,int start,int end){
        while (start<end){
        int temp=nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
        start+=1;
        end-=1;}
    }

}
