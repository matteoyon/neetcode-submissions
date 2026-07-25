class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>((int)(nums.length / 0.75f) + 1);

        for(int i=0; i < nums.length; i++){
            Integer j = map.get(target-nums[i]);
            if(j!=null) return new int[]{j,i};
            map.put(nums[i],i);
        }

        return null;
    }
}
