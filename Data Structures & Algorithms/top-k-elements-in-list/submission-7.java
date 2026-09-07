public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int n : nums) freq.merge(n,1,Integer::sum);

        List<Integer>[] sorted = new List[nums.length+1];
        for(Map.Entry<Integer,Integer> e : freq.entrySet()){
            if(sorted[e.getValue()] == null) sorted[e.getValue()] = new ArrayList<>();
            sorted[e.getValue()].add(e.getKey());
        }

        List<Integer> out = new LinkedList<>();
        int count = 0;
        int i = nums.length;
        while(i >= 0 && count<k){
            if(sorted[i]!=null){
                for(int n : sorted[i]){
                    out.addFirst(n);
                    count++;
                    if(count>=k) break;
                }
            }
            i--;
        }

        return out.stream().mapToInt(Integer::intValue).toArray();
    }
}