class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.merge(nums[i], 1, (a,b) -> a+b);
        }
        var entries = new LinkedList<Map.Entry<Integer,Integer>>(map.entrySet());
        entries.sort((a,b) -> Integer.compare(a.getValue(), b.getValue()));
        int[] toReturn = new int[k];
        for (int i = 0; i < k; i++){
            toReturn[i] = entries.get(entries.size()-(1+i)).getKey();
        }
        return toReturn;
    }
}
