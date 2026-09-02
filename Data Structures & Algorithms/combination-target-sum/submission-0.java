class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        func(res, curr, nums, target, 0, 0);

        return res;
    }

    public void func(List<List<Integer>> res, List<Integer> curr, int[] candidates, int k, int index, int sum){
        if(sum == k) res.add(new ArrayList<Integer>(curr));
        if(sum >= k) return;

        for(; index < candidates.length; index ++){
            curr.add(candidates[index]);
            func(res, curr, candidates, k, index, sum+candidates[index]);
            curr.remove(curr.size()-1);
        }
    }
}
