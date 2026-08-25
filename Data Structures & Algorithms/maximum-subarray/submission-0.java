class Solution {
    public int maxSubArray(int[] nums) {
        int best = Integer.MIN_VALUE;
        int actual = 0;

        for(int i=0; i < nums.length; i++){
            actual += nums[i];
            if(actual > best) best=actual;
            if(actual < 0) actual=0;
        }
        return best;
    }
}
