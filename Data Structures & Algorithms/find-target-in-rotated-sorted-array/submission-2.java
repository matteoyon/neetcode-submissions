class Solution {
    public int search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length-1;
        int start = 0;
        int len = nums.length;
        int mid;

        while(lo<hi){
            mid = lo + (hi-lo)/2;
            if(nums[mid]>nums[hi]) lo = mid+1;
            else hi = mid;
        }
        
        start = lo;
        lo = 0;
        hi = nums.length-1;

        while(lo<=hi){
            mid = lo + (hi-lo)/2;
            if(nums[(mid+start)%len]==target){
                return (mid+start)%len;
            } else if (nums[(mid+start)%len]<target) {
                lo = mid+1;
            } else{
                hi = mid-1;
            }
        }

        return -1;
        
    }

    
}
