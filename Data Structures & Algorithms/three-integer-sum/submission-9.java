class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new LinkedList<>();
        int a = 0;
        int b = 0;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++){
            if(nums[i]>0)
                break;
            if(i > 0 && nums[i]==nums[i-1])
                continue;

            a = i+1;
            b = nums.length-1;

            while(a<b){
                int sum = nums[i]+nums[a]+nums[b];
                
                if(sum<0){
                    a++;
                }else if (sum>0){
                    b--;
                }else{
                    out.add(List.of(nums[i],nums[a],nums[b]));
                    a++;
                    b--;
                    while(a<b && nums[a]==nums[a-1])
                        a++;
                }
            }
        }
        return out;
    }
}
