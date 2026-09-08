/*
nums=[-1,0,1,2,-1,-4]
-4,-1,-1,0,1,2
    i       
       l   
             r
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);

        int i = 0;
        while(i < nums.length-2){
            while(i>0 && nums[i]==nums[i-1] && i<nums.length-2) i++;
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                if(nums[l] + nums[r] == -nums[i]) {
                    out.add(new ArrayList<>(List.of(nums[i],nums[l],nums[r]))); 
                    l++;
                    while(nums[l]==nums[l-1] && l<r) l++;
                }
                else if(nums[l] + nums[r] < -nums[i]) l++;
                else r--;
            }
            i++;
        }

        return out;
    }
}
