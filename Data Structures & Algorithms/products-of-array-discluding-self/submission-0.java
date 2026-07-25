class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];
        int[] out = new int[nums.length];

        pref[0] = nums[0];
        suff[nums.length-1] = nums[nums.length-1];

        for(int i = 1; i < nums.length; i++) {
            pref[i] = pref[i-1] * nums[i];
            suff[nums.length - i - 1] = suff[nums.length - i] * nums[nums.length - i - 1];
        }

        out[0] = suff[1];
        out[nums.length -1] = pref[nums.length - 2];
        for(int i = 1; i < nums.length -1; i++){
            out[i] = pref[i-1] * suff[i+1];
        }
        return out;
    }
}  
