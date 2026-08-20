class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        int mid;

        while(lo<=hi){
            mid = lo + (hi - lo)/2;
            if(target == nums[mid])
                return mid;
            if(target > nums[mid])
                lo = mid +1;
            else
                hi = mid -1;
        }
        return -1;
    }
}
