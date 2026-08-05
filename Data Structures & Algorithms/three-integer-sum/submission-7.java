class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new LinkedList<>();
        Arrays.sort(nums);
        int a;
        int b;
        for(int i=0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            a = i+1;
            b = nums.length-1;
            while(a<b){
                if(nums[i] == -(nums[a]+nums[b])){
                    out.add(List.of(nums[i],nums[a],nums[b]));
                    a++;
                    b--;
                    while (a<b && nums[a] == nums[a-1]){
                        a++;
                    }
                } else if(nums[i] < -(nums[a]+nums[b])){
                    a++;
                } else {
                    b--;
                }
            }
        }
        return out;
    }
}
