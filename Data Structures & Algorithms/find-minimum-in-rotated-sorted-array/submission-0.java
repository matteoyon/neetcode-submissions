class Solution {
    public int findMin(int[] nums) {
        int hi = nums.length-1;
        int lo = 0;
        int mid;

        while(lo < hi){
            mid = lo + (hi-lo)/2;
            if(nums[mid] > nums[hi])
                lo = mid+1;
            else
                hi = mid;
        }
        return nums[lo];
    }
}
