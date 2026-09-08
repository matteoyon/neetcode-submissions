class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] cresc = new int[nums.length];
        int[] dec = new int[nums.length];
        int[] res = new int[nums.length];
        cresc[0] = nums[0];
        dec[nums.length-1] = nums[nums.length-1];
        for(int i = 1; i<nums.length; i++){
            cresc[i] = cresc[i-1]*nums[i];
            dec[nums.length-1-i] = dec[nums.length-i]*nums[nums.length-1-i];
        }
        res[0] = dec[1];
        res[nums.length-1] = cresc[nums.length-2];
        for(int i = 1; i<nums.length-1; i++){
            res[i] = cresc[i-1]*dec[i+1];
        }
        return res;
    }
}  
