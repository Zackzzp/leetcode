public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
    int n =nums.length;
    return quickselect(nums,0,n-1,n-k);
    }

    //快速排序
    int quickselect(int []nums,int l,int r,int k){
        if (l==r)
            return nums[k];
        int x=nums[l],i=l-1,j=r+1;
        while (i<j){
            do i++;while (nums[i]<x);
            do j--;while (nums[j]>x);
            if (i<j){
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
            }
        }
        if (k<=j)
            return quickselect(nums,l,j,k);
        else return quickselect(nums,j+1,r,k);
    }

    //堆排序

    public int finKthLargest1(int []nums,int k){
        int heapSize=nums.length;
        buildMaxHeap(nums,heapSize);
        for (int i = nums.length-1; i >=nums.length-k+1; i--) {
            swap(nums,0,i);
            --heapSize;
            maxHeapify(nums,0,heapSize);
        }
        return nums[0];
    }
    public void buildMaxHeap(int []a,int heapSize){
        for (int i = heapSize/2-1; i >=0 ; i++) {
            maxHeapify(a,i,heapSize);
        }
    }

    private void maxHeapify(int[] a, int i, int heapSize) {
        int l=2*i+1,r=2*i+2,largest=i;
        if (l<heapSize&&a[l]>a[largest])
            largest=l;
        if (r<heapSize&&a[r]>a[largest])
            largest=r;
        if (largest!=i){
            swap(a,i,largest);
            maxHeapify(a,largest,heapSize);
        }
    }

    public void swap(int []a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

}
